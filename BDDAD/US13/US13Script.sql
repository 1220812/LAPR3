CREATE OR REPLACE FUNCTION fncHarvestOperation
RETURN sys_refcursor
AS
       l_refcur_SowinfOperation sys_refcursor;
BEGIN
OPEN l_refcur_HarvestOperation FOR
SELECT * from harvest;
RETURN l_refcur_HarvestOperation;
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

CREATE OR REPLACE prcRegisterHarvestOperation(
       p_operationID OPERATION.operationID%type,
       quantity HARVEST.quantity%type
)
       AS
       BEGIN
       INSERT INTO Harvest (OperationoperationID2, quantity)
       VALUES(p_operationID, quantity);
        END;
        /