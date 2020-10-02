
/**
 * @author Savu Ioana Rusalda - 325CB
 *
 */
public interface Observable {
	public void addObserver(Observer observer);

	public void notifyObserver(String newMsg);
}
