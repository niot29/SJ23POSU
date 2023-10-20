# SJ23POSU
SJ23POSU Introduktion till JAVA

BUGG:
- söka bookning som inte finns på bokning nr
+ söka bookning på datum som inte finns
- skal inte kunna lägga till kund som inte finn. fin spars ändå inte
- när man skall ta bort rum så skall det även ta bort bokningen iboknings tabellen.

 # SJ23POSU
SJ23POSU Introduktion till JAVA

Bokning system som tillhado håller kundbokning. 
**System funktioner:**

- BOOKING   -  *Hantera bokningar (lägga till, tabort - bookingar, sökning av boknings information)*

- MANAGER ROOM - *Hantera rum (lista på lediga rum, lägga till loch uppdatera rum, samt tar rum ur drift)*

- MANAGER CUTOMER - *Hanter kund information (lägga till kund och dess kontat info, samt tarbort info)*

**Söka booking och detalj information**
Under huvud "BOOKING" så finns det möjlighet att så efter lediga rum mellan booking datum. 
system presenterar de tillgänliga rum som går att boka under den agivna tids perioden.

Söka delja information om bokning, kan även göra under huvud "BOOKING". Ange booknings nr. då resenteras dokning, rum information dvs vilken rum  och typ som är relaterad till bokningen samt kund information.
![bdbb564cebae1b73db9d363f7d6c6b8a.png](:/c856fb3ef56942bdb9a721b596e5c467)


System använder java "HasMap" som inmemory databas lagring. 
Och persisten lagring så lagras informationen i txt-filer. Det finns 3st filer som relaterad till databas infromation
- *cutomer.txt*   (kund information)
- *booking.txt* (boknings information)
- *room.txt* (rum information)

Informationen i txt laddas in vid uppstart av programet. (Om filen inte finns så informerar systemen. Programet funkar som vanligt, vid updatering av inmemory database "HasMap" så kommer filen att automatisk skapas och lagra data).

Applikationen har metoder som presenterar informationen i tabeller med ASCII grafik.
metoder: *screeenXXXX*.



BUGG:
- söka bookning som inte finns på bokning nr
- söka bookning på datum som inte finns
- skal inte kunna lägga till kund som inte finn. fin spars ändå inte
