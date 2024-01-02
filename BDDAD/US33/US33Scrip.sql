WITH TotalConsumo AS (
    SELECT
        C.cropID,
        SUM(W.duration) AS total_consumo_agua
    FROM
        Watering W
    JOIN
        Operation O ON O.operationID = W.operationID
    JOIN
        Crop C ON C.cropID = O.cropID
    WHERE
        EXTRACT(YEAR FROM O.operationDate) = 2023
    GROUP BY
        C.cropID
),
MaxConsumo AS (
    SELECT
        MAX(total_consumo_agua) AS max_consumo
    FROM
        TotalConsumo
)
SELECT
    TC.cropID,
    TC.total_consumo_agua
FROM
    TotalConsumo TC
JOIN
    MaxConsumo MC ON TC.total_consumo_agua = MC.max_consumo;
