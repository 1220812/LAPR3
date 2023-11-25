-- Lista de operações na parcela para cada tipo de operação dentro do intervalo de tempo
SELECT
    AgriculturalParcel.parcelID,
    Species.speciesName || ' , ' || Species.commonname as PLANT,
    Operation."date",
    CASE
        WHEN Harvest.OperationoperationID2 IS NOT NULL THEN 'Harvest'
        WHEN Sowing.OperationoperationID2 IS NOT NULL THEN 'Sowing'
        WHEN Pruning.OperationoperationID2 IS NOT NULL THEN 'Pruning'
        WHEN Incorporation.OperationoperationID2 IS NOT NULL THEN 'Incorporation'
        WHEN Watering.OperationoperationID2 IS NOT NULL THEN 'Watering'
        WHEN ToPlant.OperationoperationID2 IS NOT NULL THEN 'ToPlant'
        WHEN Weed.OperationoperationID2 IS NOT NULL THEN 'Weed'
        WHEN Fertilization.OperationoperationID2 IS NOT NULL THEN 'Fertilization'
        ELSE 'Other'
        END AS tipo_operacao
FROM
    AgriculturalParcel
        JOIN
    AgriculturalParcel_Plantation ON AgriculturalParcel_Plantation.AgriculturalParcelparcelID = AgriculturalParcel.parcelID
        JOIN
    Plantation ON Plantation.PlantationID = AgriculturalParcel_Plantation.PlantationplantationID
        JOIN
    Crop ON Crop.cropID = Plantation.CropcropID
        JOIN
    Species ON Species.speciesID = Crop.SpeciesspeciesID
        JOIN
    Operation ON Operation.PLANTATIONPLANTATIONID = Plantation.PLANTATIONID
        LEFT JOIN
    Harvest ON Harvest.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Sowing ON Sowing.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Pruning ON Pruning.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Incorporation ON Incorporation.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Watering ON Watering.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    ToPlant ON ToPlant.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Weed ON Weed.OperationoperationID2 = Operation.OPERATIONID
        LEFT JOIN
    Fertilization ON Fertilization.OperationoperationID2 = Operation.OPERATIONID
WHERE
        AgriculturalParcel.parcelID = 102
  AND Operation."date" BETWEEN TO_DATE('2000-01-07', 'YYYY-MM-DD') AND TO_DATE('2030-01-07', 'YYYY-MM-DD')
ORDER BY
    Operation."date";
