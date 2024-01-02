CREATE OR REPLACE TRIGGER trg_registar_operacao_log
AFTER INSERT ON operation
FOR EACH ROW
DECLARE
    Id NUMBER(10);
BEGIN
    SELECT NVL(MAX(log.logID) + 1, 1)
    INTO Id
    FROM log;

    INSERT INTO log (logID, instant, operationID)
    VALUES (Id, SYSTIMESTAMP, :NEW.operationID);
END trg_registar_operacao_log;
/

------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE TRIGGER trg_registar_mudanca_operacao_log
AFTER UPDATE ON operation
FOR EACH ROW
DECLARE
    Id NUMBER(10);
BEGIN
    IF :NEW.operationState <> :OLD.operationState THEN
        SELECT NVL(MAX(log.logID) + 1, 1)
        INTO Id
        FROM log;

        INSERT INTO log (logID, instant, operationID)
        VALUES (Id, SYSTIMESTAMP, :NEW.operationID);
    END IF;
END trg_registar_mudanca_operacao_log;
/
