SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION obterSubstanciasUsadas(
    p_ano IN NUMBER
)
RETURN SYS_REFCURSOR IS
  v_cursor SYS_REFCURSOR;

BEGIN
OPEN v_cursor FOR
SELECT
    pf.ProductionFactorID,
    pf.ComercialName,
    MIN(EXTRACT(YEAR FROM op.OperationDate)) AS AnoMin,
    MAX(EXTRACT(YEAR FROM op.OperationDate)) AS AnoMax
FROM
    ProductionFactor pf
        JOIN
    CropApplication CA ON pf.ProductionFactorID = CA.ProductionFactorID
        JOIN
    Operation op ON CA.operationID = op.operationID
WHERE
        EXTRACT(YEAR FROM op.OperationDate) <> p_ano OR op.OperationDate IS NULL
GROUP BY pf.ProductionFactorID, pf.ComercialName
ORDER BY pf.ComercialName;

RETURN v_cursor;
END obterSubstanciasUsadas;
/

DECLARE
v_cursor_result SYS_REFCURSOR;
    v_ProductionFactorID ProductionFactor.ProductionFactorID%TYPE;
    v_ComercialName ProductionFactor.ComercialName%TYPE;
    v_AnoMin NUMBER;
    v_AnoMax NUMBER;
    v_PrevComercialName ProductionFactor.ComercialName%TYPE := NULL;
    p_ano NUMBER := 2020;

BEGIN
    v_cursor_result := obterSubstanciasUsadas(p_ano);

    LOOP
FETCH v_cursor_result INTO
            v_ProductionFactorID,
            v_ComercialName,
            v_AnoMin,
            v_AnoMax;
        EXIT WHEN v_cursor_result%NOTFOUND;

SELECT ProductionFactorID
INTO v_ProductionFactorID
FROM ProductionFactor
WHERE ComercialName = v_ComercialName;

IF v_PrevComercialName IS NULL OR v_ComercialName <> v_PrevComercialName THEN
            DBMS_OUTPUT.PUT_LINE(' ');

            IF v_AnoMax IS NOT NULL AND v_AnoMin <> v_AnoMax THEN
                DBMS_OUTPUT.PUT_LINE('Nome Comercial: ' || TRIM(v_ComercialName));
                DBMS_OUTPUT.PUT('Ano de Aplica��o: '|| TRIM(v_AnoMin));

FOR i IN v_AnoMin..v_AnoMax LOOP
                    DECLARE
v_AplicacaoExiste NUMBER;
BEGIN
                        IF i <> p_ano THEN
SELECT COUNT(*)
INTO v_AplicacaoExiste
FROM CropApplication CA
         JOIN Operation op ON CA.operationID = op.operationID
WHERE op.operationID = v_ProductionFactorID
  AND EXTRACT(YEAR FROM op.OperationDate) = i;

IF v_AplicacaoExiste > 0 THEN
                                DBMS_OUTPUT.PUT(i || ' ');
END IF;
END IF;
END;
END LOOP;

                DBMS_OUTPUT.PUT_LINE('');
END IF;

            v_PrevComercialName := v_ComercialName;
END IF;

        DBMS_OUTPUT.PUT_LINE('Fator de Produ��o ID: ' || TRIM(v_ProductionFactorID));
END LOOP;
CLOSE v_cursor_result;
END;
/
