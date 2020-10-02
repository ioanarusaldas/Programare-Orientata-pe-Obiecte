 /**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class HandballCompetition implements TypeCompetition {

	/**
	 *metoda calculeaza scorul pentru echipa feminina de handball
	 */
	@Override
	public double visitFemininCompetition(FemininCompetition feminin) {
		double pr = 1;

		for (int i = 0; i < feminin.getTeam().getNumberOfPlayers(); i++) {
			pr = pr * Double.valueOf(feminin.getTeam().players.get(i).getScore());
		}
		return pr;

	}

	/**
	 *metoda calculeaza scorul pentru echipa masculina de handball
	 */
	@Override
	public double visitMasculinCompetition(MasculinCompetition masculin) {
		double sum = 0;

		for (int i = 0; i < masculin.getTeam().getNumberOfPlayers(); i++) {
			sum = sum + Double.valueOf(masculin.getTeam().players.get(i).getScore());
		}
		return sum;
	}

}
