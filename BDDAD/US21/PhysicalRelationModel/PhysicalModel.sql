-- Drop Tables

DROP TABLE AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE AgriculturalParcel_Plantation CASCADE CONSTRAINTS;
DROP TABLE AgriculturalParcel_Plantation_IrrigationSector CASCADE CONSTRAINTS;
DROP TABLE ApplicationType CASCADE CONSTRAINTS;
DROP TABLE ApplicationType_Product CASCADE CONSTRAINTS;
DROP TABLE Building CASCADE CONSTRAINTS;
DROP TABLE Classification CASCADE CONSTRAINTS;
DROP TABLE Component CASCADE CONSTRAINTS;
DROP TABLE Component_Datasheet CASCADE CONSTRAINTS;
DROP TABLE Crop CASCADE CONSTRAINTS;
DROP TABLE CropType CASCADE CONSTRAINTS;
DROP TABLE Datasheet CASCADE CONSTRAINTS;
DROP TABLE DispersionTypes CASCADE CONSTRAINTS;
DROP TABLE Fertilization CASCADE CONSTRAINTS;
DROP TABLE FormulationType CASCADE CONSTRAINTS;
DROP TABLE Garage CASCADE CONSTRAINTS;
DROP TABLE Harvest CASCADE CONSTRAINTS;
DROP TABLE Incorporation CASCADE CONSTRAINTS;
DROP TABLE IrrigationSector CASCADE CONSTRAINTS;
DROP TABLE Manufacturer CASCADE CONSTRAINTS;
DROP TABLE Mill CASCADE CONSTRAINTS;
DROP TABLE Operation CASCADE CONSTRAINTS;
DROP TABLE Plantation CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Pruning CASCADE CONSTRAINTS;
DROP TABLE Sowing CASCADE CONSTRAINTS;
DROP TABLE Species CASCADE CONSTRAINTS;
DROP TABLE Storage CASCADE CONSTRAINTS;
DROP TABLE ToPlant CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement CASCADE CONSTRAINTS;
DROP TABLE Watering CASCADE CONSTRAINTS;
DROP TABLE WateringSystem CASCADE CONSTRAINTS;
DROP TABLE Weed CASCADE CONSTRAINTS;

-- Create tables

CREATE TABLE AgriculturalParcel (
                                    parcelID          number(20) NOT NULL,
                                    parcelDesignation varchar2(40),
                                    area              number(30),
                                    PRIMARY KEY (parcelID));
CREATE TABLE AgriculturalParcel_Plantation (
                                               AgriculturalParcelparcelID number(20) NOT NULL,
                                               PlantationplantationID     number(10) NOT NULL,
                                               PRIMARY KEY (AgriculturalParcelparcelID,
                                                            PlantationplantationID));
CREATE TABLE AgriculturalParcel_Plantation_IrrigationSector (
                                                                AgriculturalParcel_PlantationAgriculturalParcelparcelID number(20) NOT NULL,
                                                                AgriculturalParcel_PlantationPlantationplantationID     number(10) NOT NULL,
                                                                IrrigationSectorsetorID                                 number(10) NOT NULL,
                                                                PRIMARY KEY (AgriculturalParcel_PlantationAgriculturalParcelparcelID,
                                                                             AgriculturalParcel_PlantationPlantationplantationID,
                                                                             IrrigationSectorsetorID));
CREATE TABLE ApplicationType (
                                 applicationID number(10) NOT NULL,
                                 name          varchar2(40),
                                 PRIMARY KEY (applicationID));
CREATE TABLE ApplicationType_Product (
                                         ApplicationTypeapplicationID number(10) NOT NULL,
                                         ProductproductID             number(20) NOT NULL,
                                         PRIMARY KEY (ApplicationTypeapplicationID,
                                                      ProductproductID));
CREATE TABLE Building (
                          buildingID  number(20) NOT NULL,
                          designation varchar2(40),
                          PRIMARY KEY (buildingID));
CREATE TABLE Classification (
                                classificationID   number(20) NOT NULL,
                                classificationName varchar2(40),
                                PRIMARY KEY (classificationID));
CREATE TABLE Component (
                           componentID   number(10) NOT NULL,
                           componentName varchar2(50),
                           PRIMARY KEY (componentID));
CREATE TABLE Component_Datasheet (
                                     ComponentcomponentID   number(10) NOT NULL,
                                     DatasheetcompositionID number(20) NOT NULL,
                                     quantity               number(10),
                                     PRIMARY KEY (ComponentcomponentID,
                                                  DatasheetcompositionID));
