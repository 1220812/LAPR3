-- **Constrains on the create tables**

-- All the attributes defined as 'Primary keys' must be defined with the 'UNIQUE' constraint so that the elements on that table have different values as primary keys
-- Some of the other attributes must be defined with the 'NOT NULL' constraint

CREATE TABLE AgriculturalParcel (
                                    parcelID                  number(20) UNIQUE,
                                    parcelDesignation         varchar2(40) NOT NULL,
                                    area                      number(30) NOT NULL,
                                    UnityOfMeasurementunityID number(10) NOT NULL,
                                    PRIMARY KEY (parcelID));
CREATE TABLE ApplicationType (
                                 applicationID number(10) UNIQUE,
                                 name          varchar2(40) NOT NULL,
                                 PRIMARY KEY (applicationID));
CREATE TABLE ApplicationType_Product (
                                         ApplicationTypeapplicationID number(10) NOT NULL,
                                         ProductproductID             number(20) NOT NULL,
                                         PRIMARY KEY (ApplicationTypeapplicationID,
                                                      ProductproductID));
CREATE TABLE Building (
                          buildingID                    number(20) UNIQUE,
                          designation                   varchar2(40) NOT NULL,
                          area                          number(20),
                          "Building TypebuildingTypeID" number(20) NOT NULL,
                          UnityOfMeasurementunityID     number(10) NOT NULL,
                          PRIMARY KEY (buildingID));
CREATE TABLE BuildingType (
                              buildingTypeID number(20) UNIQUE,
                              typeName       varchar2(40) NOT NULL,
                              PRIMARY KEY (buildingTypeID));
CREATE TABLE Classification (
                                classificationID   number(20) UNIQUE,
                                classificationName varchar2(40) NOT NULL,
                                PRIMARY KEY (classificationID));
CREATE TABLE Component (
                           componentID   number(10) UNIQUE,
                           componentName varchar2(50) NOT NULL,
                           PRIMARY KEY (componentID));
CREATE TABLE Component_Datasheet (
                                     ComponentcomponentID      number(10) NOT NULL,
                                     DatasheetcompositionID    number(20) NOT NULL,
                                     quantity                  number(10) NOT NULL,
                                     UnityOfMeasurementunityID number(10) NOT NULL,
                                     PRIMARY KEY (ComponentcomponentID,
                                                  DatasheetcompositionID));
CREATE TABLE Crop (
                      cropID                number(20) UNIQUE,
                      variety               varchar2(40) NOT NULL,
                      "Crop TypeCropTypeID" number(20) NOT NULL,
                      SpeciesspeciesID      number(10) NOT NULL,
                      PRIMARY KEY (cropID));
CREATE TABLE CropType (
                          CropTypeID number(20) UNIQUE,
                          typeName   varchar2(40) NOT NULL,
                          PRIMARY KEY (CropTypeID));
CREATE TABLE Datasheet (
                           compositionID     number(20) UNIQUE,
                           ProductproductID2 number(20) NOT NULL,
                           PRIMARY KEY (compositionID));
CREATE TABLE FormulationType (
                                 formulationTypeID   number(20) UNIQUE,
                                 formulationTypeName varchar2(40) NOT NULL,
                                 PRIMARY KEY (formulationTypeID));
CREATE TABLE Manufacturer (
                              manufacturerID number(10) UNIQUE,
                              name           varchar2(40) NOT NULL,
                              PRIMARY KEY (manufacturerID));
CREATE TABLE Operation (
                           operationID                  number(10) UNIQUE,
                           "date"                       date,
                           quantity                     number(10) NOT NULL,
                           UnityOfMeasurementunityID    number(10) NOT NULL,
                           OperationTypeoperationTypeID number(10) NOT NULL,
                           PlantationCyclecycleID       number(10) NOT NULL,
                           PRIMARY KEY (operationID));
CREATE TABLE OperationType (
                               operationTypeID   number(10) UNIQUE,
                               operationTypeName varchar2(40) NOT NULL,
                               PRIMARY KEY (operationTypeID));
CREATE TABLE Plantation (
                            cycleID                    number(10) UNIQUE,
                            startDate                  date,
                            endDate                    date,
                            quantity                   number(10) NOT NULL,
                            AgriculturalParcelparcelID number(20) NOT NULL,
                            UnityOfMeasurementunityID  number(10) NOT NULL,
                            CropcropID                 number(20) NOT NULL,
                            PRIMARY KEY (cycleID));
CREATE TABLE Product (
                         productID                        number(20) UNIQUE,
                         comercialName                    varchar2(40) NOT NULL,
                         ClassificationclassificationID   number(20) NOT NULL,
                         FormulationTypeformulationTypeID number(20) NOT NULL,
                         ManufacturermanufacturerID       number(10) NOT NULL,
                         PRIMARY KEY (productID));
