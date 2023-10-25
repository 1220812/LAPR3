CREATE TABLE AgriculturalParcel
(
    parcelID                  number(20) GENERATED AS IDENTITY,
    parcelDesignation         varchar2(40),
    area                      number(30),
    FarmfarmID                number(10) NOT NULL,
    UnityOfMeasurementunityID number(10) NOT NULL,
    PRIMARY KEY (parcelID)
);
CREATE TABLE AgriculturalParcel_Crop
(
    AgriculturalParcelparcelID number(20) NOT NULL,
    CropcropID                 number(20) NOT NULL,
    PRIMARY KEY (AgriculturalParcelparcelID,
                 CropcropID)
);
CREATE TABLE ApplicationType
(
    aplicationID number(10) GENERATED AS IDENTITY,
    name         varchar2(40),
    PRIMARY KEY (aplicationID)
);
CREATE TABLE Building
(
    buildingID                    number(20) GENERATED AS IDENTITY,
    designation                   varchar2(40),
    area                          number(20),
    "Building TypebuildingTypeID" number(20) NOT NULL,
    UnityOfMeasurementunityID     number(10) NOT NULL,
    FarmfarmID                    number(10) NOT NULL,
    PRIMARY KEY (buildingID)
);
CREATE TABLE BuildingType
(
    buildingTypeID number(20) GENERATED AS IDENTITY,
    typeName       varchar2(40),
    PRIMARY KEY (buildingTypeID)
);
CREATE TABLE Classification
(
    classificationID   number(20) GENERATED AS IDENTITY,
    classificationName varchar2(40),
    PRIMARY KEY (classificationID)
);
CREATE TABLE Component
(
    componentID   number(10) GENERATED AS IDENTITY,
    componentName number(10),
    quantity      number(10),
    PRIMARY KEY (componentID)
);
CREATE TABLE Component_Datasheet
(
    ComponentcomponentID   number(10) NOT NULL,
    DatasheetcompositionID number(20) NOT NULL,
    PRIMARY KEY (ComponentcomponentID,
                 DatasheetcompositionID)
);
CREATE TABLE Crop
(
    cropID                    number(20) GENERATED AS IDENTITY,
    quantity                  number(20),
    variety                   varchar2(40),
    "Crop TypeCropTypeID"     number(20) NOT NULL,
    "Crop CyclecycleID"       number(20) NOT NULL,
    UnityOfMeasurementunityID number(10) NOT NULL,
    SpeciesspeciesID          number(10) NOT NULL,
    PRIMARY KEY (cropID)
);
CREATE TABLE CropCycle
(
    cycleID   number(20) GENERATED AS IDENTITY,
    startDate date,
    endDate   date,
    PRIMARY KEY (cycleID)
);
CREATE TABLE CropType
(
    CropTypeID number(20) GENERATED AS IDENTITY,
    typeName   varchar2(40),
    PRIMARY KEY (CropTypeID)
);
CREATE TABLE Datasheet
(
    compositionID     number(20) GENERATED AS IDENTITY,
    ProductproductID2 number(20) NOT NULL,
    PRIMARY KEY (compositionID)
);
CREATE TABLE Farm
(
    farmID                    number(10) GENERATED AS IDENTITY,
    name                      varchar2(40),
    area                      number(10),
    UnityOfMeasurementunityID number(10) NOT NULL,
    PRIMARY KEY (farmID)
);
CREATE TABLE FormulationType
(
    formulationTypeID   number(20) GENERATED AS IDENTITY,
    formulationTypeName varchar2(40),
    PRIMARY KEY (formulationTypeID)
);
CREATE TABLE Manufacturer
(
    manufacturerID number(10) GENERATED AS IDENTITY,
    name           varchar2(40),
    PRIMARY KEY (manufacturerID)
);
CREATE TABLE Operation
(
    operationID                  number(10) GENERATED AS IDENTITY,
    mode                         number(10),
    date                         date,
    quantity                     number(10),
    UnityOfMeasurementunityID    number(10) NOT NULL,
    OperationTypeoperationTypeID number(10) NOT NULL,
    PlantationCyclecycleID       number(10) NOT NULL,
    PRIMARY KEY (operationID)
);
CREATE TABLE OperationType
(
    operationTypeID   number(10) GENERATED AS IDENTITY,
    operationTypeName number(10),
    PRIMARY KEY (operationTypeID)
);
CREATE TABLE PlantationCycle
(
    cycleID                    number(10) GENERATED AS IDENTITY,
    startDate                  date,
    endDate                    date,
    quantity                   number(10),
    AgriculturalParcelparcelID number(20) NOT NULL,
    UnityOfMeasurementunityID  number(10) NOT NULL,
    PRIMARY KEY (cycleID)
);
CREATE TABLE Product
(
    productID                        number(20) NOT NULL,
    comercialName                    varchar2(40),
    ClassificationclassificationID   number(20) NOT NULL,
    FormulationTypeformulationTypeID number(20) NOT NULL,
    ManufacturermanufacturerID       number(10) NOT NULL,
    PRIMARY KEY (productID)
);
CREATE TABLE ProductionFactor
(
    factorID number(20) GENERATED AS IDENTITY,
    PRIMARY KEY (factorID)
);
CREATE TABLE ProductionFactor_AgriculturalParcel
(
    ProductionFactorfactorID   number(20) NOT NULL,
    AgriculturalParcelparcelID number(20) NOT NULL,
    PRIMARY KEY (ProductionFactorfactorID,
                 AgriculturalParcelparcelID)
);
CREATE TABLE ProductionFactor_Product
(
    ProductionFactorfactorID number(20) NOT NULL,
    ProductproductID         number(20) NOT NULL,
    PRIMARY KEY (ProductionFactorfactorID,
                 ProductproductID)
);
CREATE TABLE Species
(
    speciesID        number(10) GENERATED AS IDENTITY,
    speciesName      varchar2(40),
    commonName       varchar2(40),
    plantationPeriod varchar2(40),
    pruningPeriod    varchar2(40),
    floweringPeriod  varchar2(40),
    harvestPeriod    varchar2(40),
    PRIMARY KEY (speciesID)
);
CREATE TABLE UnityOfMeasurement
(
    unityID number(10) GENERATED AS IDENTITY,
    name    varchar2(10) NOT NULL,
    PRIMARY KEY (unityID)
);
CREATE TABLE "User"
(
    userID             number(10) GENERATED AS IDENTITY,
    name               varchar2(40),
    UserTypeuserTypeID number(10) NOT NULL,
    FarmfarmID         number(10) NOT NULL,
    PRIMARY KEY (userID)
);
CREATE TABLE UserType
(
    userTypeID   number(10) GENERATED AS IDENTITY,
    userTypeName varchar2(40),
    PRIMARY KEY (userTypeID)
);


