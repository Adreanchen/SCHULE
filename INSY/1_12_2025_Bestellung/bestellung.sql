DROP DATABASE IF EXISTS MY_AMAZON;
CREATE DATABASE MY_AMAZON;
USE MY_AMAZON;

CREATE TABLE Kunde (
	KundenID int PRIMARY KEY AUTO_INCREMENT,
	Kundenname varchar(255) NOT NULL,
	Kundenemail varchar(255) UNIQUE
);

CREATE TABLE Lieferanten (
	LieferantenID int PRIMARY KEY AUTO_INCREMENT,
	LieferantName varchar(255) NOT NULL,
	Lieferantenemail varchar(255) UNIQUE
);

CREATE TABLE Produkte (
	 ProduktID varchar(10) PRIMARY KEY,
	 ProduktName varchar(100) NOT NULL,
	 Produktkategorie varchar(50),
	 Stueckpreis decimal(10, 2) NOT NULL,
	 LieferantenID int NOT NULL,
	 FOREIGN KEY (LieferantenID) REFERENCES Lieferanten(LieferantenID)
);

CREATE TABLE Bestellungen (
	Bestellnummer int PRIMARY KEY AUTO_INCREMENT,
	Bestelldatum DATETIME NOT NULL,
	KundenID int,
	FOREIGN KEY (KundenID) REFERENCES Kunde(KundenID)
);

CREATE TABLE Bestellpositionen (
	Bestellnummer int,
	ProduktID varchar(10),
	Menge int NOT NULL,
	PRIMARY KEY(Bestellnummer, ProduktID),
	FOREIGN KEY (Bestellnummer) REFERENCES Bestellungen(Bestellnummer),
	FOREIGN KEY (ProduktID) REFERENCES Produkte(ProduktID)
);