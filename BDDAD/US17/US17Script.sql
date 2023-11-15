SELECT
    p.comercialName AS product_name,
    c.componentName,
    cd.quantity,
    o.date
FROM
    Product p
        JOIN
    Product_Operation po ON p.productID = po.ProductproductID
        JOIN
    Operation o ON po.OperationoperationID = o.operationID
        JOIN
    Component_Datasheet cd ON o.operationID = cd.OperationoperationID
        JOIN
    Component c ON cd.ComponentcomponentID = c.componentID
        JOIN
    UnityOfMeasurement u ON cd.UnityOfMeasurementunityID = u.unityID
WHERE
    o.date BETWEEN :start_date AND :end_date
  AND o.PlantationCyclecycleID IN (
    SELECT cycleID
    FROM Plantation
    WHERE AgriculturalParcelparcelID = :parcel_id
);