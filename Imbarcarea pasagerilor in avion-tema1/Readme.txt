Tema 1 - Imbarcarea pasagerilor in avion
Savu Ioana Rusalda 325CB

Queue class

	Aceasta clasa contine implementarea cozii de prioritate printr-un Max-heap.
	Heap-ul este implementat cu vector.Elementele din vector sunt asezate astfel:
daca un nod este pe pozitia k din vector, atunci copilul din stanga se afla pe 
pozitia 2*k iar copilul din dreapta pe pozitia 2*k+1. 
	Pentru usurinta urmaririi programului,elementele sunt asezate incepand de la 
pozitia 1 din vector. Pozitia 0 este setata pe null.
	Heap-ul contine elemente de tip pasager.Constructorul clasei seteaza 
dimensiunea maxima avectorului cu numarul de persoane primite ca input si 
dimensiunea initiala pe 0.
	Metoda maxHeapify  rearanjeaza recursiv  arborele ,dupa eliminarea root-ului, 
pentru a respecta conditia de max-Heap.Astfel, prima data se verifica daca 
copiii au prioritate mai mare decat parintele.Daca unul dintre copii are 
prioritate mai mare se face interschimbarea intre parinte si copil, cu ajutorul 
functiei swap.
	Metoda insert introduce un pasager in coada de prioritate,si rearanjeaza 
heap-ul in vederea respectarii conditiei de maxHeap.
	Metoda embark elimina primul pasager din coada de prioritati si rearanjeaza 
heap-ul cu ajutorul metodei maxHeapify.

Passenger Class

	Clasa pasager contine un vector de persoane de dimensiune variabila. 
Dimensiunea acestui vector este setata cu ajutorul constructorului care primeste
ca parametru  dimensiunea.Prin urmare, dimensiunea vectorului va fi 1 daca este 
vorba de un pasager singur. Daca este vorba de o familie sau un grup, 
dimensiunea vectorului va fi setata in functie de numarul de persoane din 
familie, respectiv grup.

Family Class

	Clasa Familie initializeaza vectorul din clasa parinte(Passenger) cu 
persoanele din familie. Persoanele dintr-o familie sunt transmise catre 
constructor prin intermediul unui vector cu elemente de tip persoana.
	Metoda getPriority din clasa parinte este implementata aici si calculeaza 
prioritatea unei familii conform cerintei.
	Metoda getId returneaza id-ul familiei.

Group Class

	Clasa Grup  initializeaza vectorul din clasa parinte(Passenger) cu 
persoanele dintr-un grup. Implementarea este asemanatoare clasei familie.
Diferenta se afla in metoda getPriority prin punctajul acordat unui grup.

Single Class

	Clasa Singur  initializeaza vectorul din clasa parinte(Passenger) cu 
dimensiunea 1.Implementarea este asemanatoare clasei familie.Diferenta se afla 
in metoda getPriority prin 
punctajul acordat unei persoane single.

Person Class

	Clasa peroana contine informatiile despre o persoana. Acestea sunt private pentru 
a proteja informatiile despre o persoana,prin incapsulare.Constructorul 
seteaza aceste campuri cu informatiile primite ca si parametru.
	Metoda agePoint acorda puncte unei persoane in functie de varsta.
	Metoda ticketPoint acorda puncte unei persoane in functie de tipul biletului.
	Metoda priorityPoint acorda puncte unei persoane cu imbarcare prioritara.
	Metoda specialNeedsPoint acorda puncte unei persoane cu nevoi speciale.

Test Class

	Metoda put adauga o persoana in HashTable la o anumita cheie.Fiecare cheie 
reprezinta o entitate(familie,grup,single).
	Tot in aceasta clasa sunt citite persoanele si comenzile din fisier si 
apelate functiile specifice comenzilor(embark,list,insert).
	Inainte de citirea comenzilor ,toate persoanele sunt inroduse intr-un 
hashTable cu elemente de tip persoana.
	La comanda insert lista de la cheia specifica comenzii insert este 
transformata in vector sitrimisa ca parametru constructorului clasei pentru 
care se face instantierea unui obiect(family,group,single).
	