CREATE TABLE Crop (
                      cropID                number(20) NOT NULL,
                      variety               varchar2(40),
                      "Crop TypeCropTypeID" number(20) NOT NULL,
                      SpeciesspeciesID      number(10) NOT NULL,
                      PRIMARY KEY (cropID));
CREATE TABLE CropType (
                          CropTypeID number(20) NOT NULL,
                          typeName   varchar2(40),
                          PRIMARY KEY (CropTypeID));
CREATE TABLE Datasheet (
                           compositionID     number(20) NOT NULL,
                           ProductproductID2 number(20) NOT NULL,
                           PRIMARY KEY (compositionID));
CREATE TABLE DispersionTypes (
                                 dispersionID number(10) NOT NULL,
                                 designation  varchar2(40),
                                 PRIMARY KEY (dispersionID));
CREATE TABLE Fertilization (
                               OperationoperationID number(10) NOT NULL,
                               ProductproductID     number(20) NOT NULL);
CREATE TABLE FormulationType (
                                 formulationTypeID   number(20) NOT NULL,
                                 formulationTypeName varchar2(40),
                                 PRIMARY KEY (formulationTypeID));
CREATE TABLE Garage (
                        area                      number(20),
                        BuildingbuildingID        number(20) NOT NULL,
                        UnityOfMeasurementunityID number(10) NOT NULL);
CREATE TABLE Harvest (
    OperationoperationID number(10) NOT NULL);
CREATE TABLE Incorporation (
    OperationoperationID number(10) NOT NULL);
CREATE TABLE IrrigationSector (
                                  setorID                     number(10) NOT NULL,
                                  startDate                   date,
                                  endDate                     date,
                                  maximumFlow                 number(10),
                                  DispersionTypesdispersionID number(10) NOT NULL,
                                  PRIMARY KEY (setorID));
CREATE TABLE Manufacturer (
                              manufacturerID number(10) NOT NULL,
                              name           varchar2(40),
                              PRIMARY KEY (manufacturerID));
CREATE TABLE Mill (
    BuildingbuildingID number(20) NOT NULL);
CREATE TABLE Operation (
                           operationID               number(10) NOT NULL,
                           "date"                    date,
                           quantity                  number(10),
                           UnityOfMeasurementunityID number(10) NOT NULL,
                           PlantationCyclecycleID    number(10) NOT NULL,
                           PRIMARY KEY (operationID));
CREATE TABLE Plantation (
                            plantationID              number(10) NOT NULL,
                            startDate                 date,
                            endDate                   date,
                            quantity                  number(10),
                            UnityOfMeasurementunityID number(10) NOT NULL,
                            CropcropID                number(20) NOT NULL,
                            PRIMARY KEY (plantationID));
CREATE TABLE Product (
                         productID                        number(20) NOT NULL,
                         comercialName                    varchar2(40),
                         ClassificationclassificationID   number(20) NOT NULL,
                         FormulationTypeformulationTypeID number(20) NOT NULL,
                         ManufacturermanufacturerID       number(10) NOT NULL,
                         PRIMARY KEY (productID));
CREATE TABLE Pruning (
    OperationoperationID number(10) NOT NULL);
CREATE TABLE Sowing (
    OperationoperationID number(10) NOT NULL);
CREATE TABLE Species (
                         speciesID        number(10) NOT NULL,
                         speciesName      varchar2(40),
                         commonName       varchar2(40),
                         plantationPeriod varchar2(40),
                         pruningPeriod    varchar2(40),
                         floweringPeriod  varchar2(40),
                         harvestPeriod    varchar2(40),
                         PRIMARY KEY (speciesID));
CREATE TABLE Storage (
                         area                      number(20),
                         BuildingbuildingID        number(20) NOT NULL,
                         UnityOfMeasurementunityID number(10) NOT NULL);
CREATE TABLE ToPlant (
    OperationoperationID number(10) NOT NULL);
CREATE TABLE UnityOfMeasurement (
                                    unityID number(10) NOT NULL,
                                    name    varchar2(10) NOT NULL,
                                    PRIMARY KEY (unityID));
CREATE TABLE Watering (
                          OperationoperationID    number(10) NOT NULL,
                          IrrigationSectorsetorID number(10) NOT NULL);
CREATE TABLE WateringSystem (
                                BuildingbuildingID        number(20) NOT NULL,
                                UnityOfMeasurementunityID number(10) NOT NULL);
CREATE TABLE Weed (
    OperationoperationID number(10) NOT NULL);

-- Alter tables

