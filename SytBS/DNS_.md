# DNS (Domain Name Server)

[root Server auf der Welt](https://root-servers.org)

## nslookup und/oder dig

nslookup oder dig ist dafür da, dass man auf einen anderen **NS (NameServer auch rootServer)** zugreifen/verwenden kann und so nachschauen kann woher addressen kommen

NS        record	NameServer

A	  record	Name -> IPv4 Adresse

AAAA   record	Name -> IPv6 Adresse

PTR      record	IP Adresse -> Name

MX       record	MailExchanger

TXT      record	Texteintrag

### :one: nslookup

```bash
nslookup

> server # zeigt den aktuellen an
> server <ip-addresse vom NameServer> # switched zu dem NS server
> set type=NS <name von welchen server welcher dns zuständig is> <eigentlich keine ahnung> # einf machen
> ac.at. # gibt die zurück wo das hald vorkommt (geht auch mit at. oder de. oder htl-hl.ac.at. ...)
```

### :two: dig

```bash
dig @<ip-addresse vom NameServer> NS # hier kommt sowas wie NS, A, AAAA, ... hin das ist die auflösung
```

## resolve

**!Man sollte nie einen resolver öffentlich machen da er ein risiko von Sicherheit ist!**

```bash
sudo -s
apt install systemd-resolved
exit
resolvectl show-cache # da sieht man was man alles "angesurft hat"
```

