1. Einfache SELECT-Aufgaben auf die Tabelle bbc(name, region, area, population, gdp)
   ---------------------------------------------------------------------------------
       gdp (gross domestic product) --> Bruttoinlandsprodukt

   1. Gibt den Namen, die Region und die Bevölkerungszahl aller Länder aus.
     ```sql
     SELECT 
     	name, 
     	region, 
     	population 
     FROM 
     	bbc;
     ```

   2. Wie heißen die vier Länder, deren Bevölkerungszahl mindestens 200 Millionen beträgt?

      ```sql
      SELECT 
      	name 
      FROM 
      	bbc 
      WHERE 
      	population >= 200000000;
      ```

   3. Nenne die Namen und das Pro-Kopf-Einkommen aller Länder mit einer Bevölkerungszahl
      von mindestens 200 Millionen?

      ```sql
      SELECT
          name,
          gdp / population AS "Pro-Kopf-Einkommen"
      FROM
          bbc
      WHERE
          population >= 200000000;
      ```

   4. Ermittle die Namen und die Bevölkerungszahl (in Millionen) der Länder der
      Region 'South America'.
      (Teile die Bevölkerungszahl einfach durch 1.000.000 und runde auf die nächste ganze Zahl.)

      ```sql
      SELECT
          name,
          ROUND(population / 1000000) AS "Bevölkerung Mio."
      FROM
          bbc
      WHERE
          region = 'South America';
      ```

   5. Zeige die Namen und die Bevölkerungszahlen für 'France', 'Germany', 'Italy'.

      ```sql
      SELECT
          name,
          population
      FROM
          bbc
      WHERE
          name IN ('France', 'Germany', 'Italy');
      ```

   6. Ermittle die Länder, deren Namen das Wort 'United' enthält.

      ```sql
      SELECT
          name
      FROM
          bbc
      WHERE
          name LIKE '%United%';
      ```

   7. Ermittle die Größe der Weltgesamtbevölkerung.

      ```sql
      SELECT
          SUM(population) AS "Weltgesamtbevölkerung"
      FROM
          bbc;
      ```

   8. Zeige alle Regionen - aber jede nur einmal.

      ```sql
      SELECT DISTINCT
          region
      FROM
          bbc;
      ```

   9. Wie heißen die Länder mit einem Bruttoinlandsprodukt (gdp) größer als Gesamt-Afrika?

      ```sql
      SELECT
          name
      FROM
          bbc
      WHERE
          gdp > (
              SELECT
                  SUM(gdp)
              FROM
                  bbc
              WHERE
                  region = 'Africa'
          );
      ```

   10. Zeig für jede Region die Region und die Anzahl der zugehörigen Länder.

       ```sql
       SELECT
           region,
           COUNT(name) AS "Anzahl Länder"
       FROM
           bbc
       GROUP BY
           region;
       ```

   11. Ermittle für jede Region die Region und die Anzahl der Länder mit einer
       Bevölkerungszahl von mindestens 10 Millionen.

       ```sql
       SELECT
           region,
           COUNT(name) AS "> 10 Mio. Ew."
       FROM
           bbc
       WHERE
           population >= 10000000
       GROUP BY
           region;
       ```

   12. Erstell eine Liste der Regionen mit einer Gesamtbevölkerung von mindestens 100 Millionen.

       ```sql
       SELECT
           region
       FROM
           bbc
       GROUP BY
           region
       HAVING
           SUM(population) >= 100000000;
       ```