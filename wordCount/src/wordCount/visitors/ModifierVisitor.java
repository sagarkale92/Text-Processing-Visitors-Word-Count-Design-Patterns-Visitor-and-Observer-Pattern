package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.WordTreeI;
import wordCount.util.Logger;

/**
 * Modifies word count of each node in wordtree.
 * @author Sagar
 *
 */
public class ModifierVisitor implements Visitor{
	
	/**
	 * Modifies word count of each node in wordtree.
	 */
	@Override
	public void visit(WordTreeI wt) {
		Logger.writeOutput("visit function of Visitor ModifierVisitor is called.",3);
		modifier(wt.getRoot());
	}
	
	/**
	 * Traverse and modify word count of each node in word tree.
	 * @param n
	 */
	public void modifier(Node n){
		if(n!=null){
			modifier(n.getLeft());
			n.updateWordCount(2*n.getWordCount());
			modifier(n.getRight());
		}
	}
}
