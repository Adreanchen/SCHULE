CREATE DATABASE MYAMAZON;

USE MYAMAZON;

-- Kunden Tabelle
CREATE TABLE Kunden (
    KundenID INT PRIMARY KEY AUTO_INCREMENT,
    Kundenname VARCHAR(255) NOT NULL,
    Kunden_Email VARCHAR(255) UNIQUE
);

-- Lieferanten Tabelle
CREATE TABLE Lieferanten (
    LieferantenID INT PRIMARY KEY AUTO_INCREMENT,
    Lieferantenname VARCHAR(255) NOT NULL,
    Lieferanten_Email VARCHAR(255) UNIQUE
);

-- Produkte Tabelle
CREATE TABLE Produkte (
    ProduktID VARCHAR(10) PRIMARY KEY,
    Produktname VARCHAR(100) NOT NULL,
    Produktkategorie VARCHAR(50),
    Stueckpreis DECIMAL(10, 2) NOT NULL,
    LieferantenID INT NOT NULL,
    FOREIGN KEY (LieferantenID) REFERENCES Lieferanten(LieferantenID)
);

-- Bestellungen Tabelle
CREATE TABLE Bestellungen (
    Bestellnummer INT PRIMARY KEY AUTO_INCREMENT,
    Bestelldatum DATETIME NOT NULL,
    KundenID INT,
    FOREIGN KEY (KundenID) REFERENCES Kunden(KundenID)
);

-- Bestellpositionen Tabelle (Verknüpfungstabelle)
CREATE TABLE Bestellpositionen (
    Bestellnummer INT,
    ProduktID VARCHAR(10),
    Menge INT NOT NULL,
    PRIMARY KEY (Bestellnummer, ProduktID),
    FOREIGN KEY (Bestellnummer) REFERENCES Bestellungen(Bestellnummer),
    FOREIGN KEY (ProduktID) REFERENCES Produkte(ProduktID)
);
