## Einführung

- **SQL**
  - Structured Query Language
  - Programmiersprache für die Abfrage von relationalen Datenbanken
  - Datenbanken in Form von Tabellen
  - Beispiele: MySQL, Oracle, ...
- **noSQL**
  - not only SQL
  - Datenbanken nicht aus Tabellen aufgebaut
  - Beispiele: MongoDB, Redis, ...

### Kategorien:
- **Spaltenorientierte Datenbanken**<br>
  speichern Daten in Form von Spalten und nicht in Zeilen
- **Schlüssel-Werte-Datenbanken**<br>
  ein Wert wird mithilfe eines Schlüssels eruiert
- **Dokumentenspeicher**<br>
  speichert Daten in Form von Dokumenten, die beliebig strukturiert werden können
- **Graph-Datenbanken**<br>
  speichern Daten in Form einer Graphenstruktur, bei der Knoten und Kanten die Daten miteinander verbinden

### Skalierbarkeit:
- SQL-DB werden in der Regel vertikal skaliert (mehr Leistung für den Server)
- noSQL-DB werden in der Regel horizontal skaliert (hinzufügen von weiteren Servern)

### Datenbanktransaktionsmodelle:
- **ACID** (SQL-DB halten sich an das ACID-Prinzip)<br>
  mit diesen Regeln wird sichergestellt, das die Daten sicher und zuverlässig gespeichert werden (alle Regeln müssen eingehalten werden)
  - A ... Atomarität (Atomicity)
  - K ... Konsistenz (Consistency)
  - I ... Isolation
  - D ... Dauerhaftigkeit (Durability)
- **CAP**-Theorem (noSQL folgen dem CAP-Theorem)
  Das CAP-Therorem besagt jedoch, dass nur 2 der 3 Eigenschaften garantiert werden können
  - C ... Konsistenz (Consistency)
  - A ... Verfügbarkeit (Availabilty)
  - P ... Teilungstoleranz (Partition Tolerance)
- **BASE**-Theorem (Basically Available, Soft State and eventual consistancy)
- bei SQL steht die Sicherheit und Zuverlässigkeit im Vordergrund
- bei noSQL ist die Speicherung und Verarbeitung flexibler, gleichzeitig kann nicht sichergestellt werden, dass die daten sicher gespeichert werden oder die Transaktionen sicher und konstistent verarbeitet werden.
- [https://medium.com/@pranabj.aec/acid-cap-and-base-cc73dee43f8c](https://medium.com/@pranabj.aec/acid-cap-and-base-cc73dee43f8c)
- [https://aws.amazon.com/de/compare/the-difference-between-acid-and-base-database/](https://aws.amazon.com/de/compare/the-difference-between-acid-and-base-database/)

### Datenbankabfragesprachen
- SQL ist eine weit verbreitete Sprache - sicher und eignet sich gut für komplexe Abfragen; Sprache bezieht sich auf Tabellen
- mit noSQL-Sprachen können auch alternative Strukturen (keine Tabellenstruktur) abgefragt werden

### Einsatz in Unternehmen:
- SQL:
  - Verarbeitung strukturierter Daten
  - komplexe Abfragen
- noSQL:
  - für schnelles Wachstum
  - Verarbeitung von unstrukturierter Daten
  - Flexibilität
  - kein vordefiniertes Tabellenschema

## Links YouTube
- [https://www.youtube.com/watch?v=kvLbRit22AM](https://www.youtube.com/watch?v=kvLbRit22AM)
- [https://www.youtube.com/watch?v=VfcRxtBKI54](https://www.youtube.com/watch?v=VfcRxtBKI54)
- [https://www.youtube.com/watch?v=2Pv-uUozpV4](https://www.youtube.com/watch?v=2Pv-uUozpV4)
- [https://www.youtube.com/watch?v=IJ8gdGPJz6k](https://www.youtube.com/watch?v=IJ8gdGPJz6k)
- [https://www.youtube.com/watch?v=Pf-9pjJK1e0](https://www.youtube.com/watch?v=Pf-9pjJK1e0)
- [https://www.youtube.com/watch?v=W1NbRuRnvrc](https://www.youtube.com/watch?v=W1NbRuRnvrc)
- [https://www.youtube.com/watch?v=HOtrRY583YE&t=6s](https://www.youtube.com/watch?v=HOtrRY583YE&t=6s)
- [https://www.youtube.com/watch?v=B3gJT3t8g4Q](https://www.youtube.com/watch?v=B3gJT3t8g4Q)

## Links
- [https://www.opendata.uni-halle.de/bitstream/1981185920/12751/1/Masterarbeit%20Dennis%20Maximilian%20Hofmann.pdf](https://www.opendata.uni-halle.de/bitstream/1981185920/12751/1/Masterarbeit%20Dennis%20Maximilian%20Hofmann.pdf)
- [https://www.ionos.at/digitalguide/hosting/hosting-technik/nosql/](https://www.ionos.at/digitalguide/hosting/hosting-technik/nosql/)
- [https://learn.microsoft.com/de-de/azure/architecture/data-guide/big-data/non-relational-data](https://learn.microsoft.com/de-de/azure/architecture/data-guide/big-data/non-relational-data)
- [https://www.digitalocean.com/community/tutorials/a-comparison-of-nosql-database-management-systems-and-models](https://www.digitalocean.com/community/tutorials/a-comparison-of-nosql-database-management-systems-and-models)
- [https://airbyte.com/data-engineering-resources/sql-vs-nosql](https://airbyte.com/data-engineering-resources/sql-vs-nosql)
- [https://datascientest.com/de/sql-vs-nosql-unterschiede-anwendungen-vor-und-nachteile](https://datascientest.com/de/sql-vs-nosql-unterschiede-anwendungen-vor-und-nachteile)
- [https://www.datacamp.com/blog/nosql-databases-what-every-data-scientist-needs-to-know?utm_source=google&utm_medium=paid_search&utm_campaignid=19589720818&utm_adgroupid=152984009694&utm_device=c&utm_keyword=&utm_matchtype=&utm_network=g&utm_adpostion=&utm_creative=684592138943&utm_targetid=dsa-2222697811358&utm_loc_interest_ms=&utm_loc_physical_ms=20044&utm_content=DSA~blog~Data-Science&utm_campaign=230119_1-sea~dsa~tofu_2-b2c_3-eu_4-prc_5-na_6-na_7-le_8-pdsh-go_9-na_10-na_11-na&gad_source=1&gclid=EAIaIQobChMIoaad-9CmhAMVDJCDBx3ZRgd_EAMYASAAEgImFfD_BwE](https://www.datacamp.com/blog/nosql-databases-what-every-data-scientist-needs-to-know?utm_source=google&utm_medium=paid_search&utm_campaignid=19589720818&utm_adgroupid=152984009694&utm_device=c&utm_keyword=&utm_matchtype=&utm_network=g&utm_adpostion=&utm_creative=684592138943&utm_targetid=dsa-2222697811358&utm_loc_interest_ms=&utm_loc_physical_ms=20044&utm_content=DSA~blog~Data-Science&utm_campaign=230119_1-sea~dsa~tofu_2-b2c_3-eu_4-prc_5-na_6-na_7-le_8-pdsh-go_9-na_10-na_11-na&gad_source=1&gclid=EAIaIQobChMIoaad-9CmhAMVDJCDBx3ZRgd_EAMYASAAEgImFfD_BwE)

