import java.util.ArrayList;

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class House {
	double globalTemp;
	double globalHumidity;
	ArrayList<Room> rooms;
	/**
	 * Constructor default
	 */
	House(){}
	/**
	 * @param globalTemp - temperatura globala
	 * @param numberRooms - numarul de camere din casa
	 */
	House(double globalTemp , int numberRooms){
		this.globalTemp = globalTemp;
		this.rooms = new ArrayList <Room>(numberRooms);
		this.globalHumidity=0;
	}
	/**
	 * @param globalTemp - temperatura globala
	 * @param numberRooms - numarul de camere
	 * @param humidity - umiditatea globala
	 */
	House(double globalTemp , int numberRooms,double humidity){
		this.globalTemp = globalTemp;
		this.globalHumidity = humidity;
		this.rooms = new ArrayList <Room>(numberRooms);
	}
	/**
	 * Metoda adauga o camera in array-ul de camere
	 * @param room - camera ce urmeaza sa fie adaugata
	 */
	public void addRoom(Room room) {
		rooms.add(room);
	}
	/**
	 * Metoda schimba temperaturra globala a casei
	 * @param temp - noua temperatura 
	 */
	public void changeTemp(double temp) {
		this.globalTemp = temp;
	}
	
}
