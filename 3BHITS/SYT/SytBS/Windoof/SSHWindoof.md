# How to SSH auf Windoof

überprüfen auf der VM:

```powershell
Get-WindowsCapability -Online | Where-Object { $_.Name -like "*ssh*" }
```

bzw. starten und das automatic setzen

```powershell
Get-Service | Where-Object { $_.Name -like "*sshd*" } | Start-Service
```

```powershell
Get-Service | Where-Object { $_.Name -like "*sshd*" } | Set-Service -StartupType Automatic
```

```powershell
Get-NetFirewallRule | Where-Object { $_.Name -like "*ssh*" }
```

```powershell
Set-NetConnectionProfile -NetworkCategory Private
```



**in den Networksettings von der VMware muss man Portforwarding adden/einrichten (schaun dass da keine doppelten)**

```shell
ssh -p <Port> Administrator@localhost
```

