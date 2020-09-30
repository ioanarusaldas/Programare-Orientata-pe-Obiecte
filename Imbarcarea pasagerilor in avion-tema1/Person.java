
/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Person {
	private String name;
	private int age;
	private String ticket;
	private boolean specialNeeds;
	private boolean priorityEmbark;
	String id;

	Person() {

	}

	/**
	 * @param id     id.ul unei persoane
	 * @param name   numele unei persoane
	 * @param age    varsta unei persoane
	 * @param ticket tipul biletului unei persoane
	 * @param p      imbarcarea prioritara
	 * @param s      nevoi speciale
	 */
	Person(String id, String name, int age, String ticket, boolean p, boolean s) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.ticket = ticket;
		this.specialNeeds = s;
		this.priorityEmbark = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public boolean isspecialNeeds() {
		return specialNeeds;
	}

	public void setspecialNeeds(boolean specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	public boolean ispriorityEmbark() {
		return priorityEmbark;
	}

	public void setpriorityEmbark(boolean priorityEmbark) {
		this.priorityEmbark = priorityEmbark;
	}

	/**
	 * Metoda acorda puncte in functie de varsta
	 * 
	 * @return returneaza numarul de puncte obtinute de o persoana
	 */
	public int agePoint() {
		int point = 0;
		if (age >= 0 && age < 2)
			point = 20;
		if (age >= 2 && age < 5)
			point = 10;
		if (age >= 5 && age < 10)
			point = 5;
		if (age >= 10 && age < 60)
			point = 0;
		if (age >= 60)
			point = 15;
		return point;
	}

	/**
	 * Metoda acorda puncte in functie de tipul biletului
	 * 
	 * @return returneaza numarul de puncte obtinut de o persoana
	 */
	public int ticketPoint() {
		int point = 0;
		if (ticket.equals("b") == true)
			point = 35;
		if (ticket.equals("p") == true)
			point = 20;
		if (ticket.equals("e") == true)
			point = 0;
		return point;
	}

	/**
	 * Metoda acorda puncte daca persoana are imbarcare prioritara
	 * 
	 * @return returneaza numarul de puncte obtinut de o persoana
	 */
	public int priorityPoint() {
		int point = 0;
		if (priorityEmbark == true)
			point = 30;
		return point;
	}

	/**
	 * Metoda acorda puncte daca persoana are nevoi speciale
	 * 
	 * @return returneaza numarul de puncte obtinut de o persoana
	 */
	public int specialNeedsPoint() {
		int point = 0;
		if (specialNeeds == true)
			point = 100;
		return point;
	}

}
