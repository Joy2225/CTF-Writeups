# Echoes Of Encryption

- **Event:** ShunyaCTF Aarambha
- **Problem Type:** Crypto
- **Difficulty** Medium

## Description
In December 2022, my friend Alok's device was hacked. Upon investigation, he discovered that the breach was due to a vulnerability in the Nvidia SMC which had been recently discovered and published for research purposes on the same day he was hacked.

PS- In the end, only numbers matter to grow a plant from a seed!!


## Analysis of the given data
We see that the python RNG is being seeded with some random value, the characters in the flag are all of the ascii letters and digits. 
```python
def encrypt_string(input_string, seed):
    random.seed(seed)
    
    allowed_chars = string.ascii_letters + string.digits
```
The key is a string of characters of length same as the input string in some psuedo-random order. This is important as if we find the value used to seed the `random` RNG, then we can recover the key.
The encrypted `input_string` is generated by XORing the `input_string` with the key and the its hex representation is returned.
```python
 for i in range(len(input_string)):
        encrypted_char = chr(ord(input_string[i]) ^ ord(key[i]))
        encrypted_string += encrypted_char
```

The desciption highlights that a vulnerability report was published on the Nvidia SMC on **December 2022** on the **same day he was hacked**.
## Approach
```python
import time 
import string
import random 
import datetime


def decrypt(flag:str):
    random.seed(202242269)
    flag = bytes.fromhex(flag).decode()
    allowed_chars = string.ascii_letters + string.digits
    key = ''.join(random.choices(allowed_chars, k=len(flag)))
    decrypted_string = ''
    for i in range(len(flag)):
        decrypted_char = chr(ord(flag[i]) ^ ord(key[i]))
        decrypted_string += decrypted_char
    return decrypted_string

print(
    decrypt(
        "5e04610a22042638723c571e1a5436142764061f39176b4414204636251072220a35583a60234d2d28082b"
    )
)
```
It is pretty clear that our only option to find the flag, is to find the seed value. A few suggestions for bruteforcing the seed were quickly shot down. A quick Google search leads us to the CVE-report [CVE-2022-42269](https://nvd.nist.gov/vuln/detail/CVE-2022-42269), which has the publishing date `12/30/2022`. So we try `12302022`, which gives gibberish. We then try `20223012` which again results in failure. Then we  loop over `permutations('12302022')` and try all the permutations, which again results in more uslessness. We are at this point, frustrated to the point of pulling our hair out(not that we have any, which hair do we mean hehe). Then one of my team members suggests to use the CVE number as the seed. This results in a momentous unveiling of the long awatied flag `0CTF{alw4y5_r3ad_7he_d3scr!pti0n_c4r3fully}`. 