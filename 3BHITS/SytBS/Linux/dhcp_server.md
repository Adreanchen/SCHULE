# Set up NAT Network

### 1️⃣ Create NAT Network

**In VirtualBox, under Network --> NAT Network --> Create**

Name: e.g. `3BHITS` (you can decide, name doesnt matter)

IPv4 Prefix: `10.0.5.0/24`

**Go to `Port Forwarding`**

- Add a rule
  - Host Port: `4448` (if you already have that port in another rule, choose another, e.g. `4449`)
  - Guest IP: `10.0.5.10`
  - Guest Port: `22`

### 2️⃣ Select NAT Network in VM

Under VM settings, go to Network an change `attached to` to

``````
NAT Network
``````

Boot VM again

# Set up DHCP Server

*Important Information:* Log into `root` user on the VM (`su -`)

### 1️⃣ Update system

``````bash
apt update && apt upgrade -y
``````

### 2️⃣ Change interface to static

```````bash
vi /etc/network/interfaces
```````

Change this line (or comment it out):
`````bash
iface enp0s3 inet dhcp
`````

To this:

```bash
iface enp0s3 inet static
		address 10.0.5.--/24
		gateway 10.0.5.1
```

**Restart networking.service:**

````bash
systemctl restart networking.service
````

**Check if ip is static:**

```bash
ip a
```

### 3️⃣ Install Kea DHCP Server

```````bash
apt install kea-dhcp4-server -y
```````

### 4️⃣ Edit DHCP config

> replace the .conf file with the one provided

### 5️⃣ Enable DHCP server

``````bash
systemctl enable kea-dhcp4-server # not nessecary
``````

``````bash
systemctl restart kea-dhcp4-server
``````

### 6️⃣ Check the status of the DHCP server

````bash
systemctl status kea-dhcp4-server
````

> needs to be `active (running)`

---

<p align="center">© 2025 Tim Neumann. ALL RIGHTS RESERVED.</p>

