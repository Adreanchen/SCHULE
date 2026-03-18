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

## 6.4

Das Sicherheitsniveau asymmetrischer Algorithmen kann erhöht werden, indem größere Bitlängen gewählt werden. Allerdings wirken sich die längeren Parameter direkt auf die Laufzeit der Algorithmen aus. Den Zusammenhang zwischen Ausführungszeit und Sicherheitsniveau wird in dieser Aufgabe untersucht.

Ein Web-Server für einen Online-Shop kann entweder **RSA** oder **ECC** für das Erstellen von digitalen Signaturen verwenden. Die Signaturzeit für **RSA-1024** beträgt **15,7 ms** und für **ECC 1,3 ms**.

1. Wie hoch ist die Laufzeit für eine RSA-Signatur, wenn die Bitlänge aus Sicherheitsgründen von 1024 Bit auf 3072 Bit erhöht wird?
2. Wie erhöht sich die Laufzeit für RSA bei einer Erhöhung von 1024 Bit auf 15.360 Bit?
3. Berechnen Sie die Laufzeiten für ECC, wenn ECC das gleiche Sicherheitsniveau wie RSA-3072 und RSA-15.360 bieten soll.
4. Beschreiben Sie das unterschiedliche Verhalten von RSA und ECC, wenn das Sicherheitsniveau erhöht wird.

**Hinweis:** Die Rechenlaufzeit von RSA und ECC wächst kubisch mit der Bitlänge. Tab. 6.1 gibt die Sicherheitsniveaus von ECC und RSA an.

### 1. RSA: 1024 Bit $\to$ 3072 Bit

$$
T_{RSA,3072} = 15,7 \text{ ms} \cdot \left( \frac{3072}{1024} \right)^3
$$

$$
T_{RSA,3072} = 15,7 \text{ ms} \cdot 3^3 = 15,7 \text{ ms} \cdot 27
$$

$$
T_{RSA,3072} = \mathbf{423,9 \text{ ms}}
$$

### 2. RSA: 1024 Bit $\to$ 15.360 Bit

$$
T_{RSA,15360} = 15,7 \text{ ms} \cdot \left( \frac{15360}{1024} \right)^3
$$

$$
T_{RSA,15360} = 15,7 \text{ ms} \cdot 15^3 = 15,7 \text{ ms} \cdot 3375
$$

$$
T_{RSA,15360} = \mathbf{52.987,5 \text{ ms}} \approx \mathbf{53 \text{ s}}
$$

### 3. ECC (Äquivalente Sicherheitsniveaus)

**Für Niveau RSA-3072 ($\approx$ ECC-256):**
$$
T_{ECC,256} = 1,3 \text{ ms} \cdot \left( \frac{256}{160} \right)^3
$$

$$
T_{ECC,256} = 1,3 \text{ ms} \cdot 1,6^3 = 1,3 \text{ ms} \cdot 4,096
$$

$$
T_{ECC,256} \approx \mathbf{5,32 \text{ ms}}
$$

**Für Niveau RSA-15360 ($\approx$ ECC-512):**
$$
T_{ECC,512} = 1,3 \text{ ms} \cdot \left( \frac{512}{160} \right)^3
$$

$$
T_{ECC,512} = 1,3 \text{ ms} \cdot 3,2^3 = 1,3 \text{ ms} \cdot 32,768
$$

$$
T_{ECC,512} \approx \mathbf{42,60 \text{ ms}}
$$

