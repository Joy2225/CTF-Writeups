# <u>Dear Trithemius,</u>

* **Event:** Hack Havoc CTF by Cyber 
* **Problem Type:** Crypto
* **Point Value / Difficulty:** 60
## Description
The encryption method used in this cipher is a variation of the Caesar cipher, but with a twist. Each letter in the plaintext is shifted by a different amount depending on its position in the string. Non-alphabetic characters remain unchanged. To decrypt, reverse this shifting process.

Flag: Enclosed string with CM{....}
## Solution
We have a `go` program which is pretty easy to reverse.
It mainly deals with the `Uppercase letters` and keeps the `non alphabet` the same.
The solve script is pretty straightforward
```python
def to_h(owo):
    return ord(owo) - 0x41

def from_l(uwu):
    return chr(uwu % 26 + 0x41)

def decrypt(e):
    original_message = ''
    for i in range(len(e)):
        letters = e[i]
        if not letters.isalpha():
            owo = letters
        else:
            uwu = to_h(letters)
            owo = from_l(uwu - i)
        original_message += owo
    return original_message

c="LPXH_Z_AZRDSQZWJI"
d = decrypt(c)
print(d)
```
Output:- `LOVE_U_TRITHEMIUS`

Flag:- `CM{LOVE_U_TRITHEMIUS}`