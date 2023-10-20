DROP TABLE "Agricultural Parcel" CASCADE CONSTRAINTS;
DROP TABLE Analysis CASCADE CONSTRAINTS;
DROP TABLE Building CASCADE CONSTRAINTS;
DROP TABLE "Building Type" CASCADE CONSTRAINTS;
DROP TABLE Classification CASCADE CONSTRAINTS;
DROP TABLE Crop CASCADE CONSTRAINTS;
DROP TABLE "Crop Cycle" CASCADE CONSTRAINTS;
DROP TABLE "Crop Name" CASCADE CONSTRAINTS;
DROP TABLE "Crop Objective" CASCADE CONSTRAINTS;
DROP TABLE "Crop Type" CASCADE CONSTRAINTS;
DROP TABLE Datasheet CASCADE CONSTRAINTS;
DROP TABLE Datasheet_Element CASCADE CONSTRAINTS;
DROP TABLE Datasheet_Substance CASCADE CONSTRAINTS;
DROP TABLE Element CASCADE CONSTRAINTS;
DROP TABLE "Formulation Type" CASCADE CONSTRAINTS;
DROP TABLE Harvest CASCADE CONSTRAINTS;
DROP TABLE Plantation CASCADE CONSTRAINTS;
DROP TABLE Prediction CASCADE CONSTRAINTS;
DROP TABLE "Production Factor" CASCADE CONSTRAINTS;
DROP TABLE Substance CASCADE CONSTRAINTS;

CREATE TABLE "AgriculturalParcel"
(
    parcelID          number(20) GENERATED AS IDENTITY,
    parcelDesignation varchar2(40),
    area              number(30),
    PRIMARY KEY (parcelID)
);

CREATE TABLE Crop
(
    cropID                        number(20) GENERATED AS IDENTITY,
    "Crop_NamecropNameID"         number(20) NOT NULL,
    "Crop_TypeCropTypeID"         number(20) NOT NULL,
    "Crop_CyclecycleID"           number(20) NOT NULL,
    "Crop_ObjectiveobjectiveID"   number(20) NOT NULL,
    "Agricultural_ParcelparcelID" number(20) NOT NULL,
    PRIMARY KEY (cropID),
    FOREIGN KEY ("Crop_NamecropNameID") REFERENCES "Crop Name" (cropNameID),
    FOREIGN KEY ("Crop_TypeCropTypeID") REFERENCES "Crop Type" (CropTypeID),
    FOREIGN KEY ("Crop_CyclecycleID") REFERENCES "Crop Cycle" (cycleID),
    FOREIGN KEY ("Crop_ObjectiveobjectiveID") REFERENCES "Crop Objective" (objectiveID),
    FOREIGN KEY ("Agricultural_ParcelparcelID") REFERENCES "Agricultural Parcel" (parcelID)
);

