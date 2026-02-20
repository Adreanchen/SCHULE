# DHCP Windoof aufsetzen

## statisch IP-Adresse einstellen

in einer powershell (ob über ssh oder ned is egal)

* ``````powershell
  New-NetIPAddress -IPAddress 10.0.5.10 -InterfaceAlias "Ethernet0" -DefaultGateway 10.0.5.2 -AddressFamily ipv4 -Prefixlength 24
  ``````

* für das interfacealias muss man nachschaun was da hingehört 

  ```powershell
  ipconfig /all
  ```

* ```powershell
  Set-DnsClientServerAddress -InterfaceAlias "Ethernet0" -ServerAddresses "8.8.8.8", "8.8.4.4"
  ```

* **DHCP-Server installieren**

  ```power
  Install-WindowsFeature -Name DHCP -IncludeManagementTools
  ```

* Pool erstellen: 

  ```power
  Add-DhcpServerv4Scope -Name <name> -StartRange 10.0.5.50 -EndRange 10.0.5.150 -SubnetMask 255.255.255.0 -State Active
  Get-DhcpServerv4Scope
  ```

* DNS-Server setzen `-Optionid 6`

  ```power
  Set-DhcpServerv4OptionValue -Scopeid 10.0.5.0 -Optionid 6 -Value "8.8.8.8"
  Get-DhcpServerv4OptionValue -Scopeid 10.0.5.0
  ```

* Default-gateway setzen `-Optionid 3`

  ```power
  Set-DhcpServerv4OptionValue -Scopeid 10.0.5.0 -Optionid 3 -Value "10.0.5.2"
  Get-DhcpServerv4OptionValue -Scopeid 10.0.5.0
  ```

* 
