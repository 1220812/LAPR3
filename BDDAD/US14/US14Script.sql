CREATE OR REPLACE FUNCTION fncFertilizationOperation
RETURN sys_refcursoe
AS
       l_refcur_FertilizationOperation sys_refcursor;
BEGIN
OPEN l_refcur_FertilizationOperation FOR
SELECT * from Fertilization;
RETURN l_refcur_FertilizationOperation;
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

CREATE OR REPLACE prcRegisterFertilizationOperation(
       p_operationID OPERATION.operationID%type
       p_productID PRODUCT.productID%type
       p_mode FERTILIZATION.Mode%type
)
       AS
       BEGIN
SELECT OperationID + 1 INTO p_operationID FROM OPERATION ORDER BY 1 DESC FETCH FIRST ROW ONLY;
       INSERT INTO Fertilization(OperationoperationID2, ProductproductID, Mode)
       VALUES(p_operationID, p_productID, p_mode);
        END;
        /