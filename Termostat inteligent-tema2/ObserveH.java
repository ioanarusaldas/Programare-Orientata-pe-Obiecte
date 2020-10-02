
public class ObserveH {
	public void addHumidity(int timeRef,House house,String id_device,String[] strArray) {
		int timeObs = Integer.parseInt(strArray[2]);//conversie string
		double humidity = Double.parseDouble(strArray[3]);//conversie string
		int pozInt;
		/*calcularea pozitiei in interval corespunzatoare 
	  	orei la care a fost inregistrata umiditatea*/
		pozInt= 24 - ((timeRef - timeObs) / 3600);
		for (int i = 0; i < house.rooms.size(); i++)
			if (house.rooms.get(i).id.equals(id_device)) {
				if (pozInt > 0 && pozInt <= 24 && timeRef>timeObs)
					house.rooms.get(i).h.get(pozInt).adaugH(humidity);
				}
	}
}