ALTER TABLE ProductionFactor_AgriculturalParcel
    ADD CONSTRAINT FKProduction634442 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE ProductionFactor_AgriculturalParcel
    ADD CONSTRAINT FKProduction472320 FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);
ALTER TABLE AgriculturalParcel_Crop
    ADD CONSTRAINT FKAgricultur615032 FOREIGN KEY (CropcropID) REFERENCES Crop (cropID);
ALTER TABLE AgriculturalParcel_Crop
    ADD CONSTRAINT FKAgricultur228447 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);

ALTER TABLE Product
    ADD CONSTRAINT FKProduct109633 FOREIGN KEY (ManufacturermanufacturerID) REFERENCES Manufacturer (manufacturerID);
ALTER TABLE Product
    ADD CONSTRAINT FKProduct433814 FOREIGN KEY (FormulationTypeformulationTypeID) REFERENCES FormulationType (formulationTypeID);
ALTER TABLE ProductionFactor_Product
    ADD CONSTRAINT FKProduction858580 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE ProductionFactor_Product
    ADD CONSTRAINT FKProduction50584 FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);

ALTER TABLE Operation
    ADD CONSTRAINT FK_OperationType FOREIGN KEY (OperationTypeoperationTypeID) REFERENCES OperationType (operationTypeID);
ALTER TABLE Operation
    ADD CONSTRAINT FK_OperationUnity FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Operation
    ADD CONSTRAINT FK_OperationCycleID FOREIGN KEY (PlantationCyclecycleID) REFERENCES PlantationCycle (cycleID);

ALTER TABLE PlantationCycle
    ADD CONSTRAINT FK_PlantationUnity FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE PlantationCycle
    ADD CONSTRAINT FK_PlantationParcelID FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);

