CREATE OR REPLACE PROCEDURE anularOperacao(p_idOperacao IN NUMBER) AS
    v_dataOperacao DATE;
    v_podeAnular BOOLEAN := TRUE;
    v_idParcela NUMBER;
    v_idCultura NUMBER;
    v_dataInicialCultura DATE;
BEGIN
    -- Verifica se a operação pode ser anulada
    SELECT operationDate, parcelID, cropID
    INTO v_dataOperacao, v_idParcela, v_idCultura
    FROM Operation
    WHERE operationID = p_idOperacao;

    IF v_dataOperacao IS NOT NULL AND v_dataOperacao <= SYSDATE - 3 THEN
        -- Verifica se existem operações dependentes
        FOR dep_operacao IN (
            SELECT operationID
            FROM Operation
            WHERE parcelID = v_idParcela
              AND cropID = v_idCultura
              AND operationState = 'concluido'
              AND operationDate > v_dataOperacao
            ) LOOP
                v_podeAnular := FALSE;
                EXIT; -- Sai do loop assim que encontrar uma operação dependente
            END LOOP;

        IF v_podeAnular THEN
            -- Anula a operação
            UPDATE Operation
            SET operationState = 'anulado'
            WHERE operationID = p_idOperacao;

            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Operação anulada com sucesso.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Não é possível anular a operação. Existem operações dependentes.');
        END IF;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Não é possível anular a operação. A data prevista é inválida ou ultrapassou o prazo de 3 dias.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Operação não encontrada.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Ocorreu um erro ao processar a operação.');
END anularOperacao;




