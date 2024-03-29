SELECT
    PLANTATION.AGRICULTURALPARCELPARCELID AS AGRICULTURAL_PARCEL_ID,
    SPECIES.COMMONNAME  || ' ' || CROP.VARIETY AS PLANT,
    SUM(PLANTATION.QUANTITY) AS QUANTITY,
    UNITYOFMEASUREMENT.NAME AS UNITY

FROM PLANTATION
         JOIN CROP ON CROP.CROPID = PLANTATION.CROPCROPID
         JOIN SPECIES ON SPECIES.SPECIESID = CROP.SPECIESSPECIESID
         JOIN UNITYOFMEASUREMENT ON UNITYOFMEASUREMENT.UNITYID = PLANTATION.UNITYOFMEASUREMENTUNITYID

WHERE
        PLANTATION.AGRICULTURALPARCELPARCELID !=0
  AND PLANTATION.startDate BETWEEN TO_DATE('2000-01-07', 'YYYY-MM-DD') AND TO_DATE('2030-07-31', 'YYYY-MM-DD')

GROUP BY
    PLANTATION.AGRICULTURALPARCELPARCELID,
    SPECIES.COMMONNAME,
    CROP.VARIETY,
    UNITYOFMEASUREMENT.NAME
