USE Fahrschule_DB;

INSERT INTO Fahrlehrer ( Vorname, Nachname, teacher_email, IBAN ) VALUES ( "Ben", "Tanzer", "ben.tanzer@beste.com", "1234567890IBAN" );
INSERT INTO Fahrlehrer ( Vorname, Nachname, teacher_email, IBAN ) VALUES ( "Tim", "Neumann", "tim.neumann@beste.com", "IBAN1234567890" );

INSERT INTO Theoriekurs ( Name, teacher_email, Kurs_ID ) VALUES ( "WessenTheoriekurs", "ben.tanzer@beste.com", 54321 );
INSERT INTO Theoriekurs ( Name, teacher_email, Kurs_ID ) VALUES ( "TheoriekursIIIHHH", "tim.neumann@beste.com", 15243 );

INSERT INTO Fahrschueler ( Vorname, Nachname, student_email ) VALUES ( "Paul", "albrecht", "paul.albrecht@beste.com" );
INSERT INTO Fahrschueler ( Vorname, Nachname, student_email ) VALUES ( "Sophia", "Liko", "sophia.liko@beste.com" );

INSERT INTO Fahrschulauto ( Marke, Modell, Kennzeichen, FIN, teacher_email ) VALUES ( "VW", "Golf", "KO367CD", 'a', "ben.tanzer@beste.com" );
INSERT INTO Fahrschulauto ( Marke, Modell, Kennzeichen, FIN, teacher_email ) VALUES ( "VW", "Polo", "KO478EF", 'c', "tim.neumann@beste.com" );
