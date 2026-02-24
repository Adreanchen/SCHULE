# Install OpenSSH

## 1️⃣ Update Package Lists

Before installing anything, make sure your package list is up to date:

````bash
apt update
````

⚠️ Note: You need to be logged into the `root` user

## 2️⃣ Install OpenSSH Server

```bash
apt install openssh-server -y
```

## 3️⃣ Restart SSHD service

````bash
systemctl restart sshd
````

## 4️⃣ Check SSHD status

```bash
systemctl status sshd
```

 ⚠️ Note: Needs to be `active (running)`

**🎉 Congratulations! Youre all set**

# SSH Connection

## 1️⃣ Generate an SSH Key (local)

```bash
ssh-keygen
```

- When prompted, choose a **custom key name**  (e.g. SYT_3BHITS)

## 2️⃣ Navigate to the SSH Directory

``````bash
cd ~/.ssh/
``````

## 3️⃣ Copy the Public Key to the Server

``````bash
ssh-copy-id -i <keyname>.pub -p <port> <username>@localhost
``````

---

### A. Connect Using SSH Key

``````bash
ssh -p <port> -i <keyname> <username>@localhost
``````

### B. Connection using Password

``````bash
ssh <username>@localhost -p <port>
``````

---

### Manually Upload SSH Key to Debian (if ssh-copy-id doesn't work)

```bash
scp -P <port> <keyname>.pub <username>@localhost:
```

📌 Note: Don't add anything after the `:` → the key will be copied to the user's home directory (~)

## Add SSH Connection to Config file

⚠️ Note: These commands are executed locally!

- Navigate to `~/.ssh/config`

Add the following (example):

``````bash
Host	debian_DHCP
			Hostname localhost
			Port 4448
			User debian_admin
			IdentityFile ~/.ssh/SYT_3BHITS
``````

---

<p align="center">© 2025 Tim Neumann. ALL RIGHTS RESERVED.</p>