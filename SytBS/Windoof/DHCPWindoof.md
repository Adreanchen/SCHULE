# DHCP Windoof aufsetzen

## statisch IP-Adresse einstellen

in einer powershell

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

* 

