package wordCount.visitors;

import wordCount.dsForStrings.WordTreeI;

/**
 * Visitor interface with visit method.
 * @author Sagar
 *
 */
public interface Visitor {
	public void visit(WordTreeI wt);
}