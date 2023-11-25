CREATE OR REPLACE FUNCTION RegisterHarvestOperation(
       p_plantationID IN OPERATION.PlantationplantationID%type,
       p_date IN OPERATION."date"%type
) RETURN NUMBER IS
       v_OperationID OPERATION.operationID%type;
BEGIN

SELECT OperationID + 1 INTO v_OperationID FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;

INSERT INTO Operation(operationID, "date", PlantationplantationID)
VALUES (v_OperationID, p_date, p_plantationID);

INSERT INTO Harvest(OperationoperationID2, quantity)
VALUES (v_OperationID, NULL);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Harvest operation registered successfully!');

RETURN 1;

EXCEPTION
    WHEN OTHERS THEN

        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' - ' || SQLERRM);
ROLLBACK;
RETURN -1;
END RegisterHarvestOperation;
/