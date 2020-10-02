
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class BasketballTeam extends Team {
	/**
	 * @param name -numele echipei
	 * @param gender -categoria echipei
	 * @param numberOfPlayers -numarul de jucatori
	 */
	public BasketballTeam(String name, String gender, int numberOfPlayers) {
		setTeamName(name);
		setGender(gender);
		setNumberOfPlayers(numberOfPlayers);
	}
}
