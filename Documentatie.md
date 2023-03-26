## 

## PROIECT LA DISCIPLINA PROGRAMARE ORIENTATĂ PE OBIECTE

TEMA: Aplicatie pentru rezervarea unei mese la un restaurant.

| Titular disciplină: Șef lucr. dr. ing. Ioniță Irina |                                         |
|-----------------------------------------------------|-----------------------------------------|
|                                                     | Studenți: Neagu Adrian Rusanda Valentin |

PLOIEŞTI

2022

# CUPRINS

[FORMULAREA PROBLEMEI](#_Toc104996343)

[Etapele dezvoltării aplicației software (abordare UML)](#_Toc104996344)

[Analiza](#_Toc104996345)

[Proiectarea](#_Toc104996346)

[Implementarea](#_Toc104996347)

[Testarea](#_Toc104996348)

[CONCLUZII](#_Toc104996349)

[BIBLIOGRAFIE](#_Toc104996350)

## FORMULAREA PROBLEMEI

Aplicație pentru rezervarea unei mese la un restaurant (în funcție de cerințele clientului, se va oferi o listă cu opțiuni și apoi se va face rezervarea efectiv, cu confirmare).

# Etapele dezvoltării aplicației software (abordare UML)

## Analiza

Etapa de analiza incepe cu utilizarea aplicatiilor de rezervat deja existente a diferitor restaurante. Dupa analizarea modelului logic, am dedus abstractizarea principiului de functionare.

Abordarea de rezolvare a problemei se face intr-un mod direct analizand si abstractizand etapele de functionare a programului dupa cum urmeaza:

![](media/bdf08e6f3b864d45d6a6cbd225ae82a5.png)

Cazurile de utilizare sunt simple si concrete, avand in vedere actiunile a trei actori principali:

![](media/c938319168d47aaab609aaca6d117378.png)

## Proiectarea

In vederea proiectarii, avem doua tipuri de actori:

1.  Actorii externi: *clientul, operatorul.*
2.  Actorul intern: *programatorul*, care este cel care actualizeaza si intretine codul.

    Aplicatia consta in urmatoarele cazuri de utilizare:

3.  In cazul clientului, vom avea urmatoarea situatie:
    1.  Crearea unei rezervari
        1.  Precomanda
    2.  Afisarea rezervarilor sale
    3.  Anularea rezervarilor sale
    4.  Iesire din program
4.  In cazul operatorului, vom avea urmatoarea situatie:
    1.  Crearea unei rezervari
        1.  Precomanda
    2.  Afisarea tuturor rezervarilor
    3.  Anularea oricarei rezervari
    4.  Iesire din program

![](media/a19ebb9b1d7e71ad1af965f5ca3934d8.png)

Clasele pe care le vom folosi vor fi urmatoarele:

1.  Persoana – pentru datele personale ale clientului;
2.  Masa – pentru informatii despre fiecare masa;
3.  Rezervare – pentru informatii despre fiecare rezervare;
4.  Produs – pentru informatii despre fiecare produs;
5.  Meniu – pentru stocarea felurilor de mancare;
6.  PreComanda – pentru informatii despre precomanda clientului;
7.  Main – pentru gestionarea optiunilor si a programului principal.

![](media/38bef65470beed5d3864d941c409ae2c.png)

*Diagrama claselor*

## Implementarea

Clasa **Masa** are ca date membru numarul mesei, numarul de locuri, tipul mesei (interior, terasa), si un membru static folosit pentru a stoca numarul total de mese. Clasa contine un constructor implicit si unul cu parametrii, ambele initializand datele membru si incrementand membrul static nrMese. Metodele prezente sunt functii de tipul GET / SET si o functie ce afiseaza detalii despre masa.

public class Masa {

private int nrMasa;

private int locuri;

private String tipMasa;

private static int nrMese = 0;

public Masa(int locuri, String tipMasa) {

this.locuri = locuri;

this.tipMasa= tipMasa;

this.nrMasa = nrMese + 1;

nrMese++;

}

public Masa() {

this.locuri = 0;

this.tipMasa="";

this.nrMasa = nrMese + 1;

nrMese++;

}

public void afisare(){

System.out.println("Masa "+nrMasa+": "+this.locuri+" locuri, "+this.tipMasa);

}

// Plus functii GET / SET

}

Clasa **Persoana** stocheaza informatii despre persoana care rezerva, avand ca date membru numele, prenumele si numarul de telefon al persoanei. Constructorul implicit si constructorul cu parametrii sunt prezente in cod, impreuna cu functii de tipul GET / SET, o functie de afisare a datelor, si o functie care permite introducerea datelor de la tastatura.

public class Persoana {

private String nume, prenume, nrTelefon;

Scanner input=new Scanner(System.in);

public Persoana(String nume, String prenume, String nrTelefon) {

this.nume = nume;

this.prenume = prenume;

this.nrTelefon = nrTelefon;

}

public Persoana(){

this.nume="";

this.prenume="";

this.nrTelefon="";

}

public void introducere(){

System.out.println("Introduceti:\\nNume:");

this.nume=input.next();

System.out.println("Prenume:");

this.prenume=input.next();

System.out.println("Numarul de telefon:");

this.nrTelefon=input.next();

}

public void afisare(){

System.out.println("Nume si prenume: "+this.nume+" "+this.prenume+

"\\nNumar de telefon: "+this.nrTelefon);

}

// Functii GET / SET

}

Clasa **Produs** contine informatii despre produsul pe care clientul il poate precomanda.

public class Produs {

private String nume;

private String tip;

private float pret;

public Produs(){

this.nume = "";

this.tip = "";

this.pret = 0;

}

public Produs(String nume, String tip, float pret){

this.nume = nume;

this.tip = tip;

this.pret = pret;

}

public void afisare(){

System.out.println(nume + ", " + pret + " RON");

}

// Functii GET / SET

}

Clasa **Meniu** contine felurile de mancare in liste de tipul **ArrayList\<Produs\>**, care ne ajuta sa stocam dinamic obiectele. Acesta contine, de asemenea, o metoda care verifica existenta unui **Produs** in meniu, si o metoda care adauga produse in meniu, pe langa functia uzuala de afisare.

public class Meniu {

private ArrayList\<Produs\> felul1;

private ArrayList\<Produs\> felul2;

private ArrayList\<Produs\> desert;

private ArrayList\<Produs\> bauturi;

public Meniu(){

this.felul1 = new ArrayList\<\>();

this.felul2 = new ArrayList\<\>();

this.desert = new ArrayList\<\>();

this.bauturi = new ArrayList\<\>();

}

public Produs hasProdus(String nume){

nume = nume.toLowerCase();

for (Produs x : felul1){

if (x.getNume().toLowerCase().equals(nume)) return x;

}

for (Produs x : felul2){

if (x.getNume().toLowerCase().equals(nume)) return x;

}

for (Produs x : desert){

if (x.getNume().toLowerCase().equals(nume)) return x;

}

for (Produs x : bauturi){

if (x.getNume().toLowerCase().equals(nume)) return x;

}

return null;

}

public void addProdus(Produs x){

if (x.getTip().equals("Felul 1")) felul1.add(x);

if (x.getTip().equals("Felul 2")) felul2.add(x);

if (x.getTip().equals("Desert")) desert.add(x);

if (x.getTip().equals("Bautura")) bauturi.add(x);

}

public void afisare(){

System.out.println("-MENIU-");

System.out.println("\\nFelul 1:\\n");

for (Produs x : felul1){

x.afisare();

}

System.out.println("\\nFelul 2:\\n");

for (Produs x : felul2){

x.afisare();

}

System.out.println("\\nDesert:\\n");

for (Produs x : desert){

x.afisare();

}

System.out.println("\\nBauturi:\\n");

for (Produs x : bauturi){

x.afisare();

}

System.out.println();

}

}

Clasa **PreComanda** stocheaza produsele pe care clientul doreste sa le precomande si observatii pentru comanda.

public class PreComanda {

private ArrayList\<Produs\> produse;

private String observatii;

public PreComanda() {

this.produse = new ArrayList\<\>();

this.observatii = "";

}

public PreComanda(ArrayList\<Produs\> produse, String observatii) {

this.produse = produse;

this.observatii = observatii;

}

public void initializare(Meniu meniu){

Scanner in = new Scanner(System.in);

meniu.afisare();

System.out.println("Introduceti comanda dumneavoastra. Cand sunteti gata, tastati 0 pentru a trece la urmatorul pas.");

while (true){

String p = in.nextLine();

if (p.equals("0")) break;

Produs x = meniu.hasProdus(p);

if (x == null){

System.out.println("Produsul nu exista.");

continue;

}

produse.add(x);

System.out.println("Produsul a fost adaugat cu succes!");

}

System.out.println("Observatii comanda:");

this.observatii = in.nextLine();

}

public void afisare(){

System.out.println("Pre-comanda: ");

for (int i = 0; i \< produse.size(); i++){

System.out.print(produse.get(i).getNume());

if (i \< produse.size() - 1) System.out.print(", ");

else System.out.print(".");

}

System.out.println();

}

public String getObservatii() {

return observatii;

}

public void setObservatii(String observatii) {

this.observatii = observatii;

}

public boolean isNull(){

return produse.size() == 0;

}

}

Clasa **Rezervare** contine informatii despre rezervare, cum ar fi **Persoana** care rezerva, numarul de persoane, data si ora (obiecte de tipul **LocalDate** si **LocalTime**), **Masa** pe care o rezerva, si **PreComanda**, in cazul in care clientul o solicita. In plus, exista un membru static de tipul **ArrayList\<Rezervare\>** numit **rezervari**, in care se stocheaza fiecare rezervare imediat ce este create. Clasa cuprinde constructorul implicit si doua tipuri de constructori cu parametri: unul pentru toate datele membru si unul pentru toate datele membru cu exceptia precomenzii. Metodele uzuale de tipul GET / SET si afisare sunt prezente. Metoda **rezerva** permite initializarea rezervarii de la tastatura si afiseaza mesele valabile pe baza informatiilor introduce de client.

public class Rezervare {

private Persoana persoana;

private int nrPersoane;

private LocalTime ora;

private LocalDate data;

private Masa masa;

private PreComanda preComanda;

Scanner input=new Scanner(System.in);

public static ArrayList\<Rezervare\> rezervari = new ArrayList\<\>();

public Rezervare(){

this.persoana=new Persoana();

this.nrPersoane=0;

this.data=LocalDate.EPOCH;

this.ora=LocalTime.MIN;

this.masa=null;

this.preComanda=new PreComanda();

}

public Rezervare(Persoana persoana, int nrPersoane, LocalDate data, LocalTime ora, Masa masa, PreComanda preComanda) {

this.persoana = persoana;

this.nrPersoane = nrPersoane;

this.data=data;

this.ora = ora;

this.masa = masa;

this.preComanda = preComanda;

rezervari.add(this);

}

public Rezervare(Persoana persoana, int nrPersoane, LocalDate data, LocalTime ora, Masa masa) {

this.persoana = persoana;

this.nrPersoane = nrPersoane;

this.data=data;

this.ora = ora;

this.masa = masa;

this.preComanda = new PreComanda();

rezervari.add(this);

}

public boolean rezerva(Masa mese[], Meniu meniu){

persoana.introducere();

System.out.println("Numarul de persoane:");

this.nrPersoane=input.nextInt();

System.out.println("Data (zz/LL/aaaa):");

this.data = LocalDate.parse(input.next(), ProiectPOO.format);

System.out.println("Ora (hh:mm):");

this.ora=LocalTime.parse(input.next());

System.out.println("Mese valabile:");

int nevalabile[] = new int[30];

int nrNevalabile = 0;

int nrValabile=0;

int i, j;

for(i=0;i\<Masa.getNrMese();i++){

if (nrPersoane \> mese[i].getLocuri()) continue;

for (j = 0; j \< rezervari.size(); j++){

if (rezervari.get(j).getMasa() == mese[i]){

if (rezervari.get(j).getData().equals(this.data) && Math.abs(rezervari.get(j).getOra().until(this.ora, MINUTES)) \< 60){

nevalabile[nrNevalabile] = i;

nrNevalabile++;

break;

}

}

}

if (j \< rezervari.size()) continue;

mese[i].afisare();

nrValabile++;

}

if(nrValabile == 0){

System.out.println("Niciuna.");

return false;

}

System.out.println("Introduceti numarul mesei dorite: ");

int m=input.nextInt() - 1;

if (m \>= Masa.getNrMese()){

System.out.println("Masa inexistenta.");

return false;

}

for (i=0;i\<nrNevalabile;i++){

if (m == nevalabile[i]){

System.out.println("Masa nu este valabila.");

return false;

}

}

this.masa = mese[m];

System.out.println("Doriti sa pre-comandati ceva? (y/n)");

switch (input.next()){

case "y":

case "Y":

this.preComanda.initializare(meniu);

break;

default:

break;

}

System.out.println("Rezervare completa!");

rezervari.add(this);

return true;

}

public void afisare(){

System.out.println();

persoana.afisare();

System.out.println("Numarul de persoane: "+this.nrPersoane+"\\nData: "+this.data.format(ProiectPOO.format)+"\\nOra: "+this.ora);

masa.afisare();

if (!preComanda.isNull())

preComanda.afisare();

}

// Functii GET / SET

In clasa main, supranumita **ProiectPOO**, se initializeaza mesele din restaurant, lista cu rezervari extrase din fisierul **Rezervari.xml**, si meniul extras din fisierul **Meniu.xml**. Dupa acestea, utilizatorul va avea de ales intre a se autentifica in contul de operator sau de client. In caz ca acesta alege sa se autenficice ca operator, va trebui sa introduca parola corecta **“54321”** si va avea acces la rezervarile tuturor clientilor setand variabila **currentRez** ca fiind **Rezervare.rezervari** (membrul static ce contine toate rezervarile create). In schimb, daca utilizatorul alege sa se autentifice ca si client, acesta va avea acces doar la rezervarile facute de acesta, setand variabila **currentRez** ca fiind un nou obiect de tipul **ArrayList\<Rezervare\>**. Dupa logare, un meniu cu patru optiuni va fi afisat si utilizatorul va putea alege una dintre optiuni care vor intra intr-o structura **switch** si vor executa actiunile necesare.

public class ProiectPOO {

public static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

public static void main(String[] args) {

Scanner input= new Scanner(System.in);

Masa mese []= new Masa[15];

ArrayList\<Rezervare\> rezervari = new ArrayList\<\>();

ArrayList\<Rezervare\> currentRez = new ArrayList\<\>();

System.out.println("Bine ati venit la Impinge Tava!");

mese[0] = new Masa(2, "interior");

mese[1] = new Masa(4, "interior");

mese[2] = new Masa(8, "interior");

mese[3] = new Masa(4, "interior");

mese[4] = new Masa(6, "interior");

mese[5] = new Masa(2, "interior");

mese[6] = new Masa(2, "terasa");

initRezervari(mese);

Meniu meniu = initMeniu();

//new Rezervare(new Persoana("Rusanda", "Valentin", "0755012345"), 3, LocalDate.parse("2022-07-23"), LocalTime.parse("15:30"), mese[1], new PreComanda());

System.out.println("Selectati tipul de utilizator:\\n1. Client\\n2. Operator");

switch(input.nextInt()){

case 2:

// Meniu Operator

String pass;

int tries = 0;

do {

System.out.println("Introduceti parola:");

pass = input.next();

if (pass.equals("54321")){

currentRez = Rezervare.rezervari;

System.out.println("V-ati logat ca operator!");

break;

}

tries++;

System.out.println("Parola gresita. Incercari " + tries + " / 3.");

}

while (tries \< 3);

if (tries \< 3) break;

System.out.println("Ati depasit numarul maxim de incercari.");

return;

default:

currentRez = rezervari;

System.out.println("V-ati logat ca si client!");

break;

}

while(true){

System.out.println("Selectati optiunea dorita:");

System.out.println("1. Rezervare\\n2. Afiseaza rezervarile curente\\n3. Anuleaza rezervare\\n4. Iesire");

int actiune;

actiune=input.nextInt();

switch (actiune) {

case 1:

Rezervare A= new Rezervare();

if(!A.rezerva(mese, meniu)){

break;

}

rezervari.add(A);

break;

case 2:

System.out.println();

afisareRezervari(currentRez);

break;

case 3:

if (currentRez.size() == 0){

System.out.println("Nu exista rezervari.");

break;

}

afisareRezervari(currentRez);

System.out.println("\\nIntroduceti numarul rezervarii pe care doriti sa o anulati:");

int rez = input.nextInt() - 1;

if (currentRez.get(rez) == null){

System.out.println("Rezervarea nu exista.");

break;

}

currentRez.remove(rez);

System.out.println("Rezervarea a fost anulata cu succes!");

break;

case 4:

return;

default:

System.out.println("Optiunea nu exista!");

break;

}

System.out.println("\\nDoriti sa efectuati alta operatiune? (y/n)");

switch (input.next()){

case "y":

case "Y":

break;

default:

return;

}

System.out.println();

}

}

## 

## Testarea

**Test 1:**

Imediat ce rulam programul, suntem intampinati de un mesaj de intampinare si un meniu ce ne permite sa ne selectam tipul de utilizator.

![](media/d096ed17804936e4e058fe19fb8f14ca.png)

Vom introduce de la tastatura **“1”** si vom apasa Enter. Ne-am autentificat cu succes ca si client. Un meniu este afisat pe ecran ca in captura urmatoare:

![](media/d74598ff9835e67f6016d82bd3c7bf54.png)

Vom parcurge fiecare optiune in parte, in ordine de la 3 la 1, pentru a vedea cum ruleaza programul.

Cazul **“3”**:

![](media/635cd0dbb2defb3f29ee0bd35a63e591.png)

Se observa ca nu exista rezervari. Daca tastam **“y”**, se va afisa din nou meniul cu cele patru optiuni.

Cazul **“2”**:

![](media/f23040beaf2fd6d7d496c401fef109aa.png)

La fel ca la cazul **“3”**, nu exista rezervari. Programul functioneaza corect. Vom tasta **“y”** pentru a reveni la meniul principal.

Cazul **“1”**:

Ni se cere sa introducem de la tastatura date despre rezervare. Dupa ce terminam, ni se afiseaza o lista cu mesele valabile.

![](media/e34109d718381f9642234999e28d0e2c.png)

Pentru acest test, vom alege masa numarul **7**. Programul ne intreaba daca dorim sa precomandam.

![](media/83d9477dab6b58562c9d2c24bbd13fdb.png)

Vom tasta **“y”** si vom apasa Enter. Se afiseaza un meniu, urmat de o serie de instructiuni.

![](media/22abcc50016163ff78c9c0923a48ebbe.png)

Vom incerca sa introducem **“Sarmale”**, dar programul afiseaza ca produsul nu exista. Introducem apoi **“Supa de galuste”** si **“papanasi”**, iar dupa fiecare input ne afiseaza ca produsul a fost adaugat cu succes. Tastam **“0”** si ni se cer observatii pentru comanda. Introducem **“-“** si mesajul **“Rezervare completa!”** se afiseaza.

![](media/bb831a908804c786e2c6e6f133a838fb.png)

Tastam **“y”** si suntem dusi inapoi la meniul principal. Vom tasta **“2”** sa afisam rezervarile curente si programul va afisa rezervarea efectuata anterior.

![](media/6d863d9d3a1ce7460ff1e867d086d710.png)

Tastam din nou **“y”** si efectuam alta rezervare introducand **“1”**. Introducem informatii despre rezervare, iar data si ora le tastam la fel ca la rezervarea anterioara.

![](media/812f6f7c14755c7b3b29d92b80254081.png)

Putem observa ca masa rezervata anterior nu mai este afisata deoarece nu mai este valabila. Daca incercam sa introducem numarul acelei mese (**“7”)**, se afiseaza un mesaj spunand ca masa nu este valabila iar rezervarea se anuleaza.

![](media/fddc8d7bb5b9e0f3e1ce674f8045dfce.png)

Revenim la meniul principal si introducem **“3”**. Ni se afiseaza lista rezervarilor insotita de mesajul **“Introduceti numarul rezervarii pe care doriti sa o anulati:”**. Vom introduce **“1”** pentru a anula rezervarea cu numarul **1** si ni se comunica succesul anularii.

![](media/2a5a9bf79678a5d1a4e5d74ace6a4263.png)

Daca incercam sa afisam lista cu rezervarile curente, vom vedea ca nu mai exista nicio rezervare.

![](media/5d19a9101cdbd7472436c9bac94eaf49.png)

Tastam **“n”**, iar programul se opreste.

**Test 2:**

Rulam programul si suntem intampinati cu acelasi mesaj ca la **testul 1**, numai ca de data aceasta vom introduce **“2”** pentru a ne autentifica in contul de operator. Ne este comunicat sa introducem parola, asa ca introducem **“restaurant”**. **“Parola gresita. Incercari 1 / 3”**. De data asta introducem **“12345”**. **“Parola gresita. Incercari 2 / 3”**. Mai avem o incercare, asa ca tastam parola corecta **“54321”**, iar programul ne comunica faptul ca ne-am autentificat la contul de operator si afiseaza meniul principal, identic cu cel al clientului.

![](media/65ed40a2cb63bc655b1f4f26df3f5696.png)

Daca incercam sa afisam rezervarile, vom observa ca programul ne afiseaza cateva rezervari care nu ne apartin.

![](media/6c2074db81a863355672eddf7bd9ef99.png)

Programul functioneaza corect deoarece operatorul are acces la rezervarile tuturor clientilor. Revenim la meniul principal si incercam sa anulam o rezervare, alegand optiunea **“3”**. Vom anula rezervarea numarul **2**.

![](media/bd1e4cb6221440adde509d3a4dc2914f.png)

Cand incercam sa afisam, observam ca rezervarea numarul **2** nu mai exista, deci programul a functionat corect.

![](media/d655c5f06ec017f8f7f2376c9806bcc6.png)

Tastam **“n”** si programul se opreste.

# CONCLUZII

In concluzie programul ruleaza in parametri fara sa fi indentificat in perioada de testare probleme de functionare supranumite “bugs”.

Programul isi indeplineste rolul cu success, clientul avand posibilitatea de a-si rezerva masa la un restaurant si de a comanda inainte. Un dezavantaj al programului este lipsa interfetei grafice (UI/UX), lucrul ce-l face putin dificil de utilizat pentru anumite persoane.

Pe viitor se poate adauga o interfata grafica, cat si diferite optiuni in meniu sau noi functionalitati precum: administrarea meselor de catre operator, sectiunea de “Informatii” in meniul principal sau implementarea unei baze de date.

# BIBLIOGRAFIE

1.  <https://www.geeksforgeeks.org/java/>
2.  <https://www.w3schools.com/java/>
3.  <https://www.visual-paradigm.com/guide/uml-unified-modeling-language/uml-classdiagram-tutorial/>
4.  <https://app.diagrams.net/>
