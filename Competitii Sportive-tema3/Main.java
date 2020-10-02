import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		if (args[0].equals("inscriere")) {
			String nameOfInputFile = args[1];
			String nameOfOutputFile = args[3];
			PrintWriter writer = new PrintWriter(nameOfOutputFile);
			Inscriere ins = Inscriere.getInstance();
			ins.applyInscriere(nameOfInputFile, nameOfOutputFile);//inscriere echipe
			for (int i = 0; i < ins.teams.size(); i++)
				ins.teams.get(i).display1(writer);//afisare echipe inscrise
			writer.close();

		}
		if (args[0].equals("competitie")) {
			String nameOfInputFile = args[1];
			String inputC = args[2];
			String nameOfOutputFile = args[3];

			PrintWriter writer = new PrintWriter(nameOfOutputFile);
			Inscriere ins = Inscriere.getInstance();
			ins.applyInscriere(nameOfInputFile, nameOfOutputFile);//inscriere echipe
			Competition competition = new Competition();
			competition.prepareCompetition(inputC, ins);//selectare echipe competitie
			competition.teamsScore();//calculare scor echipe
			ObserverTeams observer = new ObserverTeams(competition);
			competition.addObserver(observer);//stabilire echipe ce vor fi notificate
			competition.startCompetition();//recalculare scor dupa jucarea meciurilor
			competition.display(writer);//afisare primele 3 echipe din clasament
			observer.display2(writer);//afisare echipe din competitie
			writer.close();

		}
	}
}
