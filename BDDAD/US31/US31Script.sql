CREATE GLOBAL TEMPORARY TABLE NewTable
(
    ProductionFactor VARCHAR(255),
    Quantity Number(10)
) ON COMMIT DELETE ROWS;

CREATE OR REPLACE FUNCTION RevenueRegister(
    p_RevenueID NUMBER
)RETURN NUMBER AS
    p_ProductionFactorID NUMBER(20);
    p_ProductionFactorName VARCHAR2(255);
    p_Quantity FLOAT(10);
BEGIN
FOR rec IN (SELECT ProductionFactor, Quantity FROM NewTable)
        LOOP
            p_ProductionFactorName := rec.ProductionFactor;
SELECT productionFactorID INTO p_ProductionFactorID FROM ProductionFactor WHERE comercialname = p_ProductionFactorName;
p_Quantity := rec.Quantity;

INSERT INTO Revenue_ProductionFactor(revenueID, productionfactorid, quantity)
VALUES(p_RevenueID, p_ProductionFactorID, p_Quantity);

END LOOP;

COMMIT;
DBMS_OUTPUT.PUT_LINE('Revenue successfully registered');

    RETURN SQL%ROWCOUNT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Production factor not registered!');
ROLLBACK;
RETURN -1;
WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.put_line('Error: Revenue already registered');
ROLLBACK;
RETURN -2;
END RevenueRegister;
/

CREATE OR REPLACE TRIGGER NewRevenue
    BEFORE INSERT
    ON Revenue_ProductionFactor
    FOR EACH ROW
DECLARE
p_flag NUMBER;
BEGIN
SELECT COUNT(*)
INTO p_flag
FROM Revenue
WHERE Revenue.revenueid = :NEW.revenueID;

IF(p_flag = 0) THEN
BEGIN
INSERT INTO Revenue(revenueID) VALUES (:NEW.revenueID);
EXCEPTION
            WHEN OTHERS THEN
                NULL;
END;
END IF;
END;

DECLARE
v_RevenueID NUMBER := 14;
    X NUMBER;

BEGIN
INSERT INTO NewTable (ProductionFactor, Quantity)
VALUES('Tecniferti MOL', 60);

INSERT INTO NewTable (ProductionFactor, Quantity)
VALUES('Calda Bordalesa ASCENZA', 50);

x := RevenueRegister(v_RevenueID);

END;


