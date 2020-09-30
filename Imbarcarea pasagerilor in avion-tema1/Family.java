
/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Family extends Passenger {

	Family() {
	}

	/**
	 * Constructorul initializeaza vectorul cu membrii familiei
	 * 
	 * @param family vectorul ce contine membrii familiei
	 */
	Family(Person[] family) {
		super(family.length);
		for (int i = 0; i < family.length; i++)
			person[i] = family[i];
	}

	/**
	 * Metoda calculeaza prioritatea unei familii
	 */
	@Override
	public int getPriority() {
		int priority = 10;
		for (int i = 0; i < person.length; i++)
			priority = priority + person[i].agePoint() + person[i].ticketPoint() + person[i].priorityPoint()
					+ person[i].specialNeedsPoint();
		return priority;
	}

	/**
	 * Metoda returneaza id.ul familiei
	 */
	@Override
	public String getId() {
		return person[0].id;
	}
}
