/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
	public class BasketballCompetition implements TypeCompetition{

	/**
	 * metoda visitFemininCompetition calculeaza scorul unei echipe feminine
	 * de basket
	 */
	@Override
	public double visitFemininCompetition(FemininCompetition feminin) {
		double sum = 0;
		double nr=0;
		
		for(int i=0 ;i < feminin.getTeam().getNumberOfPlayers();i++) {
			sum = sum +  Double.valueOf(feminin.getTeam().players.get(i).getScore());
			nr++;
		}
		return sum/nr;
	}
	

	/**
	 *metoda visitFemininCompetition calculeaza scorul unei echipe masculine
	 *de basket
	 */
	@Override
	public double visitMasculinCompetition(MasculinCompetition masculin) {
		double sum = 0;
		double nr=0;
		
		for(int i=0 ;i < masculin.getTeam().getNumberOfPlayers();i++) {
			sum = sum +  Double.valueOf(masculin.getTeam().players.get(i).getScore());
			nr++;
		}
		return sum/nr;
	}
	

}
