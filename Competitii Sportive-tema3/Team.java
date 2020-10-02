import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Team {
	private String teamName;
	private String gender;
	private int numberOfPlayers;
	ArrayList<Player> players = new ArrayList<Player>(numberOfPlayers);

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public void display1(PrintWriter writer) {//afisare echipe
		writer.print("{teamName: " + getTeamName() + ", gender: " + getGender() + ", numberOfPlayers: "
				+ getNumberOfPlayers() + ", players: [");
		for (int i = 0; i < players.size(); i++) {
			if (i != players.size() - 1)
				writer.print("{name: " + players.get(i).getName() + ", score: " + players.get(i).getScore() + "}, ");
			else
				writer.print("{name: " + players.get(i).getName() + ", score: " + players.get(i).getScore() + "}");

		}
		writer.print("]}");
		writer.println();
	}
}
