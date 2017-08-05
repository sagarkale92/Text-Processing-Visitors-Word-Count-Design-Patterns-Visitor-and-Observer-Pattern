package wordCount.dsForStrings;

import wordCount.visitors.Visitor;

/**
 * WordTree interface with accept methods.
 * @author Sagar
 *
 */
public interface WordTreeI{
	public void accept(Visitor visitor);
	public void insert(Node t);
	public void inOrderTraversal();
	public void preOrderTraversal();
	public Node getRoot();
}
