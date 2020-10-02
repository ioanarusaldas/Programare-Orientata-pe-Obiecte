Savu Ioana Rusalda -325CB

	Tema2
Termostat Inteligent

	CLASS Main
	In clasa Main am realizat citirea din fisier si apelarea metodelor
corespunzatoare fiecarei comenzi.Citirea o fac cu ajutorul unui BufferedReader
si citiesc linie cu linie.Fiecare linie este apoi separata dupa spatiu.

	CLASS House
	Clasa House contine temperatura si umiditatea globala si un ArrayList
de camere.Pentru instantierea obiectelor de tip House folosesc 2 constructori
(unul pentru cazul in care este luata in calcul si umiditatea si unul pentrul 
cazul fara umiditate).
	Metoda addRoom adauga o camera in vectorul de camere din clasa.Metoda 
changeTemp schimba temperatura globala a casei.

	CLASS Room
	Clasa Room contine numele camerei,id-ul device-ului,suprafata camerei 
si un HashTable cu chei specifice fiecarui interval de temperatura si elemente 
de timp interval. Constructorul pune in hastable cate un obiect de tip interval 
si seteaza campurile aferente clasei.

	CLASS Interval
	Clasa contine doua SortedSet-uri, "set" pentru temperaturi si "setH" 
pentru umiditati.Metoda adaugT adauga temperatura inregistrata.Metoda adaugH 
adauga umiditatea inregistrata.

	CLASS Observe
	Clasa Observe contine metoda addTemp care calculeaza pozitia din 
interval corespunzatoare orei la care a fost inregistrata o temperatura si 
cauta acea pozitie urmand sa adauge temperatura prin apelul metodei din clasa 
Interval.

	CLASA ObserveH
	Clasa ObserveH contine metoda addHumidity care calculeaza pozitia din 
interval corespunzatoare orei la care a fost inregistrata o umiditate si o adauga 
prin apelul metodei adaugH din clasa Interval ,asemanator metodei addTemp din 
clasa Interval.

	CLASA Trigger_heat
	Metoda findTemp cauta temperaturile minime inregistrate in ultimele 
ore si calculeaza media ponderata a acestora,conform cerintei.
	Metoda findHumidity cauta umiditatile minime inregistrate in ultimele 
ore si calculeaza media ponderata a acestora,conform cerintei.
	Metoda Start stabileste daca centrala trebuie pornita conform cerintei.

	CLASA List
	Metoda write scrie in fisierul de iesire temperaturile din intervalul 
primit ca parametru.

	
	

	

