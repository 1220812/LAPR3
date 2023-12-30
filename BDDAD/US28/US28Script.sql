CREATE TABLE CanceledOperations (
                                    operationID NUMBER(10) NOT NULL,
                                    cancelationDate DATE,
                                    cancelationReason VARCHAR2(255),
                                    PRIMARY KEY (operationID)
);

-- Fertigation Trigger antes da exclusão
-- Impede a exclusão direta de registros em Fertigation, permitindo apenas a anulação.
CREATE OR REPLACE TRIGGER prevent_delete_fertigation
BEFORE DELETE ON Fertigation
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Não é possível excluir diretamente uma Fertigation. Utilize a anulação.');
END;
/

-- Trigger após a exclusão para Fertigation
CREATE OR REPLACE TRIGGER after_delete_fertigation
AFTER DELETE ON Fertigation
FOR EACH ROW
DECLARE
cancelationReason CONSTANT VARCHAR2(255) := 'Fertigation anulada';
BEGIN
INSERT INTO CanceledOperations (operationID, cancelationDate, cancelationReason)
VALUES (:old.operationID, SYSDATE, cancelationReason);
END;

--Mobilization
/-- Trigger antes da exclusão para Mobilization
CREATE OR REPLACE TRIGGER prevent_delete_mobilization
BEFORE DELETE ON Mobilization
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Não é possível excluir diretamente uma Mobilization. Utilize a anulação.');
END;
/
-- Trigger após a exclusão para Mobilization
CREATE OR REPLACE TRIGGER after_delete_mobilization
AFTER DELETE ON Mobilization
FOR EACH ROW
DECLARE
cancelationReason CONSTANT VARCHAR2(255) := 'Mobilization anulada';
BEGIN
INSERT INTO CanceledOperations (operationID, cancelationDate, cancelationReason)
VALUES (:old.operationID, SYSDATE, cancelationReason);
END;

--ParcelApplication
/-- Trigger antes da exclusão para ParcelApplication
CREATE OR REPLACE TRIGGER prevent_delete_parcel_application
BEFORE DELETE ON ParcelApplication
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Não é possível excluir diretamente uma ParcelApplication. Utilize a anulação.');
END;
/

-- Trigger após a exclusão para ParcelApplication
CREATE OR REPLACE TRIGGER after_delete_parcel_application
AFTER DELETE ON ParcelApplication
FOR EACH ROW
DECLARE
cancelationReason CONSTANT VARCHAR2(255) := 'ParcelApplication anulada';
BEGIN
INSERT INTO CanceledOperations (operationID, cancelationDate, cancelationReason)
VALUES (:old.operationID, SYSDATE, cancelationReason);
END;

--CropApplication
/-- Trigger antes da exclusão para CropApplication
CREATE OR REPLACE TRIGGER prevent_delete_crop_application
BEFORE DELETE ON CropApplication
FOR EACH ROW
BEGIN
    RAISE_APPLICATION_ERROR(-20001, 'Não é possível excluir diretamente uma CropApplication. Utilize a anulação.');
END;
/

-- Trigger após a exclusão para CropApplication
CREATE OR REPLACE TRIGGER after_delete_crop_application
AFTER DELETE ON CropApplication
FOR EACH ROW
DECLARE
cancelationReason CONSTANT VARCHAR2(255) := 'CropApplication anulada';
BEGIN
INSERT INTO CanceledOperations (operationID, cancelationDate, cancelationReason)
VALUES (:old.operationID, SYSDATE, cancelationReason);
END;
/