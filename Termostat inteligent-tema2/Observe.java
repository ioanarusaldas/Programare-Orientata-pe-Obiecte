
/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Observe {
	/**
	 * Metoda adauga o temperatura in intervalul orar corespunzator
	 * @param timeRef - timpul de referinta
	 * @param house - obiect de tip House
	 * @param id_device - id_ul device_ului
	 * @param strArray - stringul citit din fisier
	 */
	public void addTemp(int timeRef, House house, String id_device, String[] strArray) {
		int timeObs = Integer.parseInt(strArray[2]);//conversie string
		double temp = Double.parseDouble(strArray[3]);
		int pozInt;
		/*calcularea pozitiei in interval corespunzatoare 
		  	orei la care a fost inregistrata temperatura*/
		pozInt = 24 - ((timeRef - timeObs) / 3600);
		for (int i = 0; i < house.rooms.size(); i++)//parcurgere vector de camere 
			if (house.rooms.get(i).id.equals(id_device)) {//gasire camera cu id_device cautat
				if (pozInt > 0 && pozInt <= 24 && timeRef > timeObs)
					house.rooms.get(i).h.get(pozInt).adaugT(temp);
			}

	}
}
