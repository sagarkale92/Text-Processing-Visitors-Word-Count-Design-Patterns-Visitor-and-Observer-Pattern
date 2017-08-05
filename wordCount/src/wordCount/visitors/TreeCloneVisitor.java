package wordCount.visitors;

import wordCount.cloners.Clonable;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.WordTreeI;
import wordCount.util.Logger;

/**
 * Clones tree to backup tree.
 * @author Sagar
 *
 */
public class TreeCloneVisitor implements Visitor{
	private WordTreeI wtbu;
	private Clonable cloner;
	
	/**
	 * Constructor.
	 * @param wtbuIn
	 * @param clonerIn
	 */
	public TreeCloneVisitor(WordTreeI wtbuIn, Clonable clonerIn){
		Logger.writeOutput("Constructor of TreeCloneVisitor class is called.", 2);
		wtbu = wtbuIn;
		cloner = clonerIn;
	}
	
	/**
	 * Passes root of the tree to function to traverse.
	 */
	@Override
	public void visit(WordTreeI wt) {
		Logger.writeOutput("visit function of Visitor TreeCloneVisitor is called.",3);
		nodeClone(wt.getRoot());
	}
	
	/**
	 * Traverse and clones each node to backup tree and sets observer.
	 * @param node
	 */
	private void nodeClone(Node node){
		if(node!=null){
			getWtbu().insert(cloner.clone(node));
			nodeClone(node.getLeft());
			nodeClone(node.getRight());
		}
	}

	public WordTreeI getWtbu() {
		return wtbu;
	}


	public void setWtbu(WordTreeI wtbu) {
		this.wtbu = wtbu;
	}

	public Clonable getCloner() {
		return cloner;
	}

	public void setCloner(Clonable cloner) {
		this.cloner = cloner;
	}

}
