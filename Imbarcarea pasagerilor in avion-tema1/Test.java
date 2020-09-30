

import java.io.*;
import java.util.*;

/**
 * @author Savu Ioana Rusalda -325CB
 *
 */
public class Test {
	/**
	 * Metoda adauga persoane in HashTable
	 * 
	 * @param ht    HashTable
	 * @param key   cheia
	 * @param value valoare intodusa
	 */
	public static void put(Hashtable<String, List<Person>> ht, String key, Person value) {
		List<Person> list = ht.get(key);
		if (list == null) {
			list = new ArrayList<Person>();
			ht.put(key, list);
		}
		list.add(value);
	}

	/**
	 * In main se citesc persoanele din fisier si se adauga in HashTable Se citesc
	 * comenzile si se apeleaza metodele corespunzatoare
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int numberPersons;
		String name;
		int age;
		String ticket;
		boolean specialNeeds;
		boolean priorityEmbark;
		String id;
		int index = 0;
		int priority;
		Person[] passenger;
		Hashtable<String, List<Person>> h = new Hashtable<String, List<Person>>();
		PrintWriter writer = new PrintWriter("queue.out");// deschidere fisier output

		File file = new File("queue.in");// deschidere fisier input

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		numberPersons = Integer.parseInt(br.readLine());// initializare nr de persoane
		Queue q = new Queue(numberPersons, writer);
		/* citire persoane */
		while (index != numberPersons) {
			st = br.readLine();
			index++;
			String[] strArray = st.split(" ");
			id = strArray[0];
			name = strArray[1];
			age = Integer.parseInt(strArray[2]);
			ticket = strArray[3];
			priorityEmbark = Boolean.parseBoolean(strArray[4]);
			specialNeeds = Boolean.parseBoolean(strArray[5]);
			/* instantiere persoana */
			Person p = new Person(id, name, age, ticket, priorityEmbark, specialNeeds);
			put(h, id, p);// indroducere persoana in HashTable
		}
		/* citire comenzi */
		while ((st = br.readLine()) != null) {

			String[] strArray = st.split(" ");
			if (strArray.length != 1) {

				List<Person> list = h.get(strArray[1]);
				passenger = list.toArray(new Person[0]);

				if (strArray[1].charAt(0) == 'f') {
					/* instantiere familie */
					Passenger pa = new Family(passenger);
					priority = pa.getPriority();
					q.insert(pa, priority);
				}

				if (strArray[1].charAt(0) == 'g') {
					/* instantiere grup */
					Passenger pa = new Group(passenger);
					priority = pa.getPriority();
					q.insert(pa, priority);
				}

				if (strArray[1].charAt(0) == 's') {
					/* instantiere persoana single */
					Passenger pa = new Single(passenger[0]);
					priority = pa.getPriority();
					q.insert(pa, priority);
				}

			} else {
				if (strArray[0].equals("embark")) {
					/* imbarcare pasageri */
					q.embark();

				}
				if (strArray[0].equals("list")) {
					/* afisare coada prioritate */
					q.list();

				}
			}

		}
		writer.close();
		br.close();
	}

}
