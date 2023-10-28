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
    Plantation P ON
