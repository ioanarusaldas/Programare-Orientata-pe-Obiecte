import java.util.Hashtable;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Room {
	String name;
	String id;
	int area;
	Hashtable<Integer, Interval> h = new Hashtable<Integer, Interval>(24);

	/**
	 * constructor default
	 */
	Room() {
	}

	/**
	 * @param name - numele camerei 
	 * @param id - id_ul divice_ului
	 * @param area - suprafata camerei
	 */
	Room(String name, String id, int area) {
		this.name = name;
		this.id = id;
		this.area = area;
		for (int i = 1; i <= 24; i++)
			this.h.put(i, new Interval());
	}
}
