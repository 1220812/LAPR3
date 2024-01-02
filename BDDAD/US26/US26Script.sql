CREATE OR REPLACE TRIGGER Tgr_Create_Log
AFTER INSERT OR UPDATE ON Operation
FOR EACH ROW
DECLARE
    Id NUMBER(10);
BEGIN
    SELECT NVL(MAX(Log.logID) + 1, 1)
    INTO Id
    FROM Log;

    IF INSERTING THEN
        INSERT INTO Log (logID, instant, operationID)
        VALUES (Id, SYSTIMESTAMP, :NEW.operationID);
    ELSIF UPDATING THEN
        INSERT INTO Log (logID, instant, operationID)
        VALUES (Id, SYSTIMESTAMP, :OLD.operationID);
    END IF;
END;
/
