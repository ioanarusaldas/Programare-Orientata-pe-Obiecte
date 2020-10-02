import java.io.PrintWriter;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */

public class Trigger_heat {

	/**
	 * Metoda calculeaza media ponderata a temperaturilor minime
	 * @param house - obiect de tip House
	 * @param n -numarul de camere din casa
	 * @return returneaza media ponderata conform cerintei
	 */
	public double findTemp(House house, int n) {
		double temp = 1.00;
		int area = 0;
		double sumPond = 0.00;
		double sum = 0.00;

		for (int i = 0; i < n; i++) { //se parcurge vectorul de camere
			temp = 1.00;
			area = 0;
			for (int j = 24; j >= 1; j--) {//se ia fiecare cheie din hastable(reprezentand fiecare ora)
				if (house.rooms.get(i).h.get(j).set.isEmpty() != true) {
					//verific daca intervalul de temperaturi este gol
					temp = (double) house.rooms.get(i).h.get(j).set.first();//prima temperatura dintr-un interval
					area = house.rooms.get(i).area;//aria camerei
					break;
				}
			}
			sum = sum + (temp * area);
			sumPond = sumPond + area;//suma ariilor
		}
		return sum / sumPond;
	}

	/**
	 * Metoda calculeaza media ponderata a umiditatilor
	 * @param house - obiect de tip House
	 * @param n - numarul de camere
	 * @return returneaza media ponderata a umiditatilor conform cerintei
	 */
	public double findHumidity(House house, int n) {
		double humidity = 1.00;
		int area = 0;
		double sumPond = 0.00;
		double sum = 0.00;

		for (int i = 0; i < n; i++) {//se parcurge vectorul de camere
			humidity = 1.00;
			area = 0;
			for (int j = 24; j >= 1; j--) {//se ia fiecare cheie din hastable(reprezentand fiecare ora)
				if (house.rooms.get(i).h.get(j).setH.isEmpty() != true) {
					//verific daca intervalul de umiditati e gol
					humidity = (double) house.rooms.get(i).h.get(j).setH.first();//prima umiditate din interval
					area = house.rooms.get(i).area;
					break;
				}
			}
			sum = sum + (humidity * area);
			sumPond = sumPond + area;//suma arii camere
		}

		return sum / sumPond;
	}

	/**
	 * Metoda verifica daca trebuie pornita centrala
	 * @param writer -fisierul de iesire
	 * @param house - obiect de tip House
	 * @param numberRooms - numarul de camere
	 */
	public void Start(PrintWriter writer, House house, int numberRooms) {
		double ref = findTemp(house, numberRooms);//media ponderata a temperaturii
		double ref2 = findHumidity(house, numberRooms);//media ponderata a umiditatii
		if (house.globalHumidity == 0) {//se verifica daca exista umiditate globala
			/*se verifica daca media temperaturilor e mai mica 
			decat temperatura globala*/
			if (ref < house.globalTemp)
				writer.println("YES");
			else
				writer.println("NO");
		} else {/*se verifica daca media umiditatilor e mai mare
					decat umiditatea dorita */
			if (ref2 > house.globalHumidity)
				writer.println("YES");
			else
				writer.println("NO");

		}

	}

}
