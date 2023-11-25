SELECT
    AP.parcelID,
    C.componentName,
    CD.quantity,
    O."date"
FROM
    AgriculturalParcel AP
        JOIN
    AgriculturalParcel_Plantation APP ON AP.parcelID = APP.AgriculturalParcelparcelID
        JOIN
    AgriculturalParcel_Plantation_IrrigationSector APS ON APP.AgriculturalParcelparcelID = APS.AgriculturalParcel_PlantationAgriculturalParcelparcelID
        AND APP.PlantationplantationID = APS.AgriculturalParcel_PlantationPlantationplantationID
        JOIN
    Operation O ON APP.PlantationplantationID = O.PlantationplantationID
        JOIN
    Fertilization F ON O.operationID = F.OperationoperationID2
        JOIN
    Component_Datasheet CD ON F.ProductproductID = CD.DatasheetcompositionID
        JOIN
    Component C ON CD.ComponentcomponentID = C.componentID
WHERE
    O."date" BETWEEN TO_DATE('2023-01-01', 'yyyy-mm-dd') AND TO_DATE('2023-12-31', 'yyyy-mm-dd');
