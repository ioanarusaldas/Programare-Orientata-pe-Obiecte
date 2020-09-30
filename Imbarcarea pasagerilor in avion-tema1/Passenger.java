

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public abstract class Passenger {
	Person[] person;

	Passenger() {
	}

	/**
	 * Constructorul declara vectorul de pasageri
	 * 
	 * @param d dimensiunea vectorului de pasageri
	 */
	Passenger(int d) {
		person = new Person[d];
	}

	/**
	 * Metoda calculeaza prioritatea si este implementata in functie de tipul de
	 * pasageri
	 * 
	 * @return returneaza prioritatea calculata
	 */
	public abstract int getPriority();

	/**
	 * @return returneaza vectorul unui pasager
	 */
	public abstract String getId();

}
