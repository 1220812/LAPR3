-- US BD08 Como Gestor Agrícola, pretendo saber o fator de produção com mais aplicações na
-- instalação agrícola num dado intervalo de tempo.

SELECT
    p.comercialName AS "Product name",
    p.productID AS "Product ID",
    COUNT(po.OperationoperationID) AS "Number of applications"
FROM
    Product p
        LEFT JOIN
            Product_Operation po ON p.productID = po.ProductproductID
        LEFT JOIN
            Operation o ON po.OperationoperationID = o.operationID
WHERE
    o."date" BETWEEN TO_DATE('06-10-2016', 'DD-MM-YYYY') AND TO_DATE('29-10-2023', 'DD-MM-YYYY')
GROUP BY
    p.comercialName, p.productID
ORDER BY
    "Number of applications" DESC
FETCH FIRST 1 ROW ONLY;

