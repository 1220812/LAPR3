SELECT
    AgriculturalParcel.parcelID,
    Species.speciesName,
    Harvest.quantity,
    Operation."date"
FROM
    AgriculturalParcel
JOIN
    AgriculturalParcel_Plantation ON AgriculturalParcel_Plantation.AgriculturalParcelparcelID = AgriculturalParcel.parcelID
JOIN
    Plantation ON Plantation.PlantationID =  AgriculturalParcel_Plantation.PlantationplantationID
JOIN
    Crop ON Crop.cropID = Plantation.CropcropID
JOIN
    Species ON Species.speciesID = Crop.SpeciesspeciesID
JOIN
    Operation ON Operation.PLANTATIONPLANTATIONID = Plantation.PLANTATIONID
JOIN
    Harvest ON Harvest.OperationoperationID2 = Operation.OPERATIONID

WHERE
    AgriculturalParcel.parcelID != 0
    AND Operation."date" BETWEEN TO_DATE('2000-01-07', 'YYYY-MM-DD') AND TO_DATE('2030-01-07', 'YYYY-MM-DD')
GROUP BY
    AgriculturalParcel.parcelID, Species.speciesName, Harvest.quantity, Operation."date";



