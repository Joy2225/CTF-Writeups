# <u>Catch me !!!</u>

* **Event:** Hack Havoc CTF by Cyber 
* **Problem Type:** OSINT
* **Point Value / Difficulty:** 50
## Description
We’ve got a hot case for you! A beggar on the street is actually a member of Al Capone's mob, and the FBI needs your help to track him down—fast.

We've intercepted a suspicious phone number that seems to be connected to this individual—702.724.86XX. However, two digits are missing. se this along with the provided image and other clues to identify his exact location.

Report back the name of the building infront of which he is sitting flag format CM{abc_abc_abcdefg}
## Solution

A simple google search on the 1st 3 digits of the phone number revealed that the number belongs to `U.S. state of Nevada`. Next in the image, to the left side the street name can be read by an educated guess. It comes down to `Stewart Ave`. Now looking around that place on maps, there was `mob museum`. Opened street view and verified the place.

Flag:- `CM{the_mob_museum}`
