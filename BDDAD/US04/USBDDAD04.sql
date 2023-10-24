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

-- **Table Building**

INSERT INTO Building(buildingID, designation, area, buildingTypeID, unityID)
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

