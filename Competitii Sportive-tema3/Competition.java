import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Competition implements Observable {
	private String type;
	private String gender;
	ArrayList<Team> competitionTeams = new ArrayList<Team>();//array cu echipele ce participa la competitie
	ArrayList<Rank> rankList = new ArrayList<Rank>();//array cu clasament si cu scorul calculat pentru fiecare echipa
	ArrayList<Observer> teams = new ArrayList<Observer>();//array cu echipele ce urmeaza sa fie notificate

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param inputC          -fisier cu echipele din competitie
	 * @param registeredTeams -clasa ce retine echipele inscrise
	 * @throws IOException metoda adauga in array-ul pentru competitie doar echipele
	 *                     corespunzatoare
	 */
	public void prepareCompetition(String inputC, Inscriere registeredTeams) throws IOException {
		File inputFile = new File(inputC);
		Team auxTeam;
		String st;
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		st = br.readLine();
		String[] strArray = st.split("\\,\\ ");
		setType(strArray[0]);
		setGender(strArray[1]);
		st = br.readLine();
		while (st != null) {//verific ca echipele ce urmeaza sa participe au fost inscrise inainte si respecta conditiile
			for (int i = 0; i < registeredTeams.teams.size(); i++) {
				auxTeam = registeredTeams.teams.get(i);
				if (auxTeam.getTeamName().equals(st) && auxTeam.getGender().equals(getGender())) {
					competitionTeams.add(auxTeam);//adaug echipele in competitie
				}

			}
			st = br.readLine();
		}
		br.close();
	}

	/**
	 * metoda calculeaza scorul in functie de categoria si tipul meciurilor ce vor
	 * fi jucate
	 */
	public void teamsScore() {
		double score = 0;
		FootballCompetition football = new FootballCompetition();
		HandballCompetition handball = new HandballCompetition();
		BasketballCompetition basketball = new BasketballCompetition();
		//verific genul competitiei si categoria pentru calcularea corecta a scorului
		if (getGender().equals("feminin")) {
			FemininCompetition feminin = new FemininCompetition();
			for (int i = 0; i < competitionTeams.size(); i++) {
				feminin.setTeam(competitionTeams.get(i));
				if (getType().equals("football"))
					score = feminin.accept(football);
				if (getType().equals("handball"))
					score = feminin.accept(handball);
				if (getType().equals("basketball")) {
					score = feminin.accept(basketball);
				}
				Rank auxRank = new Rank(competitionTeams.get(i).getTeamName(), score);
				rankList.add(auxRank);
			}

		}
		if (getGender().equals("masculin")) {
			MasculinCompetition masculin = new MasculinCompetition();
			for (int i = 0; i < competitionTeams.size(); i++) {
				masculin.setTeam(competitionTeams.get(i));
				if (getType().equals("football"))
					score = masculin.accept(football);
				if (getType().equals("handball"))
					score = masculin.accept(handball);
				if (getType().equals("basketball"))
					score = masculin.accept(basketball);
				Rank auxRank = new Rank(competitionTeams.get(i).getTeamName(), score);
				rankList.add(auxRank);

			}

		}

		Collections.sort(rankList);//realizare clasament temporar
		Collections.reverse(rankList);
	}

	/**
	 * metoda stabileste castigul fiecarui meci, adauga punctele aferente si
	 * notifica echipele
	 */
	public void startCompetition() {
		double point;
		for (int i = 0; i < rankList.size(); i++) {
			for (int j = i + 1; j < rankList.size(); j++) {
				if (rankList.get(i).getScore() > rankList.get(j).getScore()) {
					point = rankList.get(i).getScore() + 3;
					rankList.get(i).setScore(point);
				} else if (rankList.get(i).getScore() < rankList.get(j).getScore()) {
					point = rankList.get(j).getScore() + 3;
					rankList.get(j).setScore(point);

				} else if (rankList.get(i).getScore() == rankList.get(j).getScore()) {
					point = rankList.get(j).getScore() + 1;
					rankList.get(j).setScore(point);
					point = rankList.get(i).getScore() + 1;
					rankList.get(i).setScore(point);

				}

				notifyObserver();
			}
		}
		Collections.sort(rankList);//restabilire clasament
		Collections.reverse(rankList);

	}

	/**
	 * @param writer metoda afiseaza primele echipe din clasament
	 */
	public void display(PrintWriter writer) {

		for (int i = 0; i < rankList.size(); i++) {
			if (i < 3)
				writer.println(rankList.get(i).getName());
		}
	}

	/**
	 * metoda adauga "observatorii"(echipele) ce vor fi notificate la array(specific
	 * designului visitor)
	 */
	@Override
	public void addObserver(Observer observer) {

		teams.add(observer);

	}

	/**
	 * metoda notifica echipele
	 */
	@Override
	public void notifyObserver() {
		for (Observer o : teams)
			o.update();
	}

}
