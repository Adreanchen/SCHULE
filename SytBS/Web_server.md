# Web Server install

## bissi Theorie

zür verfügung steht APACHE	|	NGINX	|	IIS (Windoof)

* apt install apache2
* wichtig: 
  * sites-available (anschaun)
  * sites-enabled 

* ned so wichtig (brauch ma ned so wirklich)
  * apache2.conf
  * und den rest

## so machen aufsetzten eine neue website und machen anschauen

### :one: in dem **000...** file

* **DocumentRoot** sagt an wo meine files liegen

### :two: neues file erstellen mit **001-<name>.conf** **alles nur ein BSP**

* html auf **htl**
* port ändern von **80** auf **8080**

### :three: dann einen ordner in /var/www erstellen in dem fall "**htl**"

* in **htl** ein **index.html** ganz simple ein index mit bissi was anlegen z.B.:

```html
<h1>Furzipoops</h1>
```

### :four: jetzt im **(vim) /etc/apache2/ports.conf** file muss man noch eine zeile hinzufügen

es steht irgendwo am anfang:

```bash
Listen 80
```

auf:

```bash
Listen 80
Listen <den port den du für die website angegeben hast im sites-available>
```

### :five: im sites-available **a2ensite** aktiviert (a2dissite ist zum deaktivieren) das file und es sagt die dass du was **reloaden/restart** musst

```ba
a2ensite 001<name>.conf
# warten
systemctl reload apache2.service
```

### :six: ​jetzt muss im sites-enabled ein neues linked file sein welches wir gerade erstellt haben

### :seven: ja jetzt nur über die grafische vm überprüfen indem man in einem browser die ip:port aufruft

## Wenn du wollen machen von außerhalb machen aufrufen diese Seite

* unter network eine neue Rule mit
  * Host Port: 8080
  * Guest IP: muss die selbe sein die der webserver hat
  * Guest Port: 8080

