-- **Table Species**
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (1, 'Prunus domestica', 'Ameixoeira', '', 'novembro a dezembro', 'fevereiro a março', 'julho a agosto');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (2, 'Prunus armeniaca', 'Damasqueiro', '', 'novembro a dezembro', 'fevereiro a março', 'julho a agosto');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (3, 'Malus domestica', 'Macieira', '', 'novembro a dezembro', 'março a abril', 'agosto a setembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (4, 'Malus domestica', 'Macieira', '', 'janeiro', 'abril a maio', 'novembro a dezembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (5, 'Pyrus pyrifolia', 'Pera Nashi', '', '', '', '');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (6, 'Daucus carota subsp. Sativus', 'Cenoura', '', '', '', '80 dias');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (7, 'Lupinus albus', 'Tremoço', '', '', '', '');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (8, 'Zea mays', 'Milho', 'Abril a junho', '', '', 'julho a setembro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (9, 'Brassica rapa', 'Nabo greleiro', 'março a setembro', '', '', 'julho a fevereiro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (10, 'Olea europaea', 'Oliveira', '', '', '', 'outubro a fevereiro');
INSERT INTO Species(speciesID, spiecesName, commonName, plantationPeriod, pruningPeriod, floweringPeriod, harvestPeriod)
VALUES (11, 'Brassica rapa L.', 'Nabo', 'fevereiro a abril, agosto a outubro', '', '', '90 dias');

-- **Table CropType**
INSERT INTO CropType(cropTypeID, typeName)
VALUES(1, 'Permanente');
INSERT INTO CropType(cropTypeID, typeName)
VALUES(2, 'Temporário');

-- **Table Crop**
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(1, 'RAINHA CLAUDIA CARANGUEJEIRA', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(2, 'PRESIDENT', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(3, 'STANLEY', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(4, 'ANGELENO', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(5, 'BLACK BEAUTY', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(6, 'BLACK STAR', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(7, 'BLACK GOLD', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(8, 'BLACK DIAMOND', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(9, 'BLACK AMBER', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(10, 'BLACK SPLENDOR', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(11, 'FORTUNA', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(12, 'FRIAR', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(13, 'EL DORADO', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(14, 'ELEPHANT HEART', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(15, 'GOLDEN JAPAN', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(16, 'HARRY PITCHON', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(17, 'LAETITIA', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(18, 'METLEY', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(19, 'MIRABELLE DE NANCY', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(20, 'QUEEN ROSE', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(21, 'RED BEAUT', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(22, 'SANTA ROSA', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(23, 'SHIRO', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(24, 'SUNGOLD', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(25, 'WILSON PERFECTION', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(26, 'AUTUMN GIANT', 1 ,1);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(27, 'BULIDA', 1 ,2);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(28, 'CANINO', 1 ,2);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(29, 'LIABAUD', 1 ,2);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(30, 'MAILLOT JAUNE', 1 ,2);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(31, 'POLONAIS', 1 ,2);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(32, 'AKANE', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(33, 'BELGOLDEN', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(34, 'BRAVO DE ESMOLFE', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(35, 'CASA NOVA DE ALCOBAÇA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(36, 'EROVAN', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(37, 'FUJI', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(38, 'GRANNY SMITH', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(39, 'GOLDEN DELICIOUS', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(40, 'HI-EARLY', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(41, 'JONAGORED', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(42, 'LYSGOLDEN', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(43, 'MUTSU', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(44, 'PORTA DA LOJA', 1 ,4);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(45, 'REINETTE OU CANADA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(46, 'REINETTE OU GRAND FAY', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(47, 'RISCADINHA DE PALMELA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(48, 'ROYAL GALA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(49, 'REDCHIEF', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(50, 'STARKING', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(51, 'SUMMER RED', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(52, 'WELL´SPUR DELICIOUS', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(53, 'NOIVA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(54, 'OLHO ABERTO', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(55, 'CAMOESA ROSA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(56, 'MALÁPIO', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(57, 'GRONHO DOCE', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(58, 'PÉ DE BOI', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(59, 'PINOVA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(60, 'PARDO LINDO', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(61, 'PIPO DE BASTO', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(62, 'PRIMA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(63, 'QUERINA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(64, 'VISTA BELLA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(65, 'GOLDEN SMOOTHEE', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(66, 'GOLDEN SUPREMA', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(67, 'GLOSTER 69', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(68, 'FREEDOM', 1 ,3);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(69, 'SNINSEIKI', 1 ,5);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(70, 'KUMOI', 1 ,5);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(71, 'HOSUI', 1 ,5);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(72, 'NIJISSEIKI', 1 ,5);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(73, 'Carson Hybrid', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(74, 'Red Cored Chantenay', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(75, 'Danvers Half Long', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(76, 'Imperator 58', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(77, 'Sugarsnax Hybrid', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(78, 'Nelson Hybrid', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(79, 'Scarlet Nantes', 2 ,6);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(80, 'Amarelo', 2 ,7);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(81, 'Branco', 2 ,7);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(82, 'MAS 24.C', 2 ,8);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(83, 'Doce Golden Bantam', 2 ,8);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(84, 'Senhora Conceição', 2 ,9);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(85, 'COBRANÇOSA', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(86, 'ARBEQUINA', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(87, 'HOJIBLANCA', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(88, 'NEGRINHA DO FREIXO', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(89, 'PICUAL', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(90, 'MAÇANILHA', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(91, 'CONSERVA DE ELVAS', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(92, 'Galega', 1 ,10);
INSERT INTO Crop(cropID, variety, FKCrop651425, FKCrop394614)
VALUES(93, 'S. Cosme', 2 ,11);

-- **Table Manufacturer**

INSERT INTO Manufacturer(manufacturerID, name)
VALUES(1, 'ASCENZA');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(2, 'Bayer');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(3, 'K+S');
INSERT INTO Manufacturer(manufacturerID, name)
VALUES(4, 'Biocal');

-- **Table FormulationType**

INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(1, 'Pó molhável');
INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(2, 'Granulado');
INSERT INTO FormulationType(formulationTypeID, formulationTypeName)
VALUES(3, 'Pó');

-- **Table Classification**

INSERT INTO Classification(classificationID, classificationName)
VALUES(1, 'Fitofármaco');
INSERT INTO Classification(classificationID, classificationName)
VALUES(2, 'Adubo');
INSERT INTO Classification(classificationID, classificationName)
VALUES(3, 'Corretor');

-- **Table ApplicationType**

INSERT INTO ApplicationType(applicationID, name)
VALUES(1, 'Fungicida');
INSERT INTO ApplicationType(applicationID, name)
VALUES(2, 'Adubo Solo');
INSERT INTO ApplicationType(applicationID, name)
VALUES(3, 'Adubo foliar');
INSERT INTO ApplicationType(applicationID, name)
VALUES(4, 'Fertirrega');
INSERT INTO ApplicationType(applicationID, name)
VALUES(5, 'Correção solo');

-- **Table ApplicationType_Product**

INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(1, 1);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(1, 2);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(2, 3);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(2, 4);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(3, 5);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(4, 5);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(3, 6);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(5, 7);
INSERT INTO ApplicationType_Product(FKApplicatio8567, FKApplicatio15336)
VALUES(5, 8);

-- **Table Component**

INSERT INTO Component(componentID, componentName)
VALUES(1, 'CU');
INSERT INTO Component(componentID, componentName)
VALUES(2, 'S');
INSERT INTO Component(componentID, componentName)
VALUES(3, 'K');
INSERT INTO Component(componentID, componentName)
VALUES(4, 'Mg');
INSERT INTO Component(componentID, componentName)
VALUES(5, 'CaCO3');
INSERT INTO Component(componentID, componentName)
VALUES(6, 'MgCO3');
INSERT INTO Component(componentID, componentName)
VALUES(7, 'B');
INSERT INTO Component(componentID, componentName)
VALUES(8, 'MgO');
INSERT INTO Component(componentID, componentName)
VALUES(9, 'Mn');

-- **Table Datasheet**

INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(1, 1);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(2, 2);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(3, 3);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(4, 4);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(5, 5);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(6, 6);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(7, 7);
INSERT INTO Datasheet(compositionID, FKDatasheet527132)
VALUES(8, 8);

-- **Table Component_Datasheet**

INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(1, 1, 20.0, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(2, 2, 80.0, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(3, 3, 24.9, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(4, 3, 6.0, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(2, 3, 17.6, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(4, 4, 15.1, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(2, 4, 20.8, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(4, 5, 9.0, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(2, 5, 12.4, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(7, 5, 0.90, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(9, 5, 1, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(4, 6, 9.6, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(2, 6, 13, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(5, 7, 88.2, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(6, 7, 1.90, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(5, 8, 71.7, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(6, 8, 14.8, 6);
INSERT INTO Component_Datasheet(FKComponent_180622, FKComponent_576098, quantity, FKComponent_773772)
VALUES(8, 8, 7.90, 6);

-- **Table Product**

INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (1, 'Calda Bordalesa ASCENZA', 1, 1, 1);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (2, 'Enxofre Bayer 80 WG', 1, 1, 2);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (3, 'Patentkali', 2, 2, 3);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (4, 'ESTA Kieserit', 2, 2, 3);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (5, 'EPSO Microtop', 2, 2, 3);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (6, 'EPSO Top', 2, 2, 3);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (7, 'Biocal CaCo3', 3, 2, 4);
INSERT INTO Product(productID, comercialName, FKProduct587362, FKProduct433814, FKProduct109633)
VALUES (8, 'Biocal Composto', 3, 3, 4);

-- **Table UnityOfMeasurement**

INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(1, 'm2');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(2, 'm3');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(3, 'ha');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(4, 'un');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(5, 'kg');
INSERT INTO UnityOfMeasurement(unityID, name)
VALUES(6, '%');

-- **Table AgriculturalParcel**

INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (101, 'Campo da bouça', 1.2, 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (102, 'Campo grande', 3, 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (103, 'Campo do poço', 1.5, 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (104, 'Lameiro da ponte', 0.8, 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (105, 'Lameiro do moinho', 1.1, 3);
INSERT INTO AgriculturalParcel(parcelID, parcelDesignation, area, FKAgricultur310538)
VALUES (106, 'Horta nova', 0.3, 3);

-- **Table Building**

INSERT INTO Building(buildingID, designation, area, FKBuilding729922, FKBuilding701038)
VALUES(201, 'Espigueiro', 600, 1, 1);
INSERT INTO Building(buildingID, designation, area, FKBuilding729922, FKBuilding701038)
VALUES(202, 'Armazém novo', 800, 1, 1);
INSERT INTO Building(buildingID, designation, area, FKBuilding729922, FKBuilding701038)
VALUES(203, 'Armazém grande', 900, 2, 1);
INSERT INTO Building(buildingID, designation, area, FKBuilding729922, FKBuilding701038)
VALUES(250, 'Moinho', 3, 0);
INSERT INTO Building(buildingID, designation, area, FKBuilding729922, FKBuilding701038)
VALUES(301, 'Tanque do campo grande', 15, 4, 2);

-- **Table BuildingType**

INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(1, 'Armazém');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(2, 'Garagem');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(3, 'Moinho');
INSERT INTO BuildingType(builingTypeID, typeName)
VALUES(4, 'Rega');

-- **Plantation**

INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(1, 06/10/2016, ,30, 102, 4, 92);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(2, 10/10/2016, ,20, 102, 4, 89);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(3, 07/01/2017, ,90, 104, 4, 41);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(4, 08/01/2017, ,60, 104, 4, 37);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(5, 08/01/2017, ,40, 104, 4, 48);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(6, 10/12/2018, ,30, 104, 4, 48);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(7, 10/10/2020, 30/03/2021, 1.1, 101, 3, 80);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(8, 10/04/2021, 12/08/2021, 0.9, 101, 3, 83);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(9, 15/04/2021, 21/08/2021, 0.9, 101, 3, 83);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(10, 03/10/2021, 05/04/2022, 1.1, 101, 3, 80);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(11, 10/02/2020, 15/05/2020, 0.15, 106, 3, 79);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(12, 02/06/2020, 08/09/2020, 0.1, 106, 3, 78);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(13, 20/09/2020, 10/01/2021, 0.2, 106, 3, 93);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(14, 10/02/2021, 15/05/2021, 0.15, 106, 3, 77);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(15, 02/06/2021, 08/09/2021, 0.1, 106, 3, 75);
INSERT INTO Plantation(cycleID, startDate, endDate, quantity, FKPlantation374211, FKPlantation272550 ,FKPlantation239203)
VALUES(16, 20/09/2021, 10/01/2022, 0.2, 106, 3, 93);

-- **Table OperationType**

INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (1, 'Plantação');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (2, 'Rega');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (3, 'Poda');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (4, 'Fertelização');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (5, 'Colheita');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (6, 'Sementeira');
INSERT INTO OperationType(operationTypeID, operationTypeName)
VALUES (7, 'Incorporação no solo');

-- **Table Operation**

INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(1, 06/10/2016, 30, 4, 1, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(2, 10/10/2016, 20, 4, 1, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(3, 07/01/2017, 90, 4, 1, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(4, 08/01/2017, 60, 4, 1, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(5, 08/01/2017, 40, 4, 1, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(6, 10/07/2017, 3, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(7, 10/07/2017, 3, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(8, 10/07/2017, 3, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(9, 10/08/2017, 3.5, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(10, 10/08/2017, 3.5, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(11, 10/08/2017, 3.5, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(12, 10/09/2017, 3, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(13, 10/09/2017, 3, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(14, 10/09/2017, 3, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(15, 04/11/2017, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(16, 04/11/2017, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(17, 10/12/2017, 15, 5, 4, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(18, 10/12/2017, 10, 5, 4, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(19, 10/07/2018, 3.5, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(20, 10/07/2018, 3.5, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(21, 10/07/2018, 3.5, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(22, 10/08/2018, 4, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(23, 10/08/2018, 4, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(24, 10/08/2018, 4, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(25, 02/09/2018, 4, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(26, 02/09/2018, 4, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(27, 02/09/2018, 4, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(28, 10/09/2018, 4, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(29, 10/09/2018, 4, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(30, 10/09/2018, 4, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(31, 17/11/2018, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(32, 17/11/2018, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(33, 10/12/2018, 30, 4, 1, 6);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(34, 03/07/2019, 4, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(35, 03/07/2019, 4, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(36, 03/07/2019, 4, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(37, 10/08/2019, 4.5, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(38, 10/08/2019, 4.5, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(39, 10/08/2019, 4.5, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(40, 15/11/2019, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(41, 15/11/2019, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(42, 05/05/2020, 2200, 5, 5, 11);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(43, 15/05/2020, 1400, 5, 5, 11);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(44, 02/06/2020, 0.6, 5, 6, 12);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(45, 28/08/2020, 600, 5, 5, 12);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(46, 07/09/2020, 1800, 5, 5, 12);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(47, 20/09/2020, 0.6, 5, 6, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(48, 10/10/2020, 36, 5, 6, 7);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(49, 10/10/2020, 0.9, 5, 6, 11);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(50, 10/11/2020, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(51, 10/11/2020, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(52, 15/11/2020, 600, 5, 5, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(53, 05/12/2020, 70, 4, 3, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(54, 05/12/2020, 50, 4, 3, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(55, 10/12/2020, 10, 5, 4, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(56, 10/12/2020, 7, 5, 4, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(57, 15/12/2020, 40, 4, 3, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(58, 15/12/2020, 60, 4, 3, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(59, 18/12/2020, 2500, 5, 5, 13);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(60, 04/01/2021, 2900, 5, 5, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(61, 30/03/2021, , , 7, 10);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(62, 15/04/2021, 30, 5, 6, 9);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(63, 02/05/2021, 10, 5, 4, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(64, 02/05/2021, 10, 5, 4, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(65, 02/05/2021, 10, 5, 4, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(66, 02/05/2021, 10, 5, 4, 6);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(67, 05/05/2021, 2200, 5, 5, 14);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(68, 15/05/2021, 1400, 5, 5, 14);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(69, 02/06/2021, 0.6, 5, 6, 15);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(70, 05/07/2021, 5, 2, 2, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(71, 05/07/2021, 5, 2, 2, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(72, 05/07/2021, 5, 2, 2, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(73, 21/08/2021, 3300, 5, 5, 9);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(74, 24/08/2021, 900, 5, 5, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(75, 28/08/2021, 600, 5, 5, 15);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(76, 05/09/2021, 800, 5, 5, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(77, 07/09/2021, 1800, 5, 5, 15);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(78, 12/09/2021, 800, 5, 5, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(79, 20/09/2021, 0.6, 5, 6, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(80, 23/09/2021, 1200, 5, 5, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(81, 03/10/2021, 36, , 6, 10);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(82, 10/10/2021, 0.9, 5, 6, 14);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(83, 12/10/2021, 950, 5, 5, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(84, 03/11/2021, 750, 5, 5, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(85, 15/11/2021, 600, 5, 5, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(86, 17/11/2021, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(87, 17/11/2021, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(88, 28/11/2021, 70, 4, 3, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(89, 03/12/2021, 90, 4, 3, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(90, 18/12/2021, 60, 4, 3, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(91, 18/12/2021, 2500, 5, 5, 16);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(92, 04/01/2022, 2900, 5, 5, 13);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(93, 05/04/2022, , , 7, 10);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(94, 10/04/2022, 30, 5, 6, 8);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(95, 13/05/2022, 10, 5, 4, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(96, 13/05/2022, 10, 5, 4, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(97, 13/05/2022, 10, 5, 4, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(98, 13/05/2022, 10, 5, 4, 6);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(99, 12/08/2022, 3500, 5, 5, 8);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(100, 20/08/2022, 950, 5, 5, 5);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(101, 07/09/2022, 830, 5, 5, 6);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(102, 11/09/2022, 750, 5, 5, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(103, 20/09/2022, 1150, 5, 5, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(104, 17/10/2022, 850, 5, 5, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(105, 06/11/2022, 900, 5, 5, 4);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(106, 11/09/2022, 750, 5, 5, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(107, 10/11/2022, 30, 4, 3, 1);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(108, 10/11/2022, 20, 4, 3, 2);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(109, 04/12/2022, 70, 4, 3, 6);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(110, 07/12/2022, 90, 4, 3, 3);
INSERT INTO Operation(operationID, date, quantity, FKOperation5286, FKOperation62574, FKOperation394768)
VALUES(111, 12/01/2022, 60, 4, 3, 4);

-- **Table Product_Plantation**

INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (3, 1);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (3, 2);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (3, 1);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (3, 2);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 3);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 3);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 4);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 4);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 5);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 5);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 6);
INSERT INTO Product_Plantation (FKProduct_Pl432922, FKProduct_Pl524542)
VALUES (5, 6);