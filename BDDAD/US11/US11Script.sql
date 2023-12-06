CREATE OR REPLACE FUNCTION fncSowingOperation
RETURN sys_refcursor
AS
       l_refcur_SowinfOperation sys_refcursor;
BEGIN
OPEN l_refcur_SowingOperation FOR
SELECT * from Sowing;
RETURN l_refcur_SowingOperation;
END;
/

CREATE OR REPLACE prcRegisterOperation(
       p_operationID OPERATION.operationID%type
       p_plantationID OPERATION.PlantationplantationID%type,
       p_date OPERATION."date"%type
       )
       AS
       BEGIN
SELECT OperationID + 1 INTO p_operationID FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;
       INSERT INTO Operation(operationID, date, PlantationplantationID)
       VALUES (p_operationID, p_date, p_plantationID);
        END;
/

CREATE OR REPLACE prcRegisterSowingOperation(
       p_operationID OPERATION.operationID%type
)
       AS
       BEGIN
       INSERT INTO Sowing (OperationoperationID2)
       VALUES(p_operationID);
        END;
        /
