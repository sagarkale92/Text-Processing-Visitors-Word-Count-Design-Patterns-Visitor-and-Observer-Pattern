package wordCount.cloners;

import wordCount.dsForStrings.Node;

/**
 * Clonable interface with clone method to clone node.
 * @author Sagar
 *
 */
public interface Clonable {
	public Node clone(Node node);
}
