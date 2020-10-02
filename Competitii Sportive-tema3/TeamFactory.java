
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class TeamFactory {
	public Team makeTeam(String[] strArray) {

		Team newTeam = null;
		String newTeamType = strArray[0];
		String name = strArray[1];
		String gender = strArray[2];
		int numberOfPlayers = Integer.parseInt(strArray[3]);
		if (newTeamType.equals("football"))
			return new FootballTeam(name, gender, numberOfPlayers);
		else if (newTeamType.equals("handball"))
			return new HandballTeam(name, gender, numberOfPlayers);
		else if (newTeamType.equals("basketball"))
			return new BasketballTeam(name, gender, numberOfPlayers);
		return newTeam;

	}
}
