SELECT
    A.applicationID,
    P.comercialName AS productName,
    AP.parcelID,
    C.cropID AS cropID,
    O."date" AS operationDate
FROM
    ApplicationType A
        JOIN
    ApplicationType_Product AP ON A.applicationID = AP.ApplicationTypeapplicationID
        JOIN
    Product P ON AP.ProductproductID = P.productID
        JOIN
    Fertilization F ON P.productID = F.ProductproductID
        JOIN
    Operation O ON F.OperationoperationID2 = O.operationID
        JOIN
    Plantation PL ON O.PlantationplantationID = PL.plantationID
        JOIN
    AgriculturalParcel_Plantation APP ON PL.plantationID = APP.PlantationplantationID
        JOIN
    AgriculturalParcel AP ON APP.AgriculturalParcelparcelID = AP.parcelID
        JOIN
    Crop C ON PL.CropcropID = C.cropID
WHERE
        P.productID = 4
  AND O."date" BETWEEN TO_DATE('2000/01/01', 'yyyy-mm-dd') AND TO_DATE('2023/11/25', 'yyyy-mm-dd');

