import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author BigBoss
 *
 */
public class Inscriere {
	ArrayList<Team> teams = new ArrayList<Team>();//array cu echipele inscrise
	private static Inscriere instance = null;

	private Inscriere() {

	}

	public static Inscriere getInstance() {
		if (instance == null)
			instance = new Inscriere();
		return instance;
	}

	/**
	 * @param nameOfInputFile - nume fisier intrare
	 * @param nameOfOutputFile - nume fisier iesire
	 * @throws IOException
	 * metoda realizeaza inscierea echipelor salvandu-le intr-un array
	 */
	public void applyInscriere(String nameOfInputFile, String nameOfOutputFile) throws IOException {
		File inputFile = new File(nameOfInputFile);
		if (inputFile != null) {
			String st;
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			st = br.readLine();
			while (st != null) {
				String[] strArray = st.split("\\,\\ ");
				TeamFactory teamFactory = new TeamFactory();
				Team team = null;
				team = teamFactory.makeTeam(strArray);//creare echipa cu Singleton
				int numberOfPlayers = Integer.parseInt(strArray[3]);
				while (numberOfPlayers != 0) {
					st = br.readLine();
					strArray = st.split("\\,\\ ");
					Player player = new Player(strArray[0], Integer.parseInt(strArray[1]));
					if (team != null) {

						team.players.add(player);//adaug jucator la echipa
					}

					numberOfPlayers--;
				}
				this.teams.add(team);

				st = br.readLine();
			}
			br.close();
		}
	}

}
