DROP TABLE AgriculturalParcel CASCADE CONSTRAINTS;
DROP TABLE AgriculturalParcel_IrrigationSector CASCADE CONSTRAINTS;
DROP TABLE AirSensor CASCADE CONSTRAINTS;
DROP TABLE ApplicationMode CASCADE CONSTRAINTS;
DROP TABLE ApplicationType CASCADE CONSTRAINTS;
DROP TABLE ApplicationType_Product CASCADE CONSTRAINTS;
DROP TABLE Building CASCADE CONSTRAINTS;
DROP TABLE Classification CASCADE CONSTRAINTS;
DROP TABLE Component CASCADE CONSTRAINTS;
DROP TABLE Component_Datasheet CASCADE CONSTRAINTS;
DROP TABLE Crop CASCADE CONSTRAINTS;
DROP TABLE CropApplication CASCADE CONSTRAINTS;
DROP TABLE Datasheet CASCADE CONSTRAINTS;
DROP TABLE DispersionTypes CASCADE CONSTRAINTS;
DROP TABLE Fertigation CASCADE CONSTRAINTS;
DROP TABLE FormulationType CASCADE CONSTRAINTS;
DROP TABLE Garage CASCADE CONSTRAINTS;
DROP TABLE GroundSensor CASCADE CONSTRAINTS;
DROP TABLE Harvest CASCADE CONSTRAINTS;
DROP TABLE Incorporation CASCADE CONSTRAINTS;
DROP TABLE IrrigationSector CASCADE CONSTRAINTS;
DROP TABLE Log CASCADE CONSTRAINTS;
DROP TABLE Manufacturer CASCADE CONSTRAINTS;
DROP TABLE Mill CASCADE CONSTRAINTS;
DROP TABLE Mobilization CASCADE CONSTRAINTS;
DROP TABLE Operation CASCADE CONSTRAINTS;
DROP TABLE ParcelApplication CASCADE CONSTRAINTS;
DROP TABLE Plant CASCADE CONSTRAINTS;
DROP TABLE Plantation CASCADE CONSTRAINTS;
DROP TABLE PlantType CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE ProductionFactor CASCADE CONSTRAINTS;
DROP TABLE Pruning CASCADE CONSTRAINTS;
DROP TABLE RainfallSensor CASCADE CONSTRAINTS;
DROP TABLE Revenue CASCADE CONSTRAINTS;
DROP TABLE Revenue_ProductionFactor CASCADE CONSTRAINTS;
DROP TABLE Sowing CASCADE CONSTRAINTS;
DROP TABLE Species CASCADE CONSTRAINTS;
DROP TABLE Storage CASCADE CONSTRAINTS;
DROP TABLE Techniques CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement_AirSensor CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement_GroundSensor CASCADE CONSTRAINTS;
DROP TABLE UnityOfMeasurement_RainfallSensor CASCADE CONSTRAINTS;
DROP TABLE Watering CASCADE CONSTRAINTS;
DROP TABLE WateringSystem CASCADE CONSTRAINTS;
DROP TABLE WeatherStation CASCADE CONSTRAINTS;
DROP TABLE Weed CASCADE CONSTRAINTS;

