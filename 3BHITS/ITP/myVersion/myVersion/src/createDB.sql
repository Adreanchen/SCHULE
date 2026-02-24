DROP DATABASE IF EXISTS Gebrauchtwagenverwaltung;
CREATE DATABASE Gebrauchtwagenverwaltung;
use Gebrauchtwagenverwaltung;
CREATE TABLE Car(`CAR_ID` INT PRIMARY KEY AUTO_INCREMENT, brand VARCHAR(255), model VARCHAR(255), `firstRegistration` INT, kilometer DOUBLE, price DOUBLE, `dateOfPriceChange` date, automatic BOOLEAN, `range` INT, `power` INT);
CREATE TABLE UserData(`U_ID` INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), email VARCHAR(255), adminRights BOOLEAN);