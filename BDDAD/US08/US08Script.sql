-- US BD08 Como Gestor Agrícola, pretendo saber o fator de produção com mais aplicações na
-- instalação agrícola num dado intervalo de tempo.
<<<<<<< HEAD
SELECT
    OT.operationTypeName AS Fator_De_Producao,
    COUNT(O.operationID) AS Numero_De_Aplicacoes
FROM
    Operation O
    JOIN OperationType OT ON O.OperationTypeoperationTypeID = OT.operationTypeID
WHERE
    o."date" BETWEEN TO_DATE('06-10-2016', 'DD-MM-YYYY') AND TO_DATE('29-10-2023', 'DD-MM-YYYY')
GROUP BY
    OT.operationTypeName
ORDER BY
    Numero_De_Aplicacoes DESC;