CREATE TABLE AgriculturalParcel (parcelID number(20) NOT NULL, parcelDesignation varchar2(40), area float(10), PRIMARY KEY (parcelID));
CREATE TABLE AgriculturalParcel_IrrigationSector (parcelID number(20) NOT NULL, setorID number(10) NOT NULL, PRIMARY KEY (parcelID, setorID));
CREATE TABLE AirSensor (airSensorID number(10) NOT NULL, windSpeed float(10), windIntensity float(10), temperature float(10), humidity float(10), atmosphericPressure float(10), PRIMARY KEY (airSensorID));
CREATE TABLE ApplicationMode (modeID number(10) NOT NULL, designation varchar2(10) NOT NULL, PRIMARY KEY (modeID));
CREATE TABLE ApplicationType (applicationID number(10) NOT NULL, name varchar2(40), PRIMARY KEY (applicationID));
CREATE TABLE ApplicationType_Product (applicationID number(10) NOT NULL, productionFactorID number(20) NOT NULL, PRIMARY KEY (applicationID, productionFactorID));
CREATE TABLE Building (buildingID number(20) NOT NULL, designation varchar2(40), PRIMARY KEY (buildingID));
CREATE TABLE Classification (classificationID number(20) NOT NULL, classificationName varchar2(40), PRIMARY KEY (classificationID));
CREATE TABLE Component (componentID number(10) NOT NULL, componentName varchar2(50), PRIMARY KEY (componentID));
CREATE TABLE Component_Datasheet (componentID number(10) NOT NULL, compositionID number(20) NOT NULL, quantity float(10), PRIMARY KEY (componentID, compositionID));
CREATE TABLE Crop (cropID number(20) NOT NULL, startDate date, endDate date, parcelID number(20) NOT NULL, plantID number(10) NOT NULL, PRIMARY KEY (cropID));
CREATE TABLE CropApplication (operationID number(10) NOT NULL, cropID number(20) NOT NULL, modeID number(10), productionFactorID number(20) NOT NULL, quantity float(10), PRIMARY KEY (operationID));
CREATE TABLE Datasheet (compositionID number(20) NOT NULL, productionFactorID number(20) NOT NULL, PRIMARY KEY (compositionID));
CREATE TABLE DispersionTypes (dispersionID number(10) NOT NULL, designation varchar2(40), PRIMARY KEY (dispersionID));
CREATE TABLE Fertigation (operationID number(10) NOT NULL, techniquesID number(10), revenueID number(10) NOT NULL, cropID number(20) NOT NULL, setorID number(10) NOT NULL, duration number(10), inicialHour varchar2(10), PRIMARY KEY (operationID));
CREATE TABLE FormulationType (formulationTypeID number(20) NOT NULL, formulationTypeName varchar2(40), PRIMARY KEY (formulationTypeID));
CREATE TABLE Garage (buildingID number(20) NOT NULL, area float(10), unityID number(10) NOT NULL, PRIMARY KEY (buildingID));
CREATE TABLE GroundSensor (groundSensorID number(10) NOT NULL, humidity float(10), temperature float(10), pH float(10), salinity float(10), parcelID number(20) NOT NULL, PRIMARY KEY (groundSensorID));
CREATE TABLE Harvest (operationID number(10) NOT NULL, quantity float(10), cropID number(20) NOT NULL, plantID number(10) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE Incorporation (operationID number(10) NOT NULL, area float(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE IrrigationSector (setorID number(10) NOT NULL, startDate date, endDate date, maximumFlow float(10), dispersionID number(10), PRIMARY KEY (setorID));
CREATE TABLE Log (logID number(10) GENERATED AS IDENTITY, instant timestamp(0), operationDate date, cropID number(10), parcelID number(10), operationID number(10) NOT NULL, PRIMARY KEY (logID));
CREATE TABLE Manufacturer (manufacturerID number(10) NOT NULL, name varchar2(40), PRIMARY KEY (manufacturerID));
CREATE TABLE Mill (buildingID number(20) NOT NULL, PRIMARY KEY (buildingID));
CREATE TABLE Mobilization (operationID number(10) NOT NULL, parcelID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE Operation (operationID number(10) NOT NULL, operationDate date, state varchar2(30), PRIMARY KEY (operationID));
CREATE TABLE ParcelApplication (operationID number(10) NOT NULL, parcelID number(20) NOT NULL, productionFactorID number(20) NOT NULL, modeID number(10) NOT NULL, quantity float(10), PRIMARY KEY (operationID));
CREATE TABLE Plant (plantID number(10) NOT NULL, name varchar2(40), speciesID number(10) NOT NULL, plantTypeID number(20) NOT NULL, PRIMARY KEY (plantID));
CREATE TABLE Plantation (operationID number(10) NOT NULL, plantsNumber number(10), compass float(10), queuesDistance float(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE PlantType (plantTypeID number(20) NOT NULL, typeName varchar2(40), PRIMARY KEY (plantTypeID));
CREATE TABLE Product (plantID number(10) NOT NULL, designation varchar2(40), PRIMARY KEY (plantID));
CREATE TABLE ProductionFactor (productionFactorID number(20) NOT NULL, comercialName varchar2(40), classificationID number(20) NOT NULL, formulationTypeID number(20) NOT NULL, manufacturerID number(10) NOT NULL, PRIMARY KEY (productionFactorID));
CREATE TABLE Pruning (operationID number(10) NOT NULL, quantity float(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE RainfallSensor (rainfallSensorID number(10) NOT NULL, rainfall float(10), PRIMARY KEY (rainfallSensorID));
CREATE TABLE Revenue (revenueID number(10) NOT NULL, PRIMARY KEY (revenueID));
CREATE TABLE Revenue_ProductionFactor (revenueID number(10) NOT NULL, productionFactorID number(20) NOT NULL, quantity float(10), PRIMARY KEY (revenueID, productionFactorID));
CREATE TABLE Sowing (operationID number(10) NOT NULL, quantity float(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE Species (speciesID number(10) NOT NULL, speciesName varchar2(40), commonName varchar2(40), plantationPeriod varchar2(40), pruningPeriod varchar2(40), floweringPeriod varchar2(40), harvestPeriod varchar2(40), PRIMARY KEY (speciesID));
CREATE TABLE Storage (buildingID number(20) NOT NULL, area float(10), unityID number(10) NOT NULL, PRIMARY KEY (buildingID));
CREATE TABLE Techniques (techniquesID number(10) NOT NULL, name varchar2(40), PRIMARY KEY (techniquesID));
CREATE TABLE UnityOfMeasurement (unityID number(10) NOT NULL, name varchar2(10) NOT NULL, PRIMARY KEY (unityID));
CREATE TABLE UnityOfMeasurement_AirSensor (unityID number(10) NOT NULL, airSensorID number(10) NOT NULL, PRIMARY KEY (unityID, airSensorID));
CREATE TABLE UnityOfMeasurement_GroundSensor (unityID number(10) NOT NULL, groundSensorID number(10) NOT NULL, PRIMARY KEY (unityID, groundSensorID));
CREATE TABLE UnityOfMeasurement_RainfallSensor (unityID number(10) NOT NULL, rainfallSensorID number(10) NOT NULL, PRIMARY KEY (unityID, rainfallSensorID));
CREATE TABLE Watering (operationID number(10) NOT NULL, duration number(10), inicialHour varchar2(10), setorID number(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
CREATE TABLE WateringSystem (buildingID number(20) NOT NULL, capacity float(10), unityID number(10) NOT NULL, PRIMARY KEY (buildingID));
CREATE TABLE WeatherStation (id number(10) NOT NULL, airSensorID number(10) NOT NULL, groundSensorID number(10) NOT NULL, rainfallSensorID number(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE Weed (operationID number(10) NOT NULL, area float(10), cropID number(20) NOT NULL, PRIMARY KEY (operationID));
ALTER TABLE Log ADD CONSTRAINT FKLog811905 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Fertigation ADD CONSTRAINT FKFertigatio685108 FOREIGN KEY (setorID) REFERENCES IrrigationSector (setorID);
ALTER TABLE Fertigation ADD CONSTRAINT FKFertigatio720831 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Mobilization ADD CONSTRAINT FKMobilizati355731 FOREIGN KEY (parcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE Mobilization ADD CONSTRAINT FKMobilizati258169 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE ParcelApplication ADD CONSTRAINT FKParcelAppl97090 FOREIGN KEY (modeID) REFERENCES ApplicationMode (modeID);
ALTER TABLE ParcelApplication ADD CONSTRAINT FKParcelAppl104376 FOREIGN KEY (productionFactorID) REFERENCES ProductionFactor (productionFactorID);
ALTER TABLE CropApplication ADD CONSTRAINT FKCropApplic720658 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE CropApplication ADD CONSTRAINT FKCropApplic844343 FOREIGN KEY (productionFactorID) REFERENCES ProductionFactor (productionFactorID);
ALTER TABLE ParcelApplication ADD CONSTRAINT FKParcelAppl659902 FOREIGN KEY (parcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE CropApplication ADD CONSTRAINT FKCropApplic925780 FOREIGN KEY (modeID) REFERENCES ApplicationMode (modeID);
ALTER TABLE CropApplication ADD CONSTRAINT FKCropApplic279442 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Fertigation ADD CONSTRAINT FKFertigatio720932 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Incorporation ADD CONSTRAINT FKIncorporat553170 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Watering ADD CONSTRAINT FKWatering57481 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE AgriculturalParcel_IrrigationSector ADD CONSTRAINT FKAgricultur62037 FOREIGN KEY (setorID) REFERENCES IrrigationSector (setorID);
ALTER TABLE AgriculturalParcel_IrrigationSector ADD CONSTRAINT FKAgricultur587687 FOREIGN KEY (parcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE Incorporation ADD CONSTRAINT FKIncorporat446930 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Pruning ADD CONSTRAINT FKPruning119922 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Pruning ADD CONSTRAINT FKPruning851567 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Weed ADD CONSTRAINT FKWeed196374 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Weed ADD CONSTRAINT FKWeed803726 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation536773 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Plantation ADD CONSTRAINT FKPlantation463327 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Watering ADD CONSTRAINT FKWatering914008 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Harvest ADD CONSTRAINT FKHarvest794588 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Sowing ADD CONSTRAINT FKSowing493907 FOREIGN KEY (operationID) REFERENCES Operation (operationID);
ALTER TABLE Sowing ADD CONSTRAINT FKSowing477582 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Harvest ADD CONSTRAINT FKHarvest176901 FOREIGN KEY (cropID) REFERENCES Crop (cropID);
ALTER TABLE Harvest ADD CONSTRAINT FKHarvest873273 FOREIGN KEY (plantID) REFERENCES Product (plantID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop460293 FOREIGN KEY (plantID) REFERENCES Plant (plantID);
ALTER TABLE Crop ADD CONSTRAINT FKCrop578310 FOREIGN KEY (parcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE Product ADD CONSTRAINT FKProduct611170 FOREIGN KEY (plantID) REFERENCES Plant (plantID);
ALTER TABLE Plant ADD CONSTRAINT FKPlant648439 FOREIGN KEY (plantTypeID) REFERENCES PlantType (plantTypeID);
ALTER TABLE Plant ADD CONSTRAINT FKPlant81620 FOREIGN KEY (speciesID) REFERENCES Species (speciesID);
ALTER TABLE Fertigation ADD CONSTRAINT FKFertigatio216125 FOREIGN KEY (revenueID) REFERENCES Revenue (revenueID);
ALTER TABLE Revenue_ProductionFactor ADD CONSTRAINT FKRevenue_Pr587093 FOREIGN KEY (productionFactorID) REFERENCES ProductionFactor (productionFactorID);
ALTER TABLE Revenue_ProductionFactor ADD CONSTRAINT FKRevenue_Pr959148 FOREIGN KEY (revenueID) REFERENCES Revenue (revenueID);
ALTER TABLE Fertigation ADD CONSTRAINT FKFertigatio991238 FOREIGN KEY (techniquesID) REFERENCES Techniques (techniquesID);
ALTER TABLE GroundSensor ADD CONSTRAINT FKGroundSens995337 FOREIGN KEY (parcelID) REFERENCES AgriculturalParcel (parcelID);
ALTER TABLE UnityOfMeasurement_RainfallSensor ADD CONSTRAINT FKUnityOfMea97374 FOREIGN KEY (rainfallSensorID) REFERENCES RainfallSensor (rainfallSensorID);
ALTER TABLE UnityOfMeasurement_RainfallSensor ADD CONSTRAINT FKUnityOfMea688736 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE UnityOfMeasurement_GroundSensor ADD CONSTRAINT FKUnityOfMea38858 FOREIGN KEY (groundSensorID) REFERENCES GroundSensor (groundSensorID);
ALTER TABLE UnityOfMeasurement_GroundSensor ADD CONSTRAINT FKUnityOfMea776313 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE UnityOfMeasurement_AirSensor ADD CONSTRAINT FKUnityOfMea267395 FOREIGN KEY (airSensorID) REFERENCES AirSensor (airSensorID);
ALTER TABLE UnityOfMeasurement_AirSensor ADD CONSTRAINT FKUnityOfMea486447 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE WeatherStation ADD CONSTRAINT FKWeatherSta436819 FOREIGN KEY (rainfallSensorID) REFERENCES RainfallSensor (rainfallSensorID);
ALTER TABLE WeatherStation ADD CONSTRAINT FKWeatherSta505710 FOREIGN KEY (groundSensorID) REFERENCES GroundSensor (groundSensorID);
ALTER TABLE WeatherStation ADD CONSTRAINT FKWeatherSta404551 FOREIGN KEY (airSensorID) REFERENCES AirSensor (airSensorID);
ALTER TABLE Watering ADD CONSTRAINT FKWatering93305 FOREIGN KEY (setorID) REFERENCES IrrigationSector (setorID);
ALTER TABLE IrrigationSector ADD CONSTRAINT FKIrrigation796334 FOREIGN KEY (dispersionID) REFERENCES DispersionTypes (dispersionID);
ALTER TABLE WateringSystem ADD CONSTRAINT FKWateringSy402744 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Garage ADD CONSTRAINT FKGarage463343 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE Storage ADD CONSTRAINT FKStorage141186 FOREIGN KEY (unityID) REFERENCES UnityOfMeasurement (unityID);
ALTER TABLE WateringSystem ADD CONSTRAINT FKWateringSy912306 FOREIGN KEY (buildingID) REFERENCES Building (buildingID);
ALTER TABLE Mill ADD CONSTRAINT FKMill650886 FOREIGN KEY (buildingID) REFERENCES Building (buildingID);
ALTER TABLE Garage ADD CONSTRAINT FKGarage972905 FOREIGN KEY (buildingID) REFERENCES Building (buildingID);
ALTER TABLE Storage ADD CONSTRAINT FKStorage631623 FOREIGN KEY (buildingID) REFERENCES Building (buildingID);
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio430669 FOREIGN KEY (productionFactorID) REFERENCES ProductionFactor (productionFactorID);
ALTER TABLE ApplicationType_Product ADD CONSTRAINT FKApplicatio745835 FOREIGN KEY (applicationID) REFERENCES ApplicationType (applicationID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_748979 FOREIGN KEY (compositionID) REFERENCES Datasheet (compositionID);
ALTER TABLE Component_Datasheet ADD CONSTRAINT FKComponent_335185 FOREIGN KEY (componentID) REFERENCES Component (componentID);
ALTER TABLE ProductionFactor ADD CONSTRAINT FKProduction68410 FOREIGN KEY (classificationID) REFERENCES Classification (classificationID);
ALTER TABLE Datasheet ADD CONSTRAINT FKDatasheet408365 FOREIGN KEY (productionFactorID) REFERENCES ProductionFactor (productionFactorID);
ALTER TABLE ProductionFactor ADD CONSTRAINT FKProduction166112 FOREIGN KEY (manufacturerID) REFERENCES Manufacturer (manufacturerID);
ALTER TABLE ProductionFactor ADD CONSTRAINT FKProduction874177 FOREIGN KEY (formulationTypeID) REFERENCES FormulationType (formulationTypeID);
