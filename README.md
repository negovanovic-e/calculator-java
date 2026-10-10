Analiza koda

1. LOC metrika
LOC je izračunat zbrajanjem vrijednosti koje GitHub prikazuje za Java datoteke u repozitoriju.

| Datoteka | LOC |
|---|---:|
| Calculator.java - 136 |
| Start.java - 19 |
| Ukupno - 155 |

Ukupno: 155 LOC.
Napomena: korišten je GitHubov prikaz LOC-a, a datoteka LICENSE nije uključena jer ne sadrži izvorni Java kod.

2. Neformalni pregled koda i statička analiza

- Calculator.java, linije 18–20 i 24–26 - Nazivi metoda ToString() i Run() ne prate uobičajenu Java konvenciju imenovanja metoda, prema kojoj se koristi malo početno slovo i camelCase, primjerice toString() i run(). Preporučuje se korištenje dosljednih naziva koji opisuju svrhu metoda.
- Calculator.java,linije 32–33 – Prije poziva expression.charAt(0) ne provjerava se je li izraz prazan ili null. Prazan izraz može izazvati StringIndexOutOfBoundsException, a vrijednost null može izazvati NullPointerException.
- Calculator.java,linija 41 – Petlja za prikupljanje operatora završava prije posljednjeg znaka izraza. Zbog toga se završni operator, primjerice u izrazu 1+, može preskočiti. Takav neispravan izraz može biti pogrešno obrađen umjesto da bude odbijen.
- Calculator.java, linije 37 i 61–63 – Razdvajanje izraza prema operatorima ne obrađuje pravilno negativne brojeve unutar izraza, primjerice 5*-2. Takav izraz može sadržavati prazan element koji se ne može pretvoriti u broj, pa kalkulator vraća ERROR. Preporučuje se jasnije definirati i provjeravati dopuštenu sintaksu izraza.
- Calculator.java, linija 62 – Hvata se općenita iznimka Exception, iako se u ovom dijelu koda obrađuje pretvaranje teksta u broj. Preporučuje se uhvatiti specifičniju iznimku NumberFormatException, kako bi obrada pogrešaka bila preciznija.
- Calculator.java, linije 94, 104, 116, 127, 143, 153, 167 i 178 – Metoda Calculate() poziva samu sebe rekurzivno prilikom obrade operatora. Kod izraza s vrlo velikim brojem operacija to može uzrokovati prevelik broj rekurzivnih poziva i potencijalno prekoračenje stoga. Iterativno rješenje moglo bi biti robusnije.
- Start.java, linija 6 – Lokalna varijabla Expression počinje velikim slovom, što nije uobičajena Java konvencija za lokalne varijable. Preporučuje se naziv expression.
- Start.java,linije 12–13 – Novi objekt Scanner stvara se u svakoj iteraciji petlje. Preporučuje se stvoriti jedan Scanner prije petlje i ponovno ga koristiti, kako bi se izbjegli nepotrebno stvaranje objekata i mogući problemi s međuspremanjem ulaza.
- Start.java,linija 13 – Poziv nextLine() pretpostavlja da je sljedeća linija ulaza dostupna. Ako se ulaz završi prije nego što korisnik upiše exit, može se pojaviti NoSuchElementException. Preporučuje se provjeriti postoji li još ulaza prije čitanja.

3. Zaključak
Pregledom koda uočeni su nedostaci u provjeri ulaznih podataka, obradi neispravnih matematičkih izraza, imenovanju metoda i varijabli te upravljanju ulaznim tokom. Dodatno, rekurzivni pristup izračunavanju može predstavljati problem za izrazito duge izraze. Ova analiza provedena je statičkim pregledom izvornog koda. Navedena zapažanja predstavljaju preporuke za poboljšanje robusnosti, čitljivosti i održavanja programa.
