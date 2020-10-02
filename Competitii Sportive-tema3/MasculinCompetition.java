
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class MasculinCompetition implements GenderCompetition {
	private Team team;

	@Override
	public double accept(TypeCompetition competition) {
		return competition.visitMasculinCompetition(this);
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
