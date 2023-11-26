CREATE OR REPLACE FUNCTION fncPruningOperation
RETURN sys_refcursor
AS
    l_refcur_PruningOperation sys_refcursor;
BEGIN
OPEN l_refcur_PruningOperation FOR
SELECT * from Pruning;
RETURN l_refcur_PruningOperation;
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

CREATE OR REPLACE prcRegisterPruningOperation(
       p_operationID OPERATION.operationID%type
)
       AS
       BEGIN
SELECT OperationID + 1 INTO p_operationID FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;
       INSERT INTO Pruning (OperationoperationID2)
       VALUES(p_operationID);
        END;
        /