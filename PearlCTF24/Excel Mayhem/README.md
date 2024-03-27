# Excel-Mayhem

**Event:** PearlCTF<br>
**Category:** Forenscics

## Solution
On opening the excel file we see many fake flags. We know that out flag is within these flags only. I try searching `pearl` but nothing is there.

I save the `excel` file as a `text` file. And then open it. Now you can find the flag using the `search and replace` properties of the text editor. Preferably replacing all the `fake_flag` with `nothing i.e.:-null` and then search `_` and we get the flag.

I wrote a python script as it looks the coders way of doing stuff.
```python
with open('excel.txt','r') as f:
    a=f.read().split("\t")
for i in a:
    if 'fake_flag' not in i:
        print(i)
```
We are just splitting the data which are separated by `tab` and then searching for the string which doesn't have the substring `fake_flag` in it and we get the flag on running this script.

Flag:- `h3ll_0f_4n_3xc3l`<br>
Wrap this within `pearl{}`<br>
Final flag:- `pearl{h3ll_0f_4n_3xc3l}`