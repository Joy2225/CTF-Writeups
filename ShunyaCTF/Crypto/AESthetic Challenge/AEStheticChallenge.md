# AESthetic Challenging

- **Event:** ShunyaCTF Aarambha
- **Problem Type:** Crypto
- **Difficulty** Medium

## Description
"I have got these two creepy audio files. I guess they have something to tell us. What could be the message?"

## Analysis Cum Approach
The challenge name and the given files `aud1_IV.wav` and `aud2_k.wav` suggest that the ciphertext is encrypted via AES. We open the audio files and presented to a glorious auditory expanse of beeps and boops. We get to know that the audio files are actually containing morse code. We feed the files into [Morse Code World](https://morsecode.world/international/decoder/audio-decoder-adaptive.html) and get the decoded morse code and thus the key : `YOUGOTTHEKEYNJOY`  and the IV: `000102030405060708090A0B0C0D0E0F`. We then make a script to decrypt the ciphertext using AES-CBC.
```python
from Crypto.Cipher import AES

key = "YOUGOTTHEKEYNJOY".lower().encode()
IV = bytes.fromhex("000102030405060708090A0B0C0D0E0F")
cipher = AES.new(key, AES.MODE_CBC, IV=IV)
ciphertext = bytes.fromhex("69d5deb91a001151db5d98231574a51779acd1a84b9338a6750697c0af7e4591")
print(cipher.decrypt(ciphertext))
```
We had to add the lower as without `lower` we get a bunch of gibberish. After running the script, we get the flag `0CTF{d4sh_und3rsc0r3_d0t!}` 