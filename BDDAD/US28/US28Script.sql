-- Tabela para armazenar o histórico de operações anuladas
CREATE TABLE CanceledOperation (
                                   operationID number(10) NOT NULL,
                                   cancelationDate date,
                                   PRIMARY KEY (operationID)
);

-- Trigger para verificar e anular operações antes de serem excluídas
CREATE OR REPLACE TRIGGER PreventOperationDeletion
    BEFORE DELETE ON Operation
    FOR EACH ROW
DECLARE
    v_operation_state varchar2(30);
BEGIN
    -- Verifica o estado da operação
    SELECT operationState INTO v_operation_state
    FROM Operation
    WHERE operationID = :OLD.operationID;

    -- Se a operação estiver no estado 'Anulado', permita a exclusão
    IF v_operation_state = 'Anulado' THEN
        NULL; -- Não faz nada, permite a exclusão
    ELSE
        -- Se não estiver anulada, anula a operação e registra no histórico
        INSERT INTO CanceledOperation (operationID, cancelationDate)
        VALUES (:OLD.operationID, SYSDATE);

        -- Atualiza o estado da operação para 'Anulado'
        UPDATE Operation
        SET operationState = 'Anulado'
        WHERE operationID = :OLD.operationID;

        -- Impede a exclusão da operação
        RAISE_APPLICATION_ERROR(-20001, 'Operações não podem ser excluídas, apenas anuladas.');
    END IF;
END;
/