CREATE OR REPLACE PROCEDURE GetFertilizationComponents(IN parcel_id INT, IN start_date DATE, IN end_date DATE)
AS
BEGIN
SELECT
    p.comercialName AS Product_Name,
    c.componentName AS Component_Name,
    cd.quantity AS Quantity
FROM
    ApplicationType ap
        JOIN
    ApplicationType_Product ap_p ON ap.applicationID = ap_p.ApplicationTypeapplicationID
        JOIN
    Product p ON ap_p.ProductproductID = p.productID
        JOIN
    Fertilization f ON p.productID = f.ProductproductID
        JOIN
    Operation o ON f.OperationoperationID2 = o.operationID
        JOIN
    Component_Datasheet cd ON p.productID = cd.DatasheetcompositionID
        JOIN
    Component c ON cd.ComponentcomponentID = c.componentID
        JOIN
    AgriculturalParcel_Plantation_IrrigationSector ap_p_is ON o.PlantationplantationID = ap_p_is.AgriculturalParcel_PlantationPlantationplantationID
WHERE
        ap_p_is.AgriculturalParcel_PlantationAgriculturalParcelparcelID = :parcelID
        AND o.date BETWEEN :startDate AND :endDate;
END;
/