CREATE TABLE "ProductionFactor"
(
    factorID                            number(20) GENERATED AS IDENTITY,
    commercialName                      varchar2(40),
    HarvestharvestID                    number(20) NOT NULL,
    "Formulation_TypeformulationTypeID" number(20) NOT NULL,
    ClassificationclassificationID      number(20) NOT NULL,
    DatasheetcompositionID              number(20) NOT NULL,
    CropcropID                          number(20) NOT NULL,
    PRIMARY KEY (factorID),
    FOREIGN KEY (HarvestharvestID) REFERENCES Harvest (harvestID),
    FOREIGN KEY ("Formulation_TypeformulationTypeID") REFERENCES "Formulation Type" (formulationTypeID),
    FOREIGN KEY (ClassificationclassificationID) REFERENCES Classification (classificationID),
    FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE Building(
    buildingID                    number(20) GENERATED AS IDENTITY,
    "Building_TypebuildingTypeID" number(20) NOT NULL,
    PRIMARY KEY (buildingID),
    FOREIGN KEY ("Building_TypebuildingTypeID") REFERENCES "Building Type" (buildingTypeID)
);

CREATE TABLE Plantation(
    plantationID                  number(20) GENERATED AS IDENTITY,
    plantationDate                date,
    previousPlantationID          number(20),
    changes                       number(10),
    platationAge                  number(10),
    "Agricultural_ParcelparcelID" number(20) NOT NULL,
    CropcropID                    number(20) NOT NULL,
    PRIMARY KEY (plantationID),
    FOREIGN KEY ("Agricultural_ParcelparcelID") REFERENCES "AgriculturalParcel" (parcelID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE Harvest(
    harvestID              number(20) GENERATED AS IDENTITY,
    harvestDate            date,
    quantity               number(10),
    PlantationplantationID number(20) NOT NULL,
    PRIMARY KEY (harvestID),
    FOREIGN KEY (PlantationplantationID) REFERENCES Plantation (plantationID)
);

CREATE TABLE "CropCycle"(
    cycleID    number(20) GENERATED AS IDENTITY,
    startDate  date,
    endDate    date,
    CropcropID number(20) NOT NULL,
    PRIMARY KEY (cycleID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE "CropType"(
    CropTypeID number(20) GENERATED AS IDENTITY,
    typeName   varchar2(40),
    CropcropID number(20) NOT NULL,
    PRIMARY KEY (CropTypeID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE "CropObjective"(
    objectiveID   number(20) GENERATED AS IDENTITY,
    objectiveName varchar2(40),
    CropcropID    number(20) NOT NULL,
    PRIMARY KEY (objectiveID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE Classification
(
    classificationID            number(20) GENERATED AS IDENTITY,
    classificationName          varchar2(40),
    "Production_FactorfactorID" number(20) NOT NULL,
    PRIMARY KEY (classificationID),
    FOREIGN KEY ("Production_FactorfactorID") REFERENCES "ProductionFactor" (factorID)
);

CREATE TABLE "FormulationType"
(
    formulationTypeID           number(20) GENERATED AS IDENTITY,
    formulationTypeName         varchar2(40),
    "Production_FactorfactorID" number(20) NOT NULL,
    PRIMARY KEY (formulationTypeID),
    FOREIGN KEY ("Production_FactorfactorID") REFERENCES "ProductionFactor" (factorID)
);

CREATE TABLE "BuildingType"
(
    buildingTypeID     number(20) GENERATED AS IDENTITY,
    typeName           varchar2(40),
    BuildingbuildingID number(20) NOT NULL,
    PRIMARY KEY (buildingTypeID),
    FOREIGN KEY (BuildingbuildingID) REFERENCES Building (buildingID)
);

CREATE TABLE "CropName"
(
    cropNameID number(20) GENERATED AS IDENTITY,
    cropName   varchar2(40),
    CropcropID number(20) NOT NULL,
    PRIMARY KEY (cropNameID),
    FOREIGN KEY (CropcropID) REFERENCES Crop (cropID)
);

CREATE TABLE Datasheet
(
    compositionID               number(20) GENERATED AS IDENTITY,
    "Production_FactorfactorID" number(20) NOT NULL,
    PRIMARY KEY (compositionID),
    FOREIGN KEY ("Production_FactorfactorID") REFERENCES "ProductionFactor" (factorID)
);

CREATE TABLE Element
(
    elementID   number(20) GENERATED AS IDENTITY,
    elementName varchar2(40),
    quantity    number(10),
    PRIMARY KEY (elementID)
);

CREATE TABLE Substance
(
    substanceID   number(20) GENERATED AS IDENTITY,
    substanceName varchar2(40),
    quantity      number(10),
    PRIMARY KEY (substanceID)
);

CREATE TABLE Prediction
(
    predictionID           number(20) GENERATED AS IDENTITY,
    week                   number(10),
    predictedQuantity      number(10),
    PlantationplantationID number(20) NOT NULL,
    PRIMARY KEY (predictionID),
    FOREIGN KEY (PlantationplantationID) REFERENCES Plantation (plantationID)
);

CREATE TABLE Analysis
(
    analysisID             number(20) GENERATED AS IDENTITY,
    week                   number(10),
    actualQuantity         number(10),
    PlantationplantationID number(20) NOT NULL,
    PRIMARY KEY (analysisID),
    FOREIGN KEY (PlantationplantationID) REFERENCES Plantation (plantationID)
);

CREATE TABLE Datasheet_Substance
(
    DatasheetcompositionID number(20) NOT NULL,
    SubstancesubstanceID   number(20) NOT NULL,
    PRIMARY KEY (DatasheetcompositionID, SubstancesubstanceID),
    FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID),
    FOREIGN KEY (SubstancesubstanceID) REFERENCES Substance (substanceID)
);

CREATE TABLE Datasheet_Element
(
    DatasheetcompositionID number(20) NOT NULL,
    ElementelementID       number(20) NOT NULL,
    PRIMARY KEY (DatasheetcompositionID, ElementelementID),
    FOREIGN KEY (DatasheetcompositionID) REFERENCES Datasheet (compositionID),
    FOREIGN KEY (ElementelementID) REFERENCES Element (elementID)
);