-- US BD07 Como Gestor Agrícola, pretendo saber o número de operações realizadas numa dada
-- parcela, para cada tipo de operação, num dado intervalo de tempo.

SELECT
    ap.parcelID AS "Parcel ID",
    ap.parcelDesignation AS "Parcel Designation",
    ot.operationTypeName AS "Operation type",
    COUNT(o.operationID) AS "Number of operations"
FROM
    Operation o
JOIN
    Plantation p ON o.PlantationCyclecycleID = p.cycleID
JOIN
    AgriculturalParcel ap ON p.AgriculturalParcelparcelID = ap.parcelID
JOIN
    OperationType ot ON o.OperationTypeoperationTypeID = ot.operationTypeID
WHERE
    p.startDate >= TO_DATE('06-10-2016', 'DD-MM-YYYY')
    AND p.endDate <= TO_DATE('28-10-2023', 'DD-MM-YYYY')
GROUP BY
    ap.parcelID, ap.parcelDesignation, ot.operationTypeName
ORDER BY
    "Parcel ID" ASC;