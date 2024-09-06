# Rivest Salted Adleman
- **Event:** ShunyaCTF Aarambha
- **Problem Type:** Crypto
- **Difficulty** Medium

## Description
"Bob told me original q was eksored with some secret value 1 2 9 or 1 thru 9 something like that.... ughhh I am so confused...."


## Given 
The releveant data is below
```python
c = 332390996033761218977578960091058900061139210257883065481008023465866203213646838419152404854307189904898248026722555965488045307811040694129009535565921

p = 95224848836921243754124073456831190902097637702298493988505946669357481749059

salted_q = 62480590829144807189161429469255353976579455660965599518063804867866301233320

salted_n = 5949704816946842021797594696485093255706996345339732550774644373410311670577880550185915164563052783086742129032939489765553432924892778486382904377417840

e = 65537
```

Additionaly, in the description of the challenge, we are given the clue `Bob told me original q was eksored with some secret value 1 2 9 or 1 thru 9 something like that.... ughhh I am so confused....`. 

## Approach
Initially we thought that 
1. The original `q` was XORed with 129. 
2. The original `q` was XORed with a number between 1 and 9. We then computed a list of probable Qs and then tried decrypting using those values.
3. `q = 1^2^3^4^5^6^7^8^9` and then decrypting using that value.

All of these failed. Finally, we tried `Q = 123456789`, recomputed `N` (since upon trying the decryption with `salted_n`, we get a bunch of gibberish) and then did the RSA decryption, getting the flag `0CTF{4sa_1s_l0v3}`

```python
Q = salted_q ^ 123456789
N = p*Q

m = pow(c, inverse_mod(e, (p-1)*(Q-1)), N)
print(long_to_bytes(m))
```