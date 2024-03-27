# Loot Stash
**Event:** HTB Cyber Apocalypse<br>
**Category:** Reverse Engineering<br>
**Difficulty:** Very easy

### Solution
On running the binary a few times we get a random string everytime. For example:
```
Diving into the stash - let's see what we can find.
.....
You got: 'Doomward, Glaive of Shadows'. Now run, before anyone tries to steal it!
```
Decompile the given file and we see that every time a random string is printed from `gear` array.

```c
int __fastcall main(int argc, const char **argv, const char **envp)
{
  unsigned int v3; // eax
  int v4; // eax
  int i; // [rsp+Ch] [rbp-4h]

  setvbuf(_bss_start, 0LL, 2, 0LL);
  v3 = time(0LL);
  srand(v3);
  puts("Diving into the stash - let's see what we can find.");
  for ( i = 0; i <= 4; ++i )
  {
    putchar(46);
    sleep(1u);
  }
  v4 = rand();
  printf("\nYou got: '%s'. Now run, before anyone tries to steal it!\n", (&gear)[(v4 % 0x7F8uLL) >> 3]);
  return 0;
}
```
We double on gear and see many strings. Search `HTB` in `IDA` or simple write the command: ```strings stash | grep HTB``` in terminal.

We get the flag: `HTB{n33dl3_1n_a_l00t_stack}`
