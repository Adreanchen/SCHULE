# Projekt: Netzwerk „Grüne Wiese“ Dokumentation

**Klasse:** 3BHITS

**Name:** Adrian Fritz

**Katalognummer:** 5

------

## 1. Ausgangslage & IP-Konzept

Für das Projekt wurde eine Netzwerk-Infrastruktur entworfen, die auf einer VLAN-Trennung basiert. Das Routing zwischen den VLANs übernimmt ein zentraler **Cisco 2911 Router**. Gemäß der Vorgabe wurde das Netz **10.5.0.0/23** verwendet.

### IP-Adressen-Tabelle

| **VLAN** | **Name**   | **Netz-IP** | **Gateway** | **Maske**       | **CIDR** |
| -------- | ---------- | ----------- | ----------- | --------------- | -------- |
| 10       | Stock_E    | 10.5.0.0    | 10.5.0.1    | 255.255.255.224 | /27      |
| 20       | Stock_1    | 10.5.0.32   | 10.5.0.33   | 255.255.255.224 | /27      |
| 30       | Stock_2    | 10.5.0.64   | 10.5.0.65   | 255.255.255.224 | /27      |
| 40       | Grafik     | 10.5.0.96   | 10.5.0.97   | 255.255.255.224 | /27      |
| 50       | Stock_4    | 10.5.0.128  | 10.5.0.129  | 255.255.255.240 | /28      |
| 60       | WLAN (AP)  | 10.5.1.0    | 10.5.1.1    | 255.255.255.128 | /25      |
| 99       | Management | 10.5.0.224  | 10.5.0.225  | 255.255.255.240 | /28      |

------

## 2. Netzwerk-Topologie

Die Infrastruktur nutzt eine Stern-Topologie. Der **Cisco 2911 Router** dient als Gateway. Der **Core-Switch (3650)** verteilt die VLANs per Trunk an die Stockwerk-Switches.

<img src="topologie.png" alt="bild von topologie">

------

## 3. DHCP-Konfiguration

Ein zentraler DHCP-Server (IP: 10.5.0.230) im Management-VLAN versorgt alle Endgeräte. Da sich der Server in einem anderen Subnetz befindet, wurde auf den Subinterfaces des Routers ein **DHCP-Relay-Agent (ip helper-address)** konfiguriert.

**Wichtig:** Der DHCP-Server nutzt das Gateway **10.5.0.225**, um VLAN-übergreifend zu antworten.

| Pool                   | Gateway    | Start IP   | Maske           |
| ---------------------- | ---------- | ---------- | --------------- |
| VLAN 10 (EG)           | 10.5.0.1   | 10.5.0.2   | 255.255.255.224 |
| VLAN 20 (1 SW)         | 10.5.0.33  | 10.5.0.34  | 255.255.255.224 |
| VLAN 30 (2 SW)         | 10.5.0.65  | 10.5.0.66  | 255.255.255.224 |
| VLAN 40 (Grafiker)     | 10.5.0.97  | 10.5.0.98  | 255.255.255.224 |
| VLAN 50 (4 SW)         | 10.5.0.129 | 10.5.0.130 | 255.255.255.240 |
| VLAN 70 (IP telephone) | 10.5.1.1   | 10.5.1.2   | 255.255.255.128 |
| VLAN 80 (Drucker)      | 10.5.1.129 | 10.5.1.130 | 255.255.255.240 |

<img src="DHCP_pools.png" alt="bild von den DHCP pools">

------

## 4. CLI-Konfiguration

### 4.1 Cisco 2911 Router (Inter-VLAN Routing)

Der Router übernimmt das Routing mittels Subinterfaces am Port G0/0.

```
enable
configure terminal
hostname Main-Router

interface GigabitEthernet0/0
 no shutdown
 exit

interface GigabitEthernet0/0.10
 encapsulation dot1Q 10
 ip address 10.5.0.1 255.255.255.224
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.20
 encapsulation dot1Q 20
 ip address 10.5.0.33 255.255.255.224
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.30
 encapsulation dot1Q 30
 ip address 10.5.0.65 255.255.255.224
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.40
 encapsulation dot1Q 40
 ip address 10.5.0.97 255.255.255.224
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.50
 encapsulation dot1Q 50
 ip address 10.5.0.129 255.255.255.240
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.60
 encapsulation dot1Q 60
 ip address 10.5.1.1 255.255.255.128
 ip helper-address 10.5.0.230
exit

interface GigabitEthernet0/0.99
 encapsulation dot1Q 99
 ip address 10.5.0.225 255.255.255.240
exit

do write
```

### 4.2 Core-Switch 3650 (VLAN Distribution)

Der Core-Switch arbeitet als Layer-2-Verteiler. Das globale IP-Routing ist deaktiviert.

```
enable
configure terminal
hostname Core-Adrian

no ip routing

vlan 10
 name Stock_E
vlan 20
 name Stock_1
vlan 30
 name Stock_2
vlan 40
 name Grafik
vlan 50
 name Stock_4
vlan 60
 name WLAN
vlan 99
 name Management
exit

interface range GigabitEthernet1/0/1 - 5
 switchport trunk encapsulation dot1q
 switchport mode trunk
exit

interface GigabitEthernet1/0/22
 switchport trunk encapsulation dot1q
 switchport mode trunk
exit

interface GigabitEthernet1/0/24
 switchport trunk encapsulation dot1q
 switchport mode trunk
exit

interface GigabitEthernet1/0/23
 switchport mode access
 switchport access vlan 99
 spanning-tree portfast
exit

do write
```

### 4.3 Stockwerk-Switches (Beispiel Stockwer EG)

Diesen Block musst du auf jedem kleinen Switch anpassen (nur das VLAN beim `switchport access` ändern).

```
enable
configure terminal

vlan 10
vlan 20
vlan 30
vlan 40
vlan 50
vlan 60
vlan 99
exit

interface GigabitEthernet0/1
 switchport mode trunk
exit

interface range FastEthernet0/1 - 24
 switchport mode access
 switchport access vlan 10
 spanning-tree portfast
exit

do write
```

------

## 5. Funktionsprüfung

Der Erfolg der Konfiguration wurde durch einen Ping-Test vom Router zum DHCP-Server sowie durch die korrekte IP-Zuweisung an den Endgeräten verifiziert. (ein PC aus dem 2ten Stockwerk)

<img src="screenshot_von_ipconfig_all.png" alt="fild von einem ipconfig /all">