Savu Ioana Rusalda - 325CB
Tema 3
	In clasa main am realizat determinrea operatiei(inscriere sau competitie)
pentru a apela corect metodele si pentru a instantia corect obiectele.
	Clasa Team reprezinta o echipa si contine un array de jucatori(players).
Jucatorii sunt de tip Player,avand ca si clasa reprezentativa clasa Player.In 
aceasta clasa sunt salvate informatiile despre un jucator(nume,scor).
	Tipurile de competitie sunt ilustrate prin subclasele clasei Team
(BasketballTeam, HandballTeam si FootballTeam)
	In clasa Inscriere am realizat inscrierea echipelor conform cerintei folosind 
design pattern-urile cerute.Echipele au fost salvate intr-un array din aceasta clasa.
Pentru a folosi design patternu-ul Factory am folosit si clasa TeamFactory.
	In clasa Competition am realizat inscrierea echipelor in competitie conform 
fisierului corespunzator.Prin metoda prepareCompetition am salvat echipele din
fisierul de competitie in array-ul registeredTeams pentru a retine ordinea.
Prin metoda teamsScore am calculat scorul fiecarei echipe conform cerintei , folosind
design pattern-ul Visitor.Pentru acest pattern am mai folosit si clasele:
BasketBallCompetition,FootballCompetition, HandballCompetition,FemininCompetition si 
MasculinCompetition si interfetele:GenderCompetition si TypeCompetition. Prin metoda startCompetition am acordat punstajele in urma fiecarui
meci jucat si am notificat echipele de schimbarea clasamentului cu ajutorul design pattern-uli observer. Pentru acesta am folosit si interfetele Observable,Observer si clasa ObserverTeam. In array-ul rankList am salvat clasamentul inainte de jucarea meciurilor 
folosindu-ma de clasa Rank.Metoda display imi afiseaza primele 3 echipe din clasament
	
