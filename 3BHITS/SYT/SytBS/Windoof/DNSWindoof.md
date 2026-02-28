# Windoof DNS aufsetzen

* ```powershell
  Install-WindowsFeature DNS -IncludeManagementTools
  ```

* ```powershell
  Add-DnsServerPrimaryZone -Name "3bhits.local" -ZoneFile "3bhits.local"
  ```

* ```powershell
  Set-DnsServerForwarder -IPAddress "8.8.4.4"
  Add-DnsServerForwarder -IPAddress "8.8.8.8"
  Get-DnsServerForwarder
  ```

* ```powershell
  Add-DnsServerResourceRecordA -IPv4Address 10.0.5.10 -Name ns1.3bhits.local -ZoneName 3bhits.local
  ```

* ```powershell
  Set-DnsClientServerAddress -InterfaceAlias Ethernet0 -ServerAddresses "10.0.5.10"
  ```

* ```powershell
  Set-DhcpServerv4OptionValue -Scopeid 10.0.5.0 -DnsServer 10.0.5.10
  Set-DhcpServerv4OptionValue -ScopeId 10.0.5.0 -OptionId 6 -Value 10.0.5.10 # andere art
  Get-DhcpServerv4OptionValue -Scopeid 10.0.5.0
  ```
  
* ```powershell
  Get-DnsServerZone
  ```

* ```powershell
  Get-DnsServerResourceRecord 3bhits.local
  ```

* ```powershell
  Add-DnsServerResourceRecordA -ZoneName priVate.local -Name "www" -IPv4Address "10.0.10.17"
  ```

* ```powershell
  Set-DhcpServerv4OptionValue -ScopeId 10.0.10.0 -OptionId 6 -Value 10.0.10.10
  ```

* 

