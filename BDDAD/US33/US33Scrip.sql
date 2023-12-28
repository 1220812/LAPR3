WITH TotalConsumo AS (
    SELECT C.cropID,
           SUM(W.duration) AS total_consumo_agua
FROM
    Watering W
JOIN
    Operation O ON O.operationID = W.operationID
JOIN
    Crop C ON C.cropID = W.cropID
WHERE
    EXTRACT(YEAR FROM operationDate) = 2023
GROUP BY
    C.cropID),
 MaxConsumo AS (
SELECT
    MAX(total_consumo_agua) AS max_consumo
FROM
    TotalConsumo
)
SELECT
    cropID, total_consumo_agua
FROM
    TotalConsumo
WHERE
    total_consumo_agua = (SELECT max_consumo FROM MaxConsumo);