CREATE TABLE Product_Plantation (
                                    ProductproductID  number(20) NOT NULL,
                                    PlantationcycleID number(10) NOT NULL,
                                    PRIMARY KEY (ProductproductID,
                                                 PlantationcycleID));
CREATE TABLE Species (
                         speciesID        number(10) UNIQUE,
                         speciesName      varchar2(40) NOT NULL,
                         commonName       varchar2(40) NOT NULL,
                         plantationPeriod varchar2(40),
                         pruningPeriod    varchar2(40),
                         floweringPeriod  varchar2(40),
                         harvestPeriod    varchar2(40),
                         PRIMARY KEY (speciesID));
CREATE TABLE UnityOfMeasurement (
                                    unityID number(10) UNIQUE,
                                    name    varchar2(10) NOT NULL,
                                    PRIMARY KEY (unityID));

-- **Constrains on the alter tables**

-- The 'ON DELETE RESTRICT' constraint restrict the exclusion of the elements defined on the tables with foreign keys associated to them

ALTER TABLE Product_Plantation ADD CONSTRAINT FKProduct_Pl524542 FOREIGN KEY (PlantationcycleID) REFERENCES Plantation (cycleID)ON DELETE RESTRICT ;
ALTER TABLE Product_Plantation ADD CONSTRAINT FKProduct_Pl432922 FOREIGN KEY (ProductproductID) REFERENCES Product (productID)ON DELETE RESTRICT ;
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_773772 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID)ON DELETE RESTRICT ;
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation239203 FOREIGN KEY (CropcropID) REFERENCES Crop (cropID) ON DELETE RESTRICT ;
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio15336 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio354257 FOREIGN KEY (ApplicationTypeapplicationID) REFERENCES ApplicationType (applicationID)ON DELETE RESTRICT ;
ALTER TABLE Operation ADD CONSTRAINT FKOperation394768 FOREIGN KEY (PlantationCyclecycleID) REFERENCES Plantation (cycleID)ON DELETE RESTRICT ;
ALTER TABLE Operation ADD CONSTRAINT FKOperation62574 FOREIGN KEY (OperationTypeoperationTypeID) REFERENCES OperationType (operationTypeID)ON DELETE RESTRICT ;
ALTER TABLE Operation ADD CONSTRAINT FKOperation5286 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID)ON DELETE RESTRICT ;
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation272550 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID)ON DELETE RESTRICT ;
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation374211 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID)ON DELETE RESTRICT ;
ALTER TABLE Crop ADD CONSTRAINT FKCrop394614 FOREIGN KEY (SpeciesspeciesID) REFERENCES Species (speciesID)ON DELETE RESTRICT ;
ALTER TABLE AgriculturalParcel ADD CONSTRAINT FKAgricultur310538 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID)ON DELETE RESTRICT ;
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_576098 FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID)ON DELETE RESTRICT ;
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_180622 FOREIGN KEY (ComponentcomponentID) REFERENCES Component (componentID)ON DELETE RESTRICT ;
ALTER TABLE Product ADD CONSTRAINT FKProduct587362 FOREIGN KEY (ClassificationclassificationID) REFERENCES Classification (classificationID)ON DELETE RESTRICT ;
ALTER TABLE Datasheet ADD CONSTRAINT FKDatasheet527132 FOREIGN KEY (ProductproductID2) REFERENCES Product (productID)ON DELETE RESTRICT ;
ALTER TABLE Product ADD CONSTRAINT FKProduct109633 FOREIGN KEY (ManufacturermanufacturerID) REFERENCES Manufacturer (manufacturerID)ON DELETE RESTRICT ;
ALTER TABLE Building ADD CONSTRAINT FKBuilding701038 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID)ON DELETE RESTRICT ;
ALTER TABLE Product ADD CONSTRAINT FKProduct433814 FOREIGN KEY (FormulationTypeformulationTypeID) REFERENCES FormulationType (formulationTypeID)ON DELETE RESTRICT ;
ALTER TABLE Building ADD CONSTRAINT FKBuilding729922 FOREIGN KEY ("Building TypebuildingTypeID") REFERENCES BuildingType (buildingTypeID)ON DELETE RESTRICT;
ALTER TABLE Crop ADD CONSTRAINT FKCrop651425 FOREIGN KEY ("Crop TypeCropTypeID") REFERENCES CropType (CropTypeID)ON DELETE RESTRICT;

-- This constraint ensures that the 'startDate' attribute value is lower than the 'endDate' value on a Plantation

ALTER TABLE Plantation ADD CONSTRAINT CHK_Plantation_Dates CHECK (Plantation.startDate < Plantation.endDate);

-- This constraint ensures that the 'quantity' of a component on a datasheet is lower than 100

ALTER TABLE Component_Datasheet ADD CONSTRAINT CHL_Quantity CHECK (quantity < 100 );