ALTER TABLE Fertilization ADD CONSTRAINT FKFertilizat113648 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE AgriculturalParcel_Plantation_IrrigationSector ADD CONSTRAINT FKAgricultur614971 FOREIGN KEY (IrrigationSectorsetorID) REFERENCES IrrigationSector (setorID);
ALTER TABLE AgriculturalParcel_Plantation_IrrigationSector ADD CONSTRAINT FKAgricultur375536 FOREIGN KEY (AgriculturalParcel_PlantationAgriculturalParcelparcelID, AgriculturalParcel_PlantationPlantationplantationID) REFERENCES AgriculturalParcel_Plantation (AgriculturalParcelparcelID, PlantationplantationID);
ALTER TABLE AgriculturalParcel_Plantation ADD CONSTRAINT FKAgricultur721728 FOREIGN KEY (PlantationplantationID) REFERENCES Plantation (plantationID);
ALTER TABLE AgriculturalParcel_Plantation ADD CONSTRAINT FKAgricultur150794 FOREIGN KEY (AgriculturalParcelparcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE Watering ADD CONSTRAINT FKWatering432431 FOREIGN KEY (IrrigationSectorsetorID) REFERENCES IrrigationSector (setorID);
ALTER TABLE IrrigationSector ADD CONSTRAINT FKIrrigation49049 FOREIGN KEY (DispersionTypesdispersionID) REFERENCES DispersionTypes (dispersionID);
ALTER TABLE Incorporation ADD CONSTRAINT FKIncorporat224222 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Watering ADD CONSTRAINT FKWatering136717 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Pruning ADD CONSTRAINT FKPruning74276 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Sowing ADD CONSTRAINT FKSowing700290 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Harvest ADD CONSTRAINT FKHarvest399609 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE ToPlant ADD CONSTRAINT FKToPlant152700 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Weed ADD CONSTRAINT FKWeed581018 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE Fertilization ADD CONSTRAINT FKFertilizat455252 FOREIGN KEY (OperationoperationID) REFERENCES Operation (operationID);
ALTER TABLE WateringSystem ADD CONSTRAINT FKWateringSy862631 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Garage ADD CONSTRAINT FKGarage923230 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Storage ADD CONSTRAINT FKStorage681298 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE WateringSystem ADD CONSTRAINT FKWateringSy593190 FOREIGN KEY (BuildingbuildingID) REFERENCES Building (buildingID);
ALTER TABLE Mill ADD CONSTRAINT FKMill815206 FOREIGN KEY (BuildingbuildingID) REFERENCES Building (buildingID);
ALTER TABLE Garage ADD CONSTRAINT FKGarage532591 FOREIGN KEY (BuildingbuildingID) REFERENCES Building (buildingID);
ALTER TABLE Storage ADD CONSTRAINT FKStorage834469 FOREIGN KEY (BuildingbuildingID) REFERENCES Building (buildingID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation239203 FOREIGN KEY (CropcropID) REFERENCES Crop (cropID);
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio15336 FOREIGN KEY (ProductproductID) REFERENCES Product (productID);
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio354257 FOREIGN KEY (ApplicationTypeapplicationID) REFERENCES ApplicationType (applicationID);
ALTER TABLE Operation ADD CONSTRAINT FKOperation92443 FOREIGN KEY (PlantationCyclecycleID) REFERENCES Plantation (plantationID);
ALTER TABLE Operation ADD CONSTRAINT FKOperation5286 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation272550 FOREIGN KEY (UnityOfMeasurementunityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop394614 FOREIGN KEY (SpeciesspeciesID) REFERENCES Species (speciesID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_576098 FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_180622 FOREIGN KEY (ComponentcomponentID) REFERENCES Component (componentID);
ALTER TABLE Product ADD CONSTRAINT FKProduct587362 FOREIGN KEY (ClassificationclassificationID) REFERENCES Classification (classificationID);
ALTER TABLE Datasheet ADD CONSTRAINT FKDatasheet527132 FOREIGN KEY (ProductproductID2) REFERENCES Product (productID);
ALTER TABLE Product ADD CONSTRAINT FKProduct109633 FOREIGN KEY (ManufacturermanufacturerID) REFERENCES Manufacturer (manufacturerID);
ALTER TABLE Product ADD CONSTRAINT FKProduct433814 FOREIGN KEY (FormulationTypeformulationTypeID) REFERENCES FormulationType (formulationTypeID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop651425 FOREIGN KEY ("Crop TypeCropTypeID") REFERENCES CropType (CropTypeID);
