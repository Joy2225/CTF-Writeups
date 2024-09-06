# Can You Break The Key

- **Event:** ShunyaCTF Aarambha
- **Problem Type:** Crypto
- **Difficulty** Hard

## Description
In the Cryptic Realm of hexadecimal whispers, where the key to unlocking secrets is entwined within the digital range, we embark on the journey guided by the silent vigil of numbers to unveil the hidden cipher.

## Analysis cum Approach
```python
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

key = b''

cipher = AES.new(key, AES.MODE_ECB)
message = b""
padded_message = message.ljust((len(message) + 15) // 16 * 16, b'\0')
ciphertext = cipher.encrypt(padded_message)

with open("ciphertext.bin", "wb") as f:
    f.write(ciphertext)
```
From the give source file, we see the flag is encrypted using AES in ECB mode. 
The message is padded with null bytes to make it a multiple of 16 bytes.
Again, it seems that we have to guess the key. From the description, we think that the key is a the range of all hex digits. We tried to first create the key via list comprehension and then joining the list. But we screwed up that part. We wasted more time in trying to do  this jazz until one of us just hardcoded the hex digits out of great and extreme frustration. We had all of us already pulled out our hair in the previous challenges and so we had no hair **at all**. After doing this, we get the flag `0CTF{n0t_alw4y5_d0ne_8y_bru7ef0rce}`. The decrypting script is as follows.

```python 
from Crypto.Cipher import AES
import binascii

key = b'0123456789ABCDEF'
cipher = AES.new(key, AES.MODE_ECB)

with open("./ciphertext.bin", "rb") as f:
    ciphertext = f.read()
    plain = cipher.decrypt(ciphertext)
    print(plain)
```