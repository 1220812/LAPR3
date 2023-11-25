SELECT
    TO_DATE(O."date", 'YYYY-MM') AS month_year,
    AP.parcelID,
    SUM(O.quantity) AS total_irrigation
FROM
    Operation O
        JOIN
    Plantation P ON O.PlantationCyclecycleID = P.cycleID
        JOIN
    AgriculturalParcel AP ON P.AgriculturalParcelparcelID = AP.parcelID
WHERE
    O."date" BETWEEN TO_DATE('2023-01-01', 'YYYY-MM-DD') AND TO_DATE('2023-12-31', 'YYYY-MM-DD')
GROUP BY
    TO_DATE(O."date", 'YYYY-MM'),
    AP.parcelID
ORDER BY
    TO_DATE(O."date", 'YYYY-MM'),
    AP.parcelID;
