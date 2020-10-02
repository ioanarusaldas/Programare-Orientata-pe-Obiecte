import java.io.PrintWriter;
import java.util.Locale;

public class List {
	public void write(PrintWriter writer, int timeRef, int numberRooms, House house, String[] strArray) {
		int time_start, time_stop;
		time_start = Integer.parseInt(strArray[2]);
		time_stop = Integer.parseInt(strArray[3]);
		/*calculare indice pozitii in interval a timpilor de start si stop*/
		int T1 = 24 - ((timeRef - time_start) / 3600);
		int T2 = 24 - ((timeRef - time_stop) / 3600);

		for (int i = 0; i < numberRooms; i++) {//parcurgere vector de camere
			if (house.rooms.get(i).name.equals((strArray[1]))) {
				writer.print(house.rooms.get(i).name + " ");
				for (int j = T2; j > T1; j--) {
					//verificare daca un interval de temperaturi e gol
					if (house.rooms.get(i).h.get(j).set.isEmpty() != true)
						for (Object object : house.rooms.get(i).h.get(j).set) {
							if (j > T1 && j <= T2)
								writer.print(String.format(Locale.US, "%.2f", object) + " ");
						}
				}
				writer.println();
			}

		}

	}
}
