

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Single extends Passenger {
	Single() {
	}

	/**
	 * Metoda initializeaza vectorul cu dimensiunea 1
	 * 
	 * @param p2 persoana single
	 */
	Single(Person p2) {
		super(1);
		person[0] = p2;
	}

	/**
	 * Metoda calculeaza prioritatea unei persoane
	 *
	 */
	@Override
	public int getPriority() {
		int priority = 0;
		priority = priority + person[0].agePoint() + person[0].ticketPoint() + person[0].priorityPoint()
				+ person[0].specialNeedsPoint();
		return priority;
	}

	/**
	 * Metoda returneaza id.ul unei persoane
	 */
	@Override
	public String getId() {
		return person[0].id;
	}

}
