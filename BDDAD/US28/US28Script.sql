-- Trigger to prevent the deletion of an operation
CREATE OR REPLACE TRIGGER trg_prevent_delete_operation
    BEFORE DELETE ON Operation
    FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Cannot delete an operation. Use operation cancellation instead.');
END trg_prevent_delete_operation;
/

SET SERVEROUTPUT ON;
DECLARE
    v_operationID NUMBER(10) := 17; -- Replace with the desired operation ID
    v_logID NUMBER;

BEGIN
    BEGIN
        -- Attempt to cancel the operation
        UPDATE Operation
        SET operationState = 'CANCELED'
        WHERE operationID = v_operationID;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Operation canceled successfully.');

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error while canceling the operation: ' || SQLERRM);
    END;

    -- Log the cancellation
    BEGIN
        SELECT MAX(logID) INTO v_logID FROM Log;
        v_logID := NVL(v_logID, 0) + 1;

        INSERT INTO Log (logID, instant, operationID)
        VALUES (v_logID, CURRENT_TIMESTAMP, v_operationID);

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Cancellation logged successfully. Log ID: ' || v_logID);

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error while logging the cancellation: ' || SQLERRM);
    END;

END;
/
