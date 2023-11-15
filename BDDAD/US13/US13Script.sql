CREATE OR REPLACE PROCEDURE register_harvest_operation(
    p_date IN OPERATION."date"%type,
    p_quantity IN OPERATION.QUANTITY%type,
    p_unity_id IN OPERATION.UNITYOFMEASUREMENTUNITYID%type,
    p_operation_type_id IN OPERATION.OPERATIONTYPEOPERATIONTYPEID%type,
    p_cycle_id IN OPERATION.PLANTATIONCYCLECYCLEID%type
)
AS

    v_opertionId Operation.operationid%type;


BEGIN

    SELECT OPERATIONID + 1 into v_opertionId FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;

    INSERT INTO Operation (operationID,
                           "date",
                           quantity,
                           UnityOfMeasurementunityID,
                           OperationTypeoperationTypeID,
                           PlantationCyclecycleID)
    VALUES (v_opertionId,
            p_date,
            p_quantity,
            p_unity_id,
            p_operation_type_id,
            p_cycle_id);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Harvest operation registered successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END register_harvest_operation;

