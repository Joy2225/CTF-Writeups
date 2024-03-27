# Baby-Rev

First decompile the file using ghidra.

On analyzing the `main` function we see that the program is taking an user input passing the value to a function `myfunc`

```c
  printf("Enter a string: ");
  fgets(local_38,0x20,stdin);
  sVar1 = strlen(local_38);
  if (sVar1 == 0x18) {
    myfunc(local_38);
  }
  else {
    puts(":P\n");
  }
```

Now on analyzing the `myfunc` function we see that it's just checking each index of the string with a particular character. Just write the characters and we will have our flag.

```c
  if (*param_1 == 'B') {
    if (((((((param_1[4] == 'C') && (param_1[0xd] == 'm')) && (param_1[0x13] == 'r')) &&
          (((param_1[3] == 'S' && (param_1[10] == 'l')) &&
           ((param_1[2] == 'T' && ((param_1[0xe] == 'e' && (param_1[0x11] == '0')))))))) &&
         ((param_1[0x16] == '}' &&
          (((param_1[7] == '{' && (param_1[5] == 'T')) && (param_1[0xf] == '_')))))) &&
        (((param_1[1] == 'I' && (param_1[0x15] == 'v')) &&
         (((param_1[8] == 'w' && ((param_1[0xb] == 'c' && (param_1[6] == 'F')))) &&
          (param_1[0x14] == '3')))))) &&
       ((((param_1[9] == '3' && (param_1[0xc] == '0')) && (param_1[0x10] == 't')) &&
        (param_1[0x12] == '_')))) {
      puts("Yippee :3\n");
    }
  }
  else {
    puts(":PP\n");
  }
```

Flag:- `BITSCTF{w3lc0me_t0_r3v}`