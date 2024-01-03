CREATE OR REPLACE PROCEDURE prcRegisterWateringOperation(
    p_operationID       IN Operation.operationID%TYPE,
    p_operationDate     IN Operation.operationDate%TYPE,
    p_operationState    IN Operation.operationState%TYPE,
    p_designation       IN Operation.designation%TYPE,
    p_cropID            IN Operation.cropID%TYPE,
    p_parcelID          IN Operation.parcelID%TYPE,
    p_duration          IN Watering.duration%TYPE,
    p_inicialHour       IN Watering.inicialHour%TYPE,
    p_setorID           IN Watering.setorID%TYPE,
    p_revenueID         IN Revenue.revenueID%TYPE
)
AS
  l_operationID         Operation.operationID%TYPE;
BEGIN

SELECT MAX(operationID) + 1 INTO l_operationID FROM Operation;

INSERT INTO Operation (operationID, operationDate, operationState, designation, cropID, parcelID)
VALUES (l_operationID, p_operationDate, p_operationState, p_designation, p_cropID, p_parcelID);

IF p_setorID IS NOT NULL AND p_inicialHour IS NOT NULL THEN
    INSERT INTO Watering (operationID, duration, inicialHour, setorID)
    VALUES (l_operationID, p_duration, p_inicialHour, p_setorID);
END IF;

IF p_setorID IS NOT NULL AND p_inicialHour IS NOT NULL AND p_revenueID IS NOT NULL THEN
    INSERT INTO Watering (operationID, duration, inicialHour, setorID)
    VALUES (l_operationID, p_duration, p_inicialHour, p_setorID);

INSERT INTO ProductionFactorApplication (revenueID, operationID)
VALUES (p_revenueID, l_operationID);
END IF;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Operação de Rega registada com sucesso.');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
ROLLBACK;
END;
/


DECLARE
l_message VARCHAR2(100);
BEGIN
  prcRegisterWateringOperation(

    p_operationID => 516,
    p_operationDate => TO_DATE('2023-01-01', 'YYYY-MM-DD'),
    p_operationState => NULL,
    p_designation => NULL,
    p_cropID => 1,
    p_parcelID => 101,
    p_duration => 5,
    p_inicialHour => 08.00,
    p_setorID => 10,
    p_revenueID => 10
  );

  l_message := 'Operação de Rega registada com sucesso.';
  DBMS_OUTPUT.PUT_LINE(l_message);
EXCEPTION
  WHEN OTHERS THEN
    l_message := 'Erro: ' || SQLERRM;
    DBMS_OUTPUT.PUT_LINE(l_message);
ROLLBACK;
END;
/