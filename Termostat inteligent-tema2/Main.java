import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {

		String nameOfFile = "therm.in";
		File file = new File(nameOfFile);	//deschidere fisier de intrare
		PrintWriter writer = new PrintWriter("therm.out");//deschidere fisier de iesire
		House house;
		int numberRooms, timeRef, index = 0;
		double globalTemp, temp, globalHumidity;
		String st;
		BufferedReader br = new BufferedReader(new FileReader(file));//citire din fisier 
		st = br.readLine();//se citeste linie cu linie din fisier
		String[] strArray = st.split(" ");//se separa linia dupa spatiu
		if (strArray.length == 3) {
			//se trateaza cazurile fara umiditate
			numberRooms = Integer.parseInt(strArray[0]);
			globalTemp = Double.parseDouble(strArray[1]);
			timeRef = Integer.parseInt(strArray[2]);
			house = new House(globalTemp, numberRooms);//instantiere obiect de tip House
		} else {
			//se trateaza cazurile cu umiditate
			numberRooms = Integer.parseInt(strArray[0]);
			globalTemp = Double.parseDouble(strArray[1]);
			globalHumidity = Double.parseDouble(strArray[2]);
			timeRef = Integer.parseInt(strArray[3]);
			house = new House(globalTemp, numberRooms, globalHumidity);//instantiere obiect de tip House
		}
		//se citesc atatea linii din fisier cate camere sunt
		while (index != numberRooms) {
			st = br.readLine();
			strArray = st.split(" ");
			//se instantiaza un obiect de tip oom si este adaugat in House
			Room room = new Room(strArray[0], strArray[1], Integer.parseInt(strArray[2]));
			house.addRoom(room);
			index++;
		}

		while ((st = br.readLine()) != null) {
			strArray = st.split(" ");
			if (strArray[0].equals("OBSERVE")) {//se adauga temperatura din observe
				Observe o = new Observe();
				o.addTemp(timeRef, house, strArray[1], strArray);
			}
			if (strArray[0].equals("TRIGGER")) {//se realizeaza comanda trigger
				Trigger_heat trigger = new Trigger_heat();
				trigger.Start(writer, house, numberRooms);

			}
			if (strArray[0].equals("TEMPERATURE")) {//se restabileste temperatura globala
				temp = Double.parseDouble(strArray[1]);
				house.changeTemp(temp);
			}
			if (strArray[0].equals("LIST")) {//se afiseaza temperaturile
				List list = new List();
				list.write(writer, timeRef, numberRooms, house, strArray);
			}
			if (strArray[0].equals("OBSERVEH")) {//se adauga umiditatile din observeH
				ObserveH o = new ObserveH();
				o.addHumidity(timeRef, house, strArray[1], strArray);
			}
		}
		br.close();
		writer.close();
	}

}
