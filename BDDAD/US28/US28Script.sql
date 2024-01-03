-- USBD28
-- Add the column without CHECK constraint
ALTER TABLE Operation
    ADD operationState varchar2(225) DEFAULT 'PENDING';
-- Add CHECK constraint separately
ALTER TABLE Operation
    ADD CONSTRAINT chk_status CHECK (operationState IN ('PENDING', 'CANCELED'));
-- Assuming 'PENDING' is the default status for new operations


-- Trigger to cancel an operation and log the cancellation in the DB
CREATE OR REPLACE TRIGGER trg_cancel_operation
    BEFORE DELETE ON Operation
    FOR EACH ROW
DECLARE
    v_idLog NUMBER;
BEGIN
    -- Check if the operation is already canceled
    IF :OLD.operationState = 'CANCELED' THEN
        DBMS_OUTPUT.PUT_LINE('Cancellation Status: Operation already canceled.');
    ELSE
        -- Get the last ID from the Log table
        SELECT MAX(logID) INTO v_idLog FROM Log;

        -- Increment the ID
        v_idLog := v_idLog + 1;

        DBMS_OUTPUT.PUT_LINE('Cancellation Status: CANCELED. New Log ID: ' || v_idLog);

        -- Prevent the operation from being deleted
        RAISE_APPLICATION_ERROR(-20000, 'Operations cannot be deleted, only canceled. Cancellation Status: CANCELED. New Log ID: ' || v_idLog);
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        -- Handle other exceptions if necessary
        RAISE_APPLICATION_ERROR(-20000, 'Error processing trigger: ' || SQLERRM);
END;
/

-- PL/SQL block to test the trigger
SET SERVEROUTPUT ON;

DECLARE
    v_idOperation NUMBER(10) := 15; -- Substitua pelo ID da operação desejada
    v_idLog NUMBER;

BEGIN
    -- Tente excluir a operação (o acionador será disparado)
    BEGIN
        DELETE FROM Operation
        WHERE operationID = v_idOperation;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Operation canceled successfully.');

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error trying to delete the operation: ' || SQLERRM);
    END;

    -- Não é necessário verificar novamente se a operação existe após a exclusão bem-sucedida.

    -- Get the last ID from the Log table
    SELECT MAX(logID) INTO v_idLog FROM Log;

    -- Increment the ID
    v_idLog := v_idLog + 1;

    DBMS_OUTPUT.PUT_LINE('Cancellation Status: CANCELED. New Log ID: ' || v_idLog);

    -- Tentar registrar o cancelamento na tabela Log sem levantar uma exceção
    BEGIN
        INSERT INTO Log (logID, instant, operationID)
        VALUES (v_idLog, CURRENT_TIMESTAMP, v_idOperation);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Operation canceled successfully. New status: CANCELED. New Log ID: ' || v_idLog);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error trying to log the cancellation in the Log table: ' || SQLERRM);
    END;
END;

