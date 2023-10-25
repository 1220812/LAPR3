-- **Creation of Tables**

CREATE TABLE AgriculturalParcel (
                                    parcelID                  number(20) GENERATED AS IDENTITY,
                                    parcelDesignation         varchar2(40),
                                    area                      number(30),
                                    FarmfarmID                number(10) NOT NULL,
                                    UnityOfMeasurementunityID number(10) NOT NULL,
                                    PRIMARY KEY (parcelID));
CREATE TABLE ApplicationType (
                                 applicationID   number(10) GENERATED AS IDENTITY,
                                 applicationName number(40),
                                 PRIMARY KEY (applicationID));
CREATE TABLE Building (
                          buildingID                    number(20) GENERATED AS IDENTITY,
                          designation                   varchar2(40),
                          area                          number(20),
                          "Building TypebuildingTypeID" number(20) NOT NULL,
                          UnityOfMeasurementunityID     number(10) NOT NULL,
                          FarmfarmID                    number(10) NOT NULL,
                          PRIMARY KEY (buildingID));
CREATE TABLE BuildingType (
                              buildingTypeID number(20) GENERATED AS IDENTITY,
                              typeName       varchar2(40),
                              PRIMARY KEY (buildingTypeID));
CREATE TABLE Classification (
                                classificationID   number(20) GENERATED AS IDENTITY,
                                classificationName varchar2(40),
                                PRIMARY KEY (classificationID));
CREATE TABLE Component (
                           componentID   number(10) GENERATED AS IDENTITY,
                           componentName number(10),
                           PRIMARY KEY (componentID));
CREATE TABLE Component_Datasheet (
                                     ComponentcomponentID      number(10) NOT NULL,
                                     DatasheetcompositionID    number(20) NOT NULL,
                                     quantity                  number(10),
                                     UnityOfMeasurementunityID number(10) NOT NULL,
                                     PRIMARY KEY (ComponentcomponentID,
                                                  DatasheetcompositionID));
CREATE TABLE Crop (
                      cropID                number(20) GENERATED AS IDENTITY,
                      variety               varchar2(40),
                      "Crop TypeCropTypeID" number(20) NOT NULL,
                      "Crop CyclecycleID"   number(20) NOT NULL,
                      SpeciesspeciesID      number(10) NOT NULL,
                      PRIMARY KEY (cropID));
CREATE TABLE CropCycle (
                           cycleID   number(20) GENERATED AS IDENTITY,
                           startDate date,
                           endDate   date,
                           PRIMARY KEY (cycleID));
CREATE TABLE CropType (
                          CropTypeID number(20) GENERATED AS IDENTITY,
                          typeName   varchar2(40),
                          PRIMARY KEY (CropTypeID));
CREATE TABLE Datasheet (
                           compositionID     number(20) GENERATED AS IDENTITY,
                           ProductproductID2 number(20) NOT NULL,
                           PRIMARY KEY (compositionID));
CREATE TABLE FormulationType (
                                 formulationTypeID   number(20) GENERATED AS IDENTITY,
                                 formulationTypeName varchar2(40),
                                 PRIMARY KEY (formulationTypeID));
CREATE TABLE Manufacturer (
                              manufacturerID number(10) GENERATED AS IDENTITY,
                              name           varchar2(40),
                              PRIMARY KEY (manufacturerID));
CREATE TABLE Operation (
                           operationID                  number(10) GENERATED AS IDENTITY,
                           "mode"                       number(10),
                           "date"                       date,
                           quantity                     number(10),
                           UnityOfMeasurementunityID    number(10) NOT NULL,
                           OperationTypeoperationTypeID number(10) NOT NULL,
                           PlantationCyclecycleID       number(10) NOT NULL,
                           PRIMARY KEY (operationID));
CREATE TABLE OperationType (
                               operationTypeID   number(10) GENERATED AS IDENTITY,
                               operationTypeName number(10),
                               PRIMARY KEY (operationTypeID));
CREATE TABLE Plantation (
                            plantationID               number(10) GENERATED AS IDENTITY,
                            startDate                  date,
                            endDate                    date,
                            quantity                   number(10),
                            AgriculturalParcelparcelID number(20) NOT NULL,
                            UnityOfMeasurementunityID  number(10) NOT NULL,
                            CropcropID                 number(20) NOT NULL,
                            PRIMARY KEY (plantationID));
CREATE TABLE Product (
                         productID                        number(20) NOT NULL,
                         comercialName                    varchar2(40),
                         ClassificationclassificationID   number(20) NOT NULL,
                         FormulationTypeformulationTypeID number(20) NOT NULL,
                         ManufacturermanufacturerID       number(10) NOT NULL,
                         PRIMARY KEY (productID));
CREATE TABLE Product_ApplicationType (
                                         ProductproductID             number(20) NOT NULL,
                                         ApplicationTypeapplicationID number(10) NOT NULL,
                                         PRIMARY KEY (ProductproductID,
                                                      ApplicationTypeapplicationID));
CREATE TABLE ProductionFactor (
                                  factorID number(20) GENERATED AS IDENTITY,
                                  PRIMARY KEY (factorID));
