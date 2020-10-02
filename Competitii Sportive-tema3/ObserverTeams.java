import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class ObserverTeams implements Observer {
	ArrayList<Rank> rankListcopy;

	Hashtable<String, Integer> h;
	public Competition observable = null;

	public ObserverTeams(Competition observable) {
		this.observable = observable;
		this.h = new Hashtable<String, Integer>();
		copy1(observable);
	}

	/**
	 *metoda restabileste clasamentul dupa notifiarea echipelor
	 */
	public void update() {
		rankListcopy = new ArrayList<Rank>(observable.rankList);
		Collections.sort(rankListcopy);
		Collections.reverse(rankListcopy);
		String name;
		for (int i = 0; i < rankListcopy.size(); i++) {//realizez o copy a clasamentului primit pentru a nu il modifica
			name = rankListcopy.get(i).getName();
			h.put(name, Integer.valueOf(i));//salvare pozitie in clasament
		}
	}

	/**
	 * @param observable
	 * metoda copiaza lista cu echipele in hashtable pentru a tine evidenta clasamentului
	 */
	public void copy1(Competition observable) {
		for (int i = 0; i < observable.rankList.size(); i++)
			h.put(observable.rankList.get(i).getName(), Integer.valueOf(i));//initializare clasament salvat
	}

	/**
	 * @param writer
	 * metoda afiseaza echipele in ordinea intrarii in competitie 
	 *  si locul pe care l-au ocupat
	 */
	public void display2(PrintWriter writer) {
		for (int i = 0; i < observable.competitionTeams.size(); i++) {
			writer.println("Echipa " + observable.competitionTeams.get(i).getTeamName() + " a ocupat locul "
					+ (h.get(observable.competitionTeams.get(i).getTeamName()) + 1));

		}

	}

}
