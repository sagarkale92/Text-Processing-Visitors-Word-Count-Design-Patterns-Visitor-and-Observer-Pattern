package wordCount.cloners;

/**
 * Subject interface with methods to register, remove, notify observer and get word count.
 * @author Sagar
 *
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
	public int getWordCount();
}
