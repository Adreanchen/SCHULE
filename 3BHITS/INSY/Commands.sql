CREATE DATABASE Fahrschule_DB;
use Fahrschule_DB;

CREATE TABLE Fahrlehrer ( 
	Vorname varchar(255), 
	Nachname varchar(255), 
	teacher_email varchar(255),
	IBAN varchar(34),
	PRIMARY KEY (teacher_email)
);

CREATE TABLE Fahrschulauto (
	Marke varchar(255),
	Modell varchar(255),
	Kennzeichen varchar(10),
	FIN char(17),
	teacher_email varchar(255),
	PRIMARY KEY (Kennzeichen, FIN),
	FOREIGN KEY (teacher_email) REFERENCES Fahrlehrer(teacher_email)
);

CREATE TABLE Theoriekurs (
	Name varchar(255),
	teacher_email varchar(255),
	Kurs_ID varchar(255),
	PRIMARY KEY (Kurs_ID),
	FOREIGN KEY (teacher_email) REFERENCES Fahrlehrer(teacher_email)
);

CREATE TABLE Fahrschueler (
	Vorname varchar(255),
	Nachname varchar(255),
	student_email varchar(255),
	PRIMARY KEY (student_email)
);

CREATE TABLE Fahrschueler_nimmt_Theoriekurs (
	Kurs_ID varchar(255),
	student_email varchar(255),
	PRIMARY KEY (Kurs_ID, student_email),
	FOREIGN KEY (Kurs_ID) REFERENCES Theoriekurs(Kurs_ID),
	FOREIGN KEY (student_email) REFERENCES Fahrschueler(student_email)
);
	