ALTER TABLE Crop
    ADD CONSTRAINT FK_CropSpecieID FOREIGN KEY (SpeciesspeciesID) REFERENCES Species (speciesID);
ALTER TABLE Crop
    ADD CONSTRAINT FK_CropUnity FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Crop
    ADD CONSTRAINT FK_CropCycle FOREIGN KEY ("Crop CyclecycleID") REFERENCES CropCycle (cycleID);
ALTER TABLE Crop
    ADD CONSTRAINT FK_CropType FOREIGN KEY ("Crop TypeCropTypeID") REFERENCES CropType (CropTypeID);

ALTER TABLE AgriculturalParcel
    ADD CONSTRAINT FK_ParcelUnity FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE AgriculturalParcel
    ADD CONSTRAINT FK_FarmID FOREIGN KEY (FarmfarmID) REFERENCES Farm (farmID);

ALTER TABLE Component_Datasheet
    ADD CONSTRAINT FK_ComponentComposition FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID);
ALTER TABLE Component_Datasheet
    ADD CONSTRAINT FK_ComponentID FOREIGN KEY (ComponentcomponentID) REFERENCES Component (componentID);

ALTER TABLE Farm
    ADD CONSTRAINT FK_FarmUnity FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);

ALTER TABLE Building
    ADD CONSTRAINT FK_BuildingFarm FOREIGN KEY (FarmfarmID) REFERENCES Farm (farmID);
ALTER TABLE Building
    ADD CONSTRAINT FK_BuildingTypeID FOREIGN KEY (buildingTypeID) REFERENCES BuildingType (buildingTypeID);
ALTER TABLE Building
    ADD CONSTRAINT FK_UnityID FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);

ALTER TABLE User
    ADD CONSTRAINT FK_Farm FOREIGN KEY (FarmfarmID) REFERENCES Farm (farmID);
ALTER TABLE User
    ADD CONSTRAINT FK_UserType FOREIGN KEY (UserTypeuserTypeID) REFERENCES UserType (userTypeID);

ALTER TABLE Product
    ADD CONSTRAINT FK_ProductClassification FOREIGN KEY (ClassificationclassificationID) REFERENCES Classification (classificationID);
ALTER TABLE Product
    ADD CONSTRAINT FK_ProductManufacturer FOREIGN KEY (ManufacturermanufacturerID) REFERENCES Manufacturer (manufacturerID);
ALTER TABLE Product
    ADD CONSTRAINT FK_ProductFormulation FOREIGN KEY (FormulationTypeformulationTypeID) REFERENCES FormulationType (formulationTypeID);

ALTER TABLE Datasheet
    ADD CONSTRAINT FK_DatasheetProduct FOREIGN KEY (ProductproductID2) REFERENCES Product (productID);

ALTER TABLE ProductionFactor_Product
    ADD CONSTRAINT FK_ProductionFactorProduct FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE ProductionFactor_Product
    ADD CONSTRAINT FK_FactorID FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);

ALTER TABLE ProductionFactor_AgriculturalParcel
    ADD CONSTRAINT FK_ProductionFactorParcel FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE ProductionFactor_AgriculturalParcel
    ADD CONSTRAINT FK_ProductionFactorID FOREIGN KEY (ProductionFactorfactorID) REFERENCES ProductionFactor (factorID);

ALTER TABLE AgriculturalParcel_Crop
    ADD CONSTRAINT FK_ParcelCropID FOREIGN KEY (CropcropID) REFERENCES Crop (cropID);
ALTER TABLE AgriculturalParcel_Crop
    ADD CONSTRAINT FK_CorpParcelID FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);

DROP TABLE AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE AgriculturalParcel_Crop CASCADE CONSTRAINTS;
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
DROP TABLE Farm CASCADE CONSTRAINTS;
DROP TABLE FormulationType CASCADE CONSTRAINTS;
DROP TABLE Manufacturer CASCADE CONSTRAINTS;
DROP TABLE Operation CASCADE CONSTRAINTS;
DROP TABLE OperationType CASCADE CONSTRAINTS;
DROP TABLE PlantationCycle CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor_AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor_Product CASCADE CONSTRAINTS;
DROP TABLE Species CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement CASCADE CONSTRAINTS;
DROP TABLE User CASCADE CONSTRAINTS;
DROP TABLE UserType CASCADE CONSTRAINTS;