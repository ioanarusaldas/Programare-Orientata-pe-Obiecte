
public class Rank implements Comparable<Rank> {
	private String name;
	private double score;

	Rank() {
	}

	Rank(String name, double score) {
		setName(name);
		setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public int compareTo(Rank rank) {
		if (score > rank.getScore())
			return 1;
		else if (score < rank.getScore())
			return -1;
		return 0;
	}

}
