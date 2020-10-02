import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public class Interval {
	SortedSet <Double>  set;
	SortedSet <Double>  setH;
	
	/**
	 * constructor default
	 */
	Interval(){
		this.set = new TreeSet <Double>(); 
		this.setH = new TreeSet <Double>(); 
		
	}
	/**
	 * Metoda adauga temperatura inregistrata in intervalul corespunzator
	 * @param temp - temperatura inregistrata
	 */
	public void  adaugT(Double temp) {
		set.add(temp);  
	}
	/**
	 * Metoda adauga umiditatea inregistrata in intervalul corespunzator
	 * @param humidity - umiditatea inregistrata
	 */
	public void  adaugH(Double humidity) {
		setH.add(humidity);  
	}

}
