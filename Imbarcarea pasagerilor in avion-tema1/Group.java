

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Group extends Passenger {
	Group() {
	}

	/**
	 * Constructorul initializeaza vectorul cu membrii grupului
	 * 
	 * @param group vectorul ce contine membrii grupului
	 */
	Group(Person[] group) {
		super(group.length);
		for (int i = 0; i < group.length; i++)
			person[i] = group[i];
	}

	/**
	 * Metoda calculeaza prioritatea unui grup
	 */
	@Override
	public int getPriority() {
		int priority = 5;
		for (int i = 0; i < person.length; i++)
			priority = priority + person[i].agePoint() + person[i].ticketPoint() + person[i].priorityPoint()
					+ person[i].specialNeedsPoint();
		return priority;
	}

	/**
	 * Metoda returneaza id.ul grupului
	 */
	@Override
	public String getId() {
		return person[0].id;
	}

}
