SELECT
    AP.ParcelID AS "ID Parcela",
    AP.parcelDesignation AS "Parcela",
    P.comercialName AS "Nome do Produto",
    FT.formulationTypeName AS "Tipo de Fator",
    COUNT(DISTINCT P.productID) AS "Número de Fatores de Produção Aplicados"
FROM
    AgriculturalParcel AP
        JOIN Plantation PL ON AP.parcelID = PL.AgriculturalParcelparcelID
        JOIN Operation OP ON PL.cycleID = OP.PlantationCyclecycleID
        JOIN Product_Operation PO ON OP.operationID = PO.OperationoperationID
        JOIN Product P ON PO.ProductproductID = P.productID
        JOIN FormulationType FT ON P.FormulationTypeformulationTypeID = FT.formulationTypeID
WHERE
        OP."date" >= TO_DATE('06-10-2016','DD-MM-YYYY') AND OP."date" <= TO_DATE('29-10-2023','DD-MM-YYYY')
GROUP BY
    AP.ParcelID, AP.parcelDesignation, P.comercialName, FT.formulationTypeName;