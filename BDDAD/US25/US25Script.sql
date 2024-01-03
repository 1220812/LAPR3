CREATE OR REPLACE TRIGGER US25

  BEFORE INSERT ON Operation
  FOR EACH ROW

DECLARE
v_last_operationID Operation.operationID%TYPE;
  exception1 EXCEPTION;

BEGIN
  -- Obtém o último ID
SELECT MAX(operationID) INTO v_last_operationID FROM Operation;

-- Atribui um novo ID
:NEW.operationID := COALESCE(v_last_operationID, 0) + 1;

  IF (v_last_operationID - :NEW.operationID) <= 0 THEN
    RAISE exception1;
END IF;

EXCEPTION
  WHEN exception1 THEN
    :NEW.operationID := v_last_operationID + 1;

END US25;


SET SERVEROUTPUT ON;
DECLARE
v_last_operationID Operation.operationID%TYPE;
    v_new_operationID Operation.operationID%TYPE;
    exception1 EXCEPTION;

BEGIN
    -- Obtém o último ID
SELECT MAX(operationID) INTO v_last_operationID FROM Operation;

-- Atribui um novo ID
v_new_operationID := v_last_operationID + 1;

    -- Verifica se há uma lacuna na numeração de operationID
    IF v_last_operationID IS NOT NULL AND v_new_operationID <> v_last_operationID + 1 THEN
        RAISE exception1;
ELSE
        -- Operação bem-sucedida
        DBMS_OUTPUT.PUT_LINE('Operação bem sucedida');
END IF;

EXCEPTION
    WHEN exception1 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Há uma lacuna na numeração de ID de operação');

WHEN OTHERS THEN
        RAISE;
END;
/