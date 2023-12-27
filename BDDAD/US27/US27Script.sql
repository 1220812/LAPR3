CREATE OR REPLACE TRIGGER prevent_log_changes
BEFORE UPDATE OR DELETE ON Log
    FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'You are not allowed to update or delete the registers in this table!');
END;