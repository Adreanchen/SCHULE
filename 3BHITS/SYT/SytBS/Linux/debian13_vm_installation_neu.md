# Debian 13 VM Installation

# Debian 13 – Installation Manual (Expert Install)

## Start
- **Advanced Options**
- **Expert Install**
- **Debian Installer Main Menu**

## Language and Region
- Language: `English`
- Location: `Other → Europe → Austria`
- Locale: `en_US`
- Keyboard layout: `English (UK)` (if using a German keyboard, change to `DE`)

## Keyboard Configuration
- In the Main Menu, select the **second option** → Press `Enter`
- Select **Keyboard** → Press `Enter`
- Keep pressing `Enter` until the setup is complete

## Network
- **Configure Network → Auto Configure**
- Hostname: `debian13`
- Domain: leave empty / clear

## Users and Passwords
- Login as **Root**: `Yes`
- Root password: `einfach`
- Create regular user: `Yes`
  - Username: `debian_admin`
  - Password: `einfach`

## Time and Date
- Configure Clock with NTP: `Yes`

## Partitioning
- **Partition Disks → Manual**
- Select the disk
- Partitioning: `Yes`
- Partition table type: `GPT`
- Create partitions:
  - 250 MB → EFI Boot Partition
  - 2 GB → Swap Area
  - Remaining Space → Ext4
- Finish partitioning and write changes to disk: `Yes`

## Install the Base System
- **Install the Base System**
- Kernel: `linux-image-arm64` (default) **⚠️ Note: On most windows computers its `amd64`**
- Drivers: `targeted` (lower option)

## Package Management
- Scan extra installation media: `No`
- Use network mirror: `Yes`
- Protocol: `HTTP`
- Non-Free Firmware: `No`
- Non-Free Software: `No`
- Contrib software: `yes`
- APT-Repository: `Yes`
- Security Updates: `Yes`

## Software Selection
- **Select and Install Software**
- Security updates: `automatically install`
- Participate in the package usage survey: `no`
- Software selection:
  - Deselect everything except **Standard system utilities**
- Confirmation:
  - Force: `Yes`
  - Update: `Yes`
- Run OS-Prober: `No`

## Finish
- Finish installation: **Finish**
- Timezone: `UTC → Yes`
- Reboot: `Continue to Reboot → Yes`

# VirtualBox Guest Additions (Apple Silicon / ARM64)

## 1️⃣ Insert Guest Additions
- In the Menubar:  
  **Devices → Insert Guest Additions CD Image**

## 2️⃣ Mount the CD
```bash
sudo mount /dev/cdrom /media/cdrom
cd /media/cdrom
(ls -l)
```

## 3️⃣ Start the Installation

``````bash
./VBoxLinuxAdditions-arm64.run
# use sudo if required
``````

- ⚠️ Note
  - `-arm64` is only required for **Apple Silicon Chips (arm64)**
  - on most Windows machines, this is not needed
  
  ---

<p align="center">© 2025 Tim Neumann. ALL RIGHTS RESERVED.</p>