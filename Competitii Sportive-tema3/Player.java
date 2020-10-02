
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Player {
	private String name;
	private int score;

	Player() {
	}

	Player(String name, int score) {
		setName(name);
		setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
