
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class FootballCompetition implements TypeCompetition {

	/**
	 *metoda calculeaza scorul pentru echipa feminina de football
	 */
	@Override
	public double visitFemininCompetition(FemininCompetition feminin) {
		double minScore = Double.valueOf(feminin.getTeam().players.get(0).getScore());
		double sum = 0;

		for (int i = 1; i < feminin.getTeam().getNumberOfPlayers(); i++) {
			sum = sum + Double.valueOf(feminin.getTeam().players.get(i).getScore());
			if (feminin.getTeam().players.get(i).getScore() < minScore) {
				sum = sum + minScore;
				minScore = Double.valueOf(feminin.getTeam().players.get(i).getScore());
				sum = sum - Double.valueOf(feminin.getTeam().players.get(i).getScore());
			}
		}

		return 2 * minScore + sum;

	}

	/**
	 *metoda calculeaza scorul pentru echipa masculina de football
	 */
	@Override
	public double visitMasculinCompetition(MasculinCompetition masculin) {
		double maxScore = Double.valueOf(masculin.getTeam().players.get(0).getScore());
		double sum = 0;

		for (int i = 1; i < masculin.getTeam().getNumberOfPlayers(); i++) {
			sum = sum + Double.valueOf(masculin.getTeam().players.get(i).getScore());
			if (masculin.getTeam().players.get(i).getScore() > maxScore) {
				sum = sum + maxScore;
				maxScore = Double.valueOf(masculin.getTeam().players.get(i).getScore());
				sum = sum - Double.valueOf(masculin.getTeam().players.get(i).getScore());
			}
		}

		return 2 * maxScore + sum;

	}
}
