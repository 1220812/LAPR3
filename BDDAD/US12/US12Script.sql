CREATE OR REPLACE FUNCTION RegisterWeedOperation(
    p_plantationID IN OPERATION.PlantationplantationID%type,
    p_date IN OPERATION."date"%type
) RETURN NUMBER IS
    v_OperationID OPERATION.operationID%type;
BEGIN

SELECT OperationID + 1 INTO v_OperationID FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;

INSERT INTO Operation(operationID, "date", PlantationplantationID)
VALUES (v_OperationID, p_date, p_plantationID);

INSERT INTO Weed (OperationoperationID2)
VALUES (v_OperationID);

COMMIT;

DBMS_OUTPUT.PUT_LINE('Weed operation registered successfully!');

RETURN 1;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' - ' || SQLERRM);
        ROLLBACK;
RETURN -1;
END RegisterWeedOperation;
/
