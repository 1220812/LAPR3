-- US BD10 Como Gestor Agrícola, pretendo saber qual a parcela com mais operações de rega num
-- dado intervalo de tempo.

WITH IrrigationCounts AS (
    SELECT
        ap.parcelID AS "Parcel ID",
        ap.parcelDesignation AS "Parcel designation",
        COUNT(o.operationID) AS "Number of irrigations",
        RANK() OVER (ORDER BY COUNT(o.operationID) DESC) AS rank
    FROM
        AgriculturalParcel ap
            LEFT JOIN Plantation p ON ap.parcelID = p.AgriculturalParcelparcelID
            LEFT JOIN Operation o ON p.cycleID = o.PlantationCyclecycleID
    WHERE
        o."date" BETWEEN TO_DATE('06-10-2016', 'DD-MM-YYYY') AND TO_DATE('29-10-2023', 'DD-MM-YYYY')
      AND o.OperationTypeoperationTypeID = 2 -- 2 is the operation type for irrigation
    GROUP BY
        ap.parcelID, ap.parcelDesignation
)
SELECT "Parcel ID", "Parcel designation", "Number of irrigations"
FROM IrrigationCounts
WHERE rank = 1;