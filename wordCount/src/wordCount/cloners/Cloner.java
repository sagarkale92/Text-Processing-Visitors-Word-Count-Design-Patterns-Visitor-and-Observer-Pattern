package wordCount.cloners;

import wordCount.dsForStrings.Node;

/**
 * Clones node and sets observer and subject.
 * @author Sagar
 *
 */
public class Cloner implements Clonable{
	
	/**
	 * Clones node and sets observer and subject.
	 */
	public Node clone(Node node){
		Node cnode = node.myclone();
		cnode.setSub(node);
		node.registerObserver(cnode);
		return cnode;
	}
}