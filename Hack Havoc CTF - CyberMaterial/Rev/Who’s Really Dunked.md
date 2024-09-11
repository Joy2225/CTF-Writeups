# <u>Who’s Really Dunked?</u>

* **Event:** Hack Havoc CTF by Cyber 
* **Problem Type:** Rev
* **Point Value / Difficulty:** 40
## Description
Cosmicgurl::92 says, "R47RoO7::47 is drunk!" 🍻 R47RoO7::47 responds, "JavaScript::00 is drunk!" 🤪 And then, out of nowhere, JavaScript stumbles in and says, "Yep, I'm actually drunk!" 🍹

So, let’s do a reverse cosmic dance to figure out who’s really had one too many. Spoiler alert: it looks like JavaScript is the real party animal! 🚀🥳
## Solution
I just simply put the encrypted text to cipher identifier which told that, it was `base92` as  indicated by `Cosmicgurl`. 
Output after base92 decryption:-
```
4@?DE 4CJAE@ l C6BF:C6WV4CJAE@VXj
4@?DE C625=:?6 l C6BF:C6WVC625=:?6VXj

^^ rC62E6 2? :?E6C7246 E@ C625 :?AFE 7C@> E96 FD6C
4@?DE C= l C625=:?6]4C62E6x?E6C7246WL
   :?AFEi AC@46DD]DE5:?[
   @FEAFEi AC@46DD]DE5@FE
NXj

^^ x?:E:2= 7=28 AC67:I
=6E 7=28!C67:I l Qr|LQj

^^ uF?4E:@? E@ 4964< FD6C :?AFED 2?5 G2=:52E6 E96 7=28
7F?4E:@? 4964<WX L
   C=]BF6DE:@?WVt?E6C 7:CDE G2=F6i V[ WG2=F6~?6X lm L
       C=]BF6DE:@?WVt?E6C D64@?5 G2=F6i V[ WG2=F6%H@X lm L
           C=]BF6DE:@?WVt?E6C E9:C5 G2=F6i V[ WG2=F6%9C66X lm L
               C=]4=@D6WXj

               ^^ x?:E:2=:K6 7=28 H:E9 E96 AC67:I
               =6E 7=28 l 7=28!C67:Ij

               ^^ pAA6?5 A2CED E@ E96 7=28 32D65 @? :?AFE G2=F6D
               :7 WG2=F6~?6 lll Q}6HDQX L
                   7=28 Zl Q}6HD0Qj
               N

               :7 WG2=F6%H@ lll Qp=6CEDQX L
                   7=28 Zl Qp=6CED0Qj
               N

               :7 WG2=F6%9C66 lll Qx?4:56?EQX L
                   7=28 Zl Qx?4:56?EQj
               N

               7=28 Zl QNQj

               ^^ r964< :7 E96 4@>AFE65 92D9 >2E496D E96 6IA64E65 92D9
               4@?DE 6IA64E65w2D9 l Qg_d5eddf_dbhfeb57a_52e23f5dheefe33b52c`2_e526fefdf`g7e4a3fdd2ag5Q
               :7 W92D9W7=28X lll 6IA64E65w2D9X L
                   4@?D@=6]=@8WQr@?8C2EF=2E:@?DP %96 7=28 :Di Q Z 7=28Xj
               N 6=D6 L
                   4@?D@=6]=@8WQx?4@CC64E 7=28] %CJ 282:?]QXj
               N
           NXj
       NXj
   NXj
N

^^ uF?4E:@? E@ 4@>AFE6 $wp\ade 92D9
7F?4E:@? 92D9W:?AFEX L
   C6EFC? 4CJAE@]4C62E6w2D9WVD92adeVX]FA52E6W:?AFEX]5:86DEWV96IVXj
N

^^ $E2CE E96 492==6?86
4964<WXj

```

Next from the description it was obvious that it is ROT-47. So again I put it in dcode and got the following js:-
```js
const crypto = require('crypto');
const readline = require('readline');

// Create an interface to read input from the user
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Initial flag prefix
let flagPrefix = "CM{";

// Function to check user inputs and validate the flag
function check() {
  rl.question('Enter first value: ', (valueOne) => {
      rl.question('Enter second value: ', (valueTwo) => {
          rl.question('Enter third value: ', (valueThree) => {
              rl.close();

              // Initialize flag with the prefix
              let flag = flagPrefix;

              // Append parts to the flag based on input values
              if (valueOne === "News") {
                  flag += "News_";
              }

              if (valueTwo === "Alerts") {
                  flag += "Alerts_";
              }

              if (valueThree === "Incident") {
                  flag += "Incident";
              }

              flag += "}";

              // Check if the computed hash matches the expected hash
              const expectedHash = "805d65570539763df20da6ab7d596676bb3da41a06dae7675718f6c2b755a28d"
              if (hash(flag) === expectedHash) {
                  console.log("Congratulations! The flag is: " + flag);
              } else {
                  console.log("Incorrect flag. Try again.");
              }
          });
      });
  });
}

// Function to compute SHA-256 hash
function hash(input) {
  return crypto.createHash('sha256').update(input).digest('hex');
}

// Start the challenge
check();
```

On analyzing this code the flag is pretty obvious .

Flag:- `CM{News_Alerts_Incident}`