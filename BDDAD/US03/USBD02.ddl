DROP TABLE AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE Analysis CASCADE CONSTRAINTS;
DROP TABLE Building CASCADE CONSTRAINTS;
DROP TABLE BuildingType CASCADE CONSTRAINTS;
DROP TABLE Classification CASCADE CONSTRAINTS;
DROP TABLE Crop CASCADE CONSTRAINTS;
DROP TABLE CropCycle CASCADE CONSTRAINTS;
DROP TABLE CropName CASCADE CONSTRAINTS;
DROP TABLE CropObjective CASCADE CONSTRAINTS;
DROP TABLE CropType CASCADE CONSTRAINTS;
DROP TABLE Datasheet CASCADE CONSTRAINTS;
DROP TABLE Datasheet_Element CASCADE CONSTRAINTS;
DROP TABLE Datasheet_Substance CASCADE CONSTRAINTS;
DROP TABLE Element CASCADE CONSTRAINTS;
DROP TABLE FormulationType CASCADE CONSTRAINTS;
DROP TABLE Harvest CASCADE CONSTRAINTS;
DROP TABLE Plantation CASCADE CONSTRAINTS;
DROP TABLE Prediction CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor_Product CASCADE CONSTRAINTS;
DROP TABLE Substance CASCADE CONSTRAINTS;


CREATE TABLE AgriculturalParcel (
                                    parcelID          number(20) GENERATED AS IDENTITY,
                                    parcelDesignation varchar2(40),
                                    area              number(30),
                                    PRIMARY KEY (parcelID));
CREATE TABLE Analysis (
                          analysisID             number(20) GENERATED AS IDENTITY,
                          week                   number(10),
                          actualQuantity         number(10),
                          PlantationplantationID number(20) NOT NULL,
                          PRIMARY KEY (analysisID));
CREATE TABLE Building (
                          buildingID                    number(20) GENERATED AS IDENTITY,
                          "Building TypebuildingTypeID" number(20) NOT NULL,
                          PRIMARY KEY (buildingID));
CREATE TABLE BuildingType (
                              buildingTypeID     number(20) GENERATED AS IDENTITY,
                              typeName           varchar2(40),
                              BuildingbuildingID number(20) NOT NULL,
                              PRIMARY KEY (buildingTypeID));
CREATE TABLE Classification (
                                classificationID            number(20) GENERATED AS IDENTITY,
                                classificationName          varchar2(40),
                                "Production FactorfactorID" number(20) NOT NULL,
                                PRIMARY KEY (classificationID));
CREATE TABLE Crop (
                      cropID                        number(20) GENERATED AS IDENTITY,
                      "Crop NamecropNameID"         number(20) NOT NULL,
                      "Crop TypeCropTypeID"         number(20) NOT NULL,
                      "Crop CyclecycleID"           number(20) NOT NULL,
                      "Crop ObjectiveobjectiveID"   number(20) NOT NULL,
                      "Agricultural ParcelparcelID" number(20) NOT NULL,
                      PRIMARY KEY (cropID));
CREATE TABLE CropCycle (
                           cycleID    number(20) GENERATED AS IDENTITY,
                           startDate  date,
                           endDate    date,
                           CropcropID number(20) NOT NULL,
                           PRIMARY KEY (cycleID));
CREATE TABLE CropName (
                          cropNameID number(20) NOT NULL,
                          cropName   varchar2(40),
                          CropcropID number(20) NOT NULL,
                          PRIMARY KEY (cropNameID));
CREATE TABLE CropObjective (
                               objectiveID   number(20) GENERATED AS IDENTITY,
                               objectiveName varchar2(40),
                               CropcropID    number(20) NOT NULL,
                               PRIMARY KEY (objectiveID));
CREATE TABLE CropType (
                          CropTypeID number(20) GENERATED AS IDENTITY,
                          typeName   varchar2(40),
                          CropcropID number(20) NOT NULL,
                          PRIMARY KEY (CropTypeID));
CREATE TABLE Datasheet (
                           compositionID               number(20) GENERATED AS IDENTITY,
                           "Production FactorfactorID" number(20) NOT NULL,
                           ProductproductID            number(20) NOT NULL,
                           PRIMARY KEY (compositionID));
CREATE TABLE Datasheet_Element (
                                   DatasheetcompositionID number(20) NOT NULL,
                                   ElementelementID       number(20) NOT NULL,
                                   PRIMARY KEY (DatasheetcompositionID,
                                                ElementelementID));
CREATE TABLE Datasheet_Substance (
                                     DatasheetcompositionID number(20) NOT NULL,
                                     SubstancesubstanceID   number(20) NOT NULL,
                                     PRIMARY KEY (DatasheetcompositionID,
                                                  SubstancesubstanceID));
CREATE TABLE Element (
                         elementID   number(20) GENERATED AS IDENTITY,
                         elementName varchar2(40),
                         quantity    number(10),
                         PRIMARY KEY (elementID));
CREATE TABLE FormulationType (
                                 formulationTypeID           number(20) GENERATED AS IDENTITY,
                                 formulationTypeName         varchar2(40),
                                 "Production FactorfactorID" number(20) NOT NULL,
                                 ProductproductID            number(20) NOT NULL,
                                 PRIMARY KEY (formulationTypeID));
CREATE TABLE Harvest (
                         harvestID              number(20) GENERATED AS IDENTITY,
                         harvestDate            date,
                         quantity               number(10),
                         PlantationplantationID number(20) NOT NULL,
                         PRIMARY KEY (harvestID));
CREATE TABLE Plantation (
                            plantationID                  number(20) GENERATED AS IDENTITY,
                            plantationDate                date,
                            previousPlantationID          number(20),
                            changes                       number(10),
                            platationAge                  number(10),
                            "Agricultural ParcelparcelID" number(20) NOT NULL,
                            CropcropID                    number(20) NOT NULL,
                            PRIMARY KEY (plantationID));
CREATE TABLE Prediction (
                            predictionID           number(20) GENERATED AS IDENTITY,
                            week                   number(10),
                            predictedQuantity      number(10),
                            PlantationplantationID number(20) NOT NULL,
                            PRIMARY KEY (predictionID));
CREATE TABLE Product (
                         productID                        number(20) NOT NULL,
                         comercialName                    varchar2(40),
                         ClassificationclassificationID   number(20) NOT NULL,
                         FormulationTypeformulationTypeID number(20) NOT NULL,
                         PRIMARY KEY (productID));
CREATE TABLE ProductionFactor (
                                  factorID   number(20) GENERATED AS IDENTITY,
                                  CropcropID number(20) NOT NULL,
                                  PRIMARY KEY (factorID));
CREATE TABLE ProductionFactor_Product (
                                          ProductionFactorfactorID number(20) NOT NULL,
                                          ProductproductID         number(20) NOT NULL,
                                          PRIMARY KEY (ProductionFactorfactorID,
                                                       ProductproductID));
CREATE TABLE Substance (
                           substanceID   number(20) GENERATED AS IDENTITY,
                           substanceName varchar2(40),
                           quantity      number(10),
                           PRIMARY KEY (substanceID));