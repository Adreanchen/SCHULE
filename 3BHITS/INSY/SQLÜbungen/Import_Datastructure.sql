-- Tabellen erstellen

CREATE TABLE abteilung (
    abt_id INT PRIMARY KEY,
    abt_name VARCHAR(50),
    standort VARCHAR(50)
);

CREATE TABLE mitarbeiter (
    ma_id INT PRIMARY KEY,
    vorname VARCHAR(50),
    nachname VARCHAR(50),
    gehalt DECIMAL(10, 2),
    abt_id INT,
    FOREIGN KEY (abt_id) REFERENCES abteilung(abt_id)
);

CREATE TABLE projekt (
    proj_id INT PRIMARY KEY,
    titel VARCHAR(100),
    budget DECIMAL(12, 2)
);

CREATE TABLE mitarbeiter_projekt (
    ma_id INT,
    proj_id INT,
    stunden INT,
    PRIMARY KEY (ma_id, proj_id),
    FOREIGN KEY (ma_id) REFERENCES mitarbeiter(ma_id),
    FOREIGN KEY (proj_id) REFERENCES projekt(proj_id)
);

-- Daten in Abteilung einfügen

INSERT INTO abteilung (abt_id, abt_name, standort) VALUES
(1, 'IT', 'Berlin'),
(2, 'Personal', 'München'),
(3, 'Vertrieb', 'Berlin'),
(4, 'Marketing', 'Hamburg'),
(5, 'Forschung', 'München');

-- Daten in Mitarbeiter einfügen

INSERT INTO mitarbeiter (ma_id, vorname, nachname, gehalt, abt_id) VALUES
(101, 'Max', 'Müller', 4500.00, 1),
(102, 'Anna', 'Schmidt', 5200.00, 1),
(103, 'Tom', 'Becker', 3100.00, 2),
(104, 'Laura', 'Wagner', 4800.00, 3),
(105, 'Simon', 'Hoffmann', 2900.00, 3),
(106, 'Julia', 'Richter', 3800.00, 4),
(107, 'Felix', 'Klein', 4100.00, 1),
(108, 'Sarah', 'Schröder', 3600.00, 2);

-- Daten in Projekt einfügen

INSERT INTO projekt (proj_id, titel, budget) VALUES
(10, 'Website Relaunch', 15000.00),
(20, 'CRM Einführung', 35000.00),
(30, 'Messe Berlin', 8000.00),
(40, 'Mitarbeiterbefragung', 2000.00);

-- Daten in die Zuordnungstabelle (Mitarbeiter arbeiten an Projekten) einfügen

INSERT INTO mitarbeiter_projekt (ma_id, proj_id, stunden) VALUES
(101, 10, 40),
(102, 10, 35),
(106, 10, 20),
(101, 20, 80),
(104, 20, 50),
(107, 20, 120),
(104, 30, 45),
(105, 30, 30),
(106, 30, 60),
(103, 40, 15),
(108, 40, 25);
