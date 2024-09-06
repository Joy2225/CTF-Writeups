# <u>Drunken Website</u>

* **Event:** Hack Havoc CTF by CyberMaterial
* **Problem Type:** Web
* **Point Value / Difficulty:** 30
## Description
A coder, tipsy and on a deadline, unleashed a website that's a chaotic mess of broken links and jumbled code in so many language imaginable. The site’s live, and the flag is hidden in the mayhem. Your challenge? Navigate this digital disaster, debug the chaos, and find the elusive flag.

[http://challenge.ctf.cybermaterial.com/dissssissssimpul/](http://challenge.ctf.cybermaterial.com/dissssissssimpul/)
## Solution
On going to the website we see stiff written in various languages as said that the website was drunk.

I checked the source code to find another href `http://challenge.ctf.cybermaterial.com/dissssissssimpul/homepage.html#`. 

Also there were fake flags on both of the previous pages.

Here also it was kindoff similar. Again checking the source code I saw an invisible button code, which takes to the link `http://challenge.ctf.cybermaterial.com/dissssissssimpul/0.html`.


On checking its source code, we find the flag.
```html

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hidden Message</title>
    <style>
        body {
            background-color: white; /* Set background color to white */
            margin: 0;
            padding: 0;
        }
        .hidden-text {
            position: absolute; /* Remove from the normal document flow */
            width: 1px; /* Minimize the width */
            height: 1px; /* Minimize the height */
            margin: -1px; /* Move out of view */
            padding: 0; /* Remove padding */
            overflow: hidden; /* Hide any overflow */
            clip: rect(0, 0, 0, 0); /* Clip the text */
            border: 0; /* Remove any border */
        }
    </style>
</head>
<body>
    <p class="hidden-text">
        Well, I guess I'll be fired in the morning for making such an amazing website. 
        But you can get this flag.
        CM{W3bs1t3_15_5hi7}
    </p>
</body>
</html>
```

Flag:- `CM{W3bs1t3_15_5hi7}`
