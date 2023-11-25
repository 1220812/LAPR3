CREATE OR REPLACE PROCEDURE register_pruning_operation(
       p_plantation_id IN NUMBER,
       p_pruning_date IN DATE
) RETURN NUMBER IS
       v_operation_id NUMBER;
BEGIN
        INSERT INTO Operation VALUES (operationID, "date", PlantationplantationID);
        return 1;

        INSERT INTO Pruning VALUES (OperationoperationID2);
        return 1;

EXCEPTION
    WHEN OTHERS THEN RETURN 0;
END insert_pruning_operation;
