package wordCount.cloners;

/**
 * Observer interface with update and setSub methods.
 * @author Sagar
 *
 */
public interface Observer {
	public void update();
	public void setSub(Subject sub);
}
