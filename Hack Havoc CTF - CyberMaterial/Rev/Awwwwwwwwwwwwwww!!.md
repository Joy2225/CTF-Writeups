# <u>Awwwwwwwwwwwwwww!!</u>

* **Event:** Hack Havoc CTF by Cyber 
* **Problem Type:** Rev
* **Point Value / Difficulty:** 80
## Description
So Much Awwww & Awaaaaaaaaaaa by  
[Jelly Hoshiumi](https://x.com/jellyhoshiumi)

Flag: Enclosed string with CM{....}
## Solution

This exact same challenge came in `vsCTF24`. I solved it that time in that ctf. I went to the folder to find my script but it was not there. Ig I did that in IDLE. So I simply went to the github repo where the writeup was already there because why not? Use the resources at hand.
Writeup Link:- https://github.com/D13David/ctf-writeups/blob/main/vsctf24/rev/README.md

I simply took the code, and changed the file name and value as necessary. The file was exactly the same as the vsCTF one. I just blindly ran it, but later realized the output was different. So changed it and ran the script and got the flag.

```python
COMMAND_BITS = 5

def parseBlock(block):
    result = ""
    while len(block) != 0:
        if block.startswith("awa"):
            result += "0"
            block = block[3:]
        elif block.startswith("wa"):
            result += "1"
            block = block[2:]
    return result

def awaize(bits, size):
    tmp = []
    while bits != 0:
        tmp.append(" awa" if bits & 1 == 0 else "wa")
        bits >>= 1

    for i in range(len(tmp), size):
        tmp.append(" awa")

    return "".join(tmp[::-1]).strip()

def parseBits(index, data, length):
    return (index+length, int(data[index:index+length],2))

commands = {
                0x00: ("nop", 0),
                0x01: ("prn", 0),
                0x02: ("pr1", 0),
                0x03: ("red", 0),
                0x04: ("r3d", 0),
                0x05: ("blo", 8),
                0x06: ("sbm", 5),
                0x07: ("pop", 0),
                0x08: ("dpl", 0),
                0x09: ("srn", 5),
                0x0A: ("mrg", 0),
                0x0B: ("4dd", 0),
                0x0C: ("sub", 0),
                0x0D: ("mul", 0),
                0x0E: ("div", 0),
                0x0F: ("cnt", 0),
                0x10: ("lbl", 5),
                0x11: ("jmp", 5),
                0x12: ("eql", 0),
                0x13: ("lss", 0),
                0x14: ("gr8", 0),
                0x1F: ("trm", 0),
           }

def handleCommand(index, data, cmd, awaized):
    try:
        cmd_info = commands[cmd]
        if cmd_info[1] != 0:
            index, param = parseBits(index, data, cmd_info[1])
            disasm = f"{cmd_info[0]} {param}"
        else:
            disasm = cmd_info[0]

        if awaized:
            param = f" | {awaize(param, cmd_info[1])}" if cmd_info[1] != 0 else ""
            print(f"{(awaize(cmd, COMMAND_BITS)+param).ljust(42)} {disasm}")
        else:
            print(disasm)
    except:
        print(f"unknown command {cmd}")

    return index

if __name__ == "__main__":
    data = open("awwwww.txt", "r").read().split(" ")

    bits = ""
    for block in data[1:]:
        bits += parseBlock(block)

    index = 0
    while index < len(bits):
        index, cmd = parseBits(index, bits, COMMAND_BITS)
        index = handleCommand(index, bits, cmd, True)
```

Output:- 
```
awa awa awawawa                            red
awa awawawawa                              pop
awa awawawa awa | awa awa awawa awa        sbm 2
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awa awawa awa awa        sbm 4
awa awawawa awa | awa awa awa awawa        sbm 1
awa awawawa awa | awa awawawa awa          sbm 6
awa awawawa awa | awa awawa awawa          sbm 5
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awawa awawa awa          sbm 10
awa awawawa awa | wa awawa awa awa         sbm 20
awa awawawa awa | wa awawawa awa           sbm 22
awa awawawa awa | wawa awa awawa           sbm 25
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awa awa awa awa awa      sbm 0
awa awawawa awa | awa awa awa awa awa      sbm 0
awa awawawa awa | awa awa awawa awa        sbm 2
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awa awawa awa awa        sbm 4
awa awawawa awa | awa awa awa awawa        sbm 1
awa awawawa awa | awa awawawa awa          sbm 6
awa awawawa awa | awa awawa awawa          sbm 5
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awawa awawa awa          sbm 10
awa awawawa awa | wa awawa awa awa         sbm 20
awa awawawa awa | wa awawawa awa           sbm 22
awa awawawa awa | wawa awa awawa           sbm 25
awa awawawa awa | awa awa awawawa          sbm 3
awa awawawa awa | awa awa awa awa awa      sbm 0
awa awawawa awa | awa awa awa awa awa      sbm 0
awa awawawa awa | awa awa awa awa awa      sbm 0
awa awawawa awa | wa awa awa awa awa       sbm 16
awa awawawa awa | wawa awawa awa           sbm 26
awa awawawa awa | wawawawawa               sbm 31
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
awa awa awa awawa                          prn
```

Next had to write change the output as the given image.

```python
data = list("owoosHiai1w1aia_awJ3ally!0awwa_o")
subm = [2, 3, 4, 1, 6, 5, 3, 10, 20, 22, 25, 3, 0, 0, 2, 3, 4, 1, 6, 5, 3, 10, 20, 22, 25, 3, 0, 0, 0, 16, 26, 31]

for i in subm[::-1]:
    if i != 0:
        data = [data[i]] + data[0:i] + data[i+1:]
    else:
        data.insert(0, data[-1])
        data = data[:-1]

print("".join(data))
```

Output:- `awawawawaawa_0oooosHii11i_J3lly!`

Flag:- `CM{awawawawaawa_0oooosHii11i_J3lly!}`
