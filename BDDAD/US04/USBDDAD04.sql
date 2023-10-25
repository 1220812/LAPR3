-- **Table AgriculturalParcel**

INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (101, 'Campo da bouça', 1.2);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (102, 'Campo grande', 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (103, 'Campo do poço', 1.5);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (104, 'Lameiro da ponte', 0.8);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (105, 'Lameiro do moinho', 1.1);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area)
VALUES (106, 'Horta nova', 0.3);

-- **Table BuildingType**

INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(200, 'Armazém');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(201, 'Garagem');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(202, 'Moinho');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(203, 'Rega');

-- **Table UnityOfMeasurement**

INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(01, 'm2');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(02, 'm3');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(03, 'ha');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(04, 'un');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(05, 'kg');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(06, '%');

-- **Table Building**

INSERT INTO Building(buildingID, designation, area, buildingTypeID, unityID, farmID)
VALUES(201, 'Espigueiro', 600, 200, 01);
INSERT INTO Building(buildingID, designation, area, buildingTypeID, unityID)
VALUES(202, 'Armazém novo', 800, 200, 01);
INSERT INTO Building(buildingID, designation, area, buildingTypeID, unityID)
VALUES(203, 'Armazém grande', 900, 201, 01);
INSERT INTO Building(buildingID, designation, buildingTypeID)
VALUES(250, 'Moinho', 200);
INSERT INTO Building(buildingID, designation, area, buildingTypeID, unityID)
VALUES(301, 'Tanque do campo grande', 15, 203, 02);

-- **Table Manufacturer**

INSERT INTO Manufacturer(manufacturerID, name)
VALUES(01, 'ASCENZA');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(02, 'Bayer');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(03, 'K+S');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(04, 'Biocal');

-- **Table Farm**
INSERT INTO Farm(farmID, name, area, unityID)
VALUES(01, 'Quinta da Malafaia', 200, 03);

-- **Table FormulationType**

INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(01, 'Pó molhável');
INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(02, 'Granulado');
INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(03, 'Pó');

-- **Table Classification**

INSERT INTO Classification(classificationID, classificationName)
VALUES(01, 'Fitofármaco');
INSERT INTO Classification(classificationID, classificationName)
VALUES(02, 'Adubo');
INSERT INTO Classification(classificationID, classificationName)
VALUES(03, 'Corretor');

-- **Table ApplicationType**

-- **Table UserType**
INSERT INTO UserType(userID, userTypeName)
VALUES (01, 'Gestor Agrícola');
INSERT INTO UserType(userID, userTypeName)
VALUES (02, 'Cliente');
INSERT INTO UserType(userID, userTypeName)
VALUES (03, 'Condutor');
INSERT INTO UserType(userID, userTypeName)
VALUES (04, 'Gestor de Distribuição');

-- **Table OperationType**
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (01, 'Plantação');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (02, 'Rega');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (03, 'Poda');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (04, 'Fertelização');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (05, 'Colheita');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (06, 'Sementeira');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (07, 'Incorporação no solo');

-- **Table Operation**



-- **Table Crop**

-- **Table Species
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (01, 'Prunus domestica', 'Ameixoeira', '', 'novembro a dezembro', 'fevereiro a março', 'julho a agosto');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (02, 'Prunus armeniaca', 'Damasqueiro', '', 'novembro a dezembro', 'fevereiro a março', 'julho a agosto');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (03, 'Malus domestica', 'Macieira', '', 'novembro a dezembro', 'março a abril', 'agosto a setembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (04, 'Malus domestica', 'Macieira', '', 'janeiro', 'abril a maio', 'novembro a dezembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (05, 'Pyrus pyrifolia', 'Pera Nashi', '', '', '', '');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (06, 'Daucus carota subsp. Sativus', 'Cenoura', '', '', '', '80 dias');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (07, 'Lupinus albus', 'Tremoço', '', '', '', '');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (08, 'Zea mays', 'Milho', 'Abril a junho', '', '', 'julho a setembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (09, 'Brassica rapa', 'Nabo greleiro', 'março a setembro', '', '', 'julho a fevereiro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (09, 'Olea europaea', 'Oliveira', '', '', '', 'outubro a fevereiro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (10, 'Brassica rapa L.', 'Nabo', 'fevereiro a abril, agosto a outubro', '', '', '90 dias');

-- **Table CropType**
INSERT INTO CropType(cropTypeID, typeName)
VALUES(01, 'Permanente');
INSERT INTO CropType(cropTypeID, typeName)
VALUES(02, 'Temporário');




