/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class FemininCompetition implements GenderCompetition {
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public double accept(TypeCompetition competition) {
		return competition.visitFemininCompetition(this);

	}

}
