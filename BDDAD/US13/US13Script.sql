-- Criar ou substituir a procedimento armazenado
CREATE OR REPLACE PROCEDURE register_harvest_operation(
    p_operation_id      IN NUMBER,
    p_quantity           IN NUMBER,
    p_harvest_date       IN DATE
)
AS
BEGIN
    -- Inserir uma nova operação de colheita
    INSERT INTO Harvest (OperationoperationID2, quantity)
    VALUES (p_operation_id, p_quantity);

    -- Atualizar a data de colheita na tabela Operation
    UPDATE Operation
    SET "date" = p_harvest_date
    WHERE operationID = p_operation_id;

    -- Commit para confirmar a transação
    COMMIT;

    -- Exibir mensagem de sucesso
    DBMS_OUTPUT.PUT_LINE('Operação de colheita registrada com sucesso.');

EXCEPTION
    WHEN OTHERS THEN
        -- Exibir mensagem de erro se ocorrer uma exceção
        DBMS_OUTPUT.PUT_LINE('Erro ao registrar operação de colheita: ' || SQLERRM);
        -- Rollback em caso de erro
        ROLLBACK;
END register_harvest_operation;
/
