# <u>A Shakespearian Tragedy </u>

* **Event:** Hack Havoc CTF by CyberMaterial
* **Problem Type:** Web
* **Point Value / Difficulty:** 40
## Description
“Now let it work. Mischief, thou art afoot. Take thou what course thou wilt” -Mark Antony

http://challenge.ctf.cybermaterial.com/challenge1/

## Solution
This challenge wasn't really hard but then again, felt a bit guessing. In the Website, it was written so the first thing I tried was directory busting.

Tried to use the `dirb` tool but the connection was getting broken all the time. So I wrote a custom python script with the `common.txt` which `dirb` uses to to do directory busting. 
```python
#!/usr/bin/env python3
import requests
# the url we are going to post to 
url='http://challenge.ctf.cybermaterial.com/challenge1/'

with open("common.txt",'rb') as f:
    a=f.read().split(b"\n")
    # print(a)
    for i in a:
        # print(i)
        try:
            response_get = requests.get(url+i.decode())
            if response_get.status_code == 200:
                print(i.decode())
                print(response_get.text)
        except:
            pass
```

From this I found out directories such as `/images, /files, /style`. These directories didn't really contain anything useful. Found some more `/admin, /directories`. These led to something called `Wrong door`. Thought that this might be the way. Stuck on it for a long time.

Read a few writeups online after some guessing games found the directory `/users`
```html

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Julius Caesar</title>
</head>

<body class="dark dark:bg-gray-900 grid h-screen place-items-center">
    <section>
        <div class="grid max-w-screen-xl px-4 py-8 mx-auto lg:gap-8 xl:gap-0 lg:py-16 lg:grid-cols-12">
            <div class="mr-auto place-self-center lg:col-span-7">
                <h1
                    class="max-w-2xl mb-4 text-4xl font-extrabold tracking-tight leading-none md:text-5xl xl:text-6xl dark:text-white">
                    Wrong Door
                </h1>
                            </div>
            <div class="hidden lg:mt-0 lg:col-span-5 lg:flex ">
                            </div>
			    <div hidden> h67GnLsMv4MWc84cYr2Ar6VZ7VrEc1VoGMFp3N</div>
	</div>
    </section>
</body>

</html>
```

This had the encrypted flag.
On putting that in cipher identifier(https://www.dcode.fr/cipher-identifier), got to know its `base58`

On decrypting we get `C3Mr{3id_}c4me_i_s4w_i_c0nqu`
On rearranging a bit we get the flag.

Flag:- `CM{i_c4me_i_s4w_i_c0nqu3r3d}`