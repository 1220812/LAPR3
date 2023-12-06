CREATE OR REPLACE PROCEDURE GetWateringDetails(
    IN start_date DATE,
    IN end_date DATE
)
AS
BEGIN
SELECT
    TO_CHAR(O."date", 'YYYY-MM') AS month,
    AP.parcelID,
    SUM(W.duration) AS totalWatering
FROM
    Watering W
    JOIN
    Operation O ON W.OperationoperationID2 = O.operationID
    JOIN
    IrrigationSector ISec ON W.IrrigationSectorsetorID = ISec.setorID
    JOIN
    AgriculturalParcel_Plantation APP ON O.PlantationplantationID = APP.PlantationplantationID
    JOIN
    AgriculturalParcel AP ON APP.AgriculturalParcelparcelID = AP.parcelID
WHERE
    O."date" BETWEEN TO_DATE('2000/01/01', 'yyyy-mm-dd') AND TO_DATE('2023/11/25', 'yyyy-mm-dd')
GROUP BY
    TO_CHAR(O."date", 'YYYY-MM'),
    AP.parcelID
ORDER BY
    month,
    AP.parcelID;
END;
/