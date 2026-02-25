# 6.6 Aufgaben

## 6.1

In diesem Kapitel wurde gezeigt, dass asymmetrische Algorithmen für den Schlüsselaustausch und digitale Signaturen eingesetzt werden können, was beides nicht mit symmetrischer Kryptografie möglich ist. Darüber hinaus kann man mit asymmetrischen Verfahren auch klassische Datenverschlüsselung durchführen. Die Frage ist nun, warum für die Praxis nach wie vor symmetrische Kryptoverfahren benötigt werden?

**Das symmetrische Kryptoverfahren ist schneller und effizienter.**

## 6.2

In dieser Aufgabe wird der Rechenaufwand für symmetrische und asymmetrische Algorithmen verglichen. Wir nehmen an, eine Bibliothek wie z. B. OpenSSL kann Daten mit einer Geschwindigkeit von 100 Kbit/s mithilfe des RSA-Verfahrens auf einem PC dechiffrieren. Auf dem gleichen Rechner entschlüsselt AES mit einer Datenrate von 17 Mbit/s. Wir möchten nun einen 1 GByte großen Film, der auf einer DVD gespeichert ist, dechiffrieren. Wie lange dauert dies mit den beiden Kryptoverfahren?

1 GByte=1024 MByte

$1024 \text{ MByte} \times 8 = 8192 \text{ Mbit} $

$8192 \text{ Mbit} \times 1024 = 8.388.608 \text{ Kbit} $
$$
t_{RSA} = \frac{8.388.608 \text{ Kbit}}{100 \text{ Kbit/s}} = 83886 \text{ s} \approx 23{,}3 \text{ Stunden}
$$

$$
t_{AES} = \frac{8.192 \text{ Mbit}}{17 \text{ Mbit/s}} = 482 \text{ s} \approx 8 \text{ Minuten}
$$



## 6.3

Gegeben sei ein kleineres Unternehmen mit 120 Mitarbeitern. Es wird eine neue Sicherheitsrichtlinie eingeführt, nach der sämtliche E-Mail-Kommunikation mit symmetrischer Kryptografie verschlüsselt werden muss. Wie viele Schlüssel werden in dem Unternehmen benötigt, wenn jeder Mitarbeiter mit jedem anderen sicher E-Mail austauschen können soll?
$$
K = \frac{n \cdot (n - 1)}{2}
$$

$$
K = \frac{120 \cdot 119}{2} = \frac{14.280}{2} = 7.140
$$