CREATE TABLE ProductionFactor_AgriculturalParcel (
                                                     ProductionFactorfactorID   number(20) NOT NULL,
                                                     AgriculturalParcelparcelID number(20) NOT NULL,
                                                     PRIMARY KEY (ProductionFactorfactorID,
                                                                  AgriculturalParcelparcelID));
CREATE TABLE ProductionFactor_Product (
                                          ProductionFactorfactorID number(20) NOT NULL,
                                          ProductproductID         number(20) NOT NULL,
                                          PRIMARY KEY (ProductionFactorfactorID,
                                                       ProductproductID));
CREATE TABLE Species (
                         speciesID        number(10) GENERATED AS IDENTITY,
                         speciesName      varchar2(40),
                         commonName       varchar2(40),
                         plantationPeriod varchar2(40),
                         pruningPeriod    varchar2(40),
                         floweringPeriod  varchar2(40),
                         harverstPeriod   varchar2(40),
                         PRIMARY KEY (speciesID));

-- **Alter tables**

CREATE TABLE UnityOfMeasurement (
                                    unityID number(10) GENERATED AS IDENTITY,
                                    name    varchar2(10) NOT NULL,
                                    PRIMARY KEY (unityID));
ALTER TABLE Product_ApplicationType ADD CONSTRAINT FKProduct_Ap603034 FOREIGN KEY (ApplicationTypeapplicationID) REFERENCES ApplicationType (applicationID);
ALTER TABLE Product_ApplicationType ADD CONSTRAINT FKProduct_Ap233441 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation239203 FOREIGN KEY (CropcropID) REFERENCES Crop (cropID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_773772 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Operation ADD CONSTRAINT FKOperation92443 FOREIGN KEY (PlantationCyclecycleID) REFERENCES Plantation (plantationID);
ALTER TABLE ProductionFactor_AgriculturalParcel ADD CONSTRAINT FKProduction634442 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE ProductionFactor_AgriculturalParcel ADD CONSTRAINT FKProduction472320 FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);
ALTER TABLE Operation ADD CONSTRAINT FKOperation62574 FOREIGN KEY (OperationTypeoperationTypeID) REFERENCES OperationType (operationTypeID);
ALTER TABLE Operation ADD CONSTRAINT FKOperation5286 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation272550 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation374211 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop394614 FOREIGN KEY (SpeciesspeciesID) REFERENCES Species (speciesID);
ALTER TABLE AgriculturalParcel ADD CONSTRAINT FKAgricultur310538 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_576098 FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_180622 FOREIGN KEY (ComponentcomponentID) REFERENCES Component (componentID);
ALTER TABLE Product ADD CONSTRAINT FKProduct587362 FOREIGN KEY (ClassificationclassificationID) REFERENCES Classification (classificationID);
ALTER TABLE Datasheet ADD CONSTRAINT FKDatasheet527132 FOREIGN KEY (ProductproductID2) REFERENCES Product (productID);
ALTER TABLE Product ADD CONSTRAINT FKProduct109633 FOREIGN KEY (ManufacturermanufacturerID) REFERENCES Manufacturer (manufacturerID);
ALTER TABLE Building ADD CONSTRAINT FKBuilding701038 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Product ADD CONSTRAINT FKProduct433814 FOREIGN KEY (FormulationTypeformulationTypeID) REFERENCES FormulationType (formulationTypeID);
ALTER TABLE ProductionFactor_Product ADD CONSTRAINT FKProduction858580 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE ProductionFactor_Product ADD CONSTRAINT FKProduction50584 FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);
ALTER TABLE Building ADD CONSTRAINT FKBuilding729922 FOREIGN KEY ("Building TypebuildingTypeID") REFERENCES BuildingType (buildingTypeID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop643859 FOREIGN KEY ("Crop CyclecycleID") REFERENCES CropCycle (cycleID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop651425 FOREIGN KEY ("Crop TypeCropTypeID") REFERENCES CropType (CropTypeID);

-- **Drop tables**

DROP TABLE AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE ApplicationType CASCADE CONSTRAINTS;
DROP TABLE Building CASCADE CONSTRAINTS;
DROP TABLE BuildingType CASCADE CONSTRAINTS;
DROP TABLE Classification CASCADE CONSTRAINTS;
DROP TABLE Component CASCADE CONSTRAINTS;
DROP TABLE Component_Datasheet CASCADE CONSTRAINTS;
DROP TABLE Crop CASCADE CONSTRAINTS;
DROP TABLE CropCycle CASCADE CONSTRAINTS;
DROP TABLE CropType CASCADE CONSTRAINTS;
DROP TABLE Datasheet CASCADE CONSTRAINTS;
DROP TABLE FormulationType CASCADE CONSTRAINTS;
DROP TABLE Manufacturer CASCADE CONSTRAINTS;
DROP TABLE Operation CASCADE CONSTRAINTS;
DROP TABLE OperationType CASCADE CONSTRAINTS;
DROP TABLE Plantation CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Product_ApplicationType CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor_AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor_Product CASCADE CONSTRAINTS;
DROP TABLE Species CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement CASCADE CONSTRAINTS;