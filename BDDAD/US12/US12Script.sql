CREATE OR REPLACE FUNCTION fncWeedOperation
RETURN sys_refcursor
AS
       l_refcur_WeedOperation sys_refcursor;
BEGIN
OPEN l_refcur_WeedOperation FOR
SELECT * FROM Weed;
RETURN l_refcursor_WeedOperation;
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

CREATE OR REPLACE PROCEDURE prcRegisterWeedOperation(
    p_OperationID OPERATION.operationID%type;
)
       AS
       BEGIN
       INSERT INTO Weed (OperationoperationID2)
       VALUES(p_operationID);
        END;
        /
