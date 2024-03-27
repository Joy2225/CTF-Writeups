# Solution
On running the binary we are prompted to enter a password. Entering something random tells that `The window slams shut...`

## Analysing the c code
```c
undefined8 main(void)

{
  char local_38 [43];
  char local_d;
  uint local_c;
  
  puts("A voice comes from the window... \'Password?\'");
  fgets(local_38,0x2a,stdin);
  local_c = 0;
  while( true ) {
    if (0x24 < local_c) {
      puts("The window opens to allow you passage...");
      return 0;
    }
    local_d = local_38[(int)(local_c + 1)] + local_38[(int)local_c];
    if (local_d != arr[(int)local_c]) break;
    local_c = local_c + 1;
  }
  puts("The window slams shut...");
  return 0xffffffff;
}
```
By analysing this code, we understand that the every 2 adjacent characters ASCII value is being added and checked with the value in `arr`.

In the decompiler(I used ghidra) we can get the values present in array.
```c
arr={ 0x9c, 0x96, 0xbd, 0xaf, 0x93, 0xc3, 0x94, 0x60, 0xa2, 0xd1, 0xc2, 0xcf, 0x9c, 0xa3, 0xa6, 0x68, 0x94, 0xc1, 0xd7, 0xac, 0x96, 0x93, 0x93, 0xd6, 0xa8, 0x9f, 0xd2, 0x94, 0xa7, 0xd6, 0x8f, 0xa0, 0xa3, 0xa1, 0xa3, 0x56, 0x9e }
```
I have solved this in 2 ways :
- Simple java script
- Using Z3

## <u>The Java method</u>
Here is the java code I wrote:-
```java
class solve{
	public static void main(String args[]){
	int a[]={0x9c, 0x96, 0xbd, 0xaf, 0x93, 0xc3, 0x94, 0x60, 0xa2, 0xd1, 0xc2, 0xcf, 0x9c, 0xa3, 0xa6, 0x68, 0x94, 0xc1, 0xd7, 0xac, 0x96, 0x93, 0x93, 0xd6, 0xa8, 0x9f, 0xd2, 0x94, 0xa7, 0xd6, 0x8f, 0xa0, 0xa3, 0xa1, 0xa3, 0x56, 0x9e};
	int b[]=new int[38];
	b[37]=125; // 125 is the ASCII for '}'
	String w="";
	for(int i=36;i>=0;i--){
		b[i]=a[i]-b[i+1]; // current value - the value in the next index
		w=(char)b[i]+w;
	}	
	w=w + '}';	
	System.out.println(w);	
	}
}
```
Running this code will give the flag i.e.:- the password.
It basically subtracts from the last and the flag format will have the last character as `}`. So, we can easily reverse the array to get the flag.

The loop follows the logic that `actual character = current character - the character in the next index` with the last character being constant i.e.: `}`

## <u>Z3 method</u>

We first prepare our z3 solver and input
```python
from z3 import *
a=[0x9c, 0x96, 0xbd, 0xaf, 0x93, 0xc3, 0x94, 0x60, 0xa2, 0xd1, 0xc2, 0xcf, 0x9c, 0xa3, 0xa6, 0x68, 0x94, 0xc1, 0xd7, 0xac, 0x96, 0x93, 0x93, 0xd6, 0xa8, 0x9f, 0xd2, 0x94, 0xa7, 0xd6, 0x8f, 0xa0, 0xa3, 0xa1, 0xa3, 0x56, 0x9e]

b=[BitVec(f"p_{i:02}",8)for i in range(0,38)] # Create symbolic input 8-bit values to represent the password
s=Solver()
```

We now just need to implement the logic, and constrain our solver using it.
```python
for i in range(0,37):
    s.add(b[i]+b[i+1]==a[i])  # The main logic
    s.add(b[i]>=32)      # Constraining the flag in printable ASCII characters 
    s.add(b[i+1]>=32)
    s.add(b[i]<=126)
    s.add(b[i+1]<=126)

s.add(b[37]==ord('}')) # Since we know that the last character will be '}'
```

Now, we check if the constraints can be satisfied, and print our flag.
```python
s.check()
m=s.model()
flag = [m.eval(i).as_long() for i in b]
print(bytes(flag).decode())
```

Running the python script will give us the flag.
Flag:- `HTB{4_d00r_cl0s35_bu7_4_w1nd0w_0p3n5!}`
