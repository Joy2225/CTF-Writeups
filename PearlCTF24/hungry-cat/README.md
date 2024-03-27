# Hungry-cat

**Event:** PearlCTF<br>
**Category:** Forenscics

**Description**<br>
Your friend's system crashed just as he was about to access crucial instructions on what to feed his cat on internet. He's now turned to you for help in retrieving this information from the system dump. Can you assist him in piecing together the lost instructions for feeding his feline friend?

**Solution**<br>
At first I did `strings` on the given file an stored the output in a `txt` file.
```
strings dump_1.raw > out.txt
```

Now at first I tried to `grep` the word `pearl` inside the txt file and luckily I got the flag.

```
cat out.txt | grep pearl
```

Flag:- `pearl{y0ur_f3lin3_fr1end_wont_g0_hungry}`

