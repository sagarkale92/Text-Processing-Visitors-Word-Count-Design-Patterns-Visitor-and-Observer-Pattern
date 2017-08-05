package wordCount.dsForStrings;

import java.util.Comparator;

import wordCount.util.Logger;
import wordCount.visitors.Visitor;

/**
 * WordTree class with insert, compare, search methods.
 * @author Sagar
 *
 */
public class WordTree implements WordTreeI{
	private Node root;
	private Comparator<Node> comparator;
	
	/**
	 * Constructor
	 */
	public WordTree(){
		Logger.writeOutput("Constructor of WordTree class is called.", 4);
		root = null;
		comparator = null;
	}
	
	/**
	 * Constructor
	 * @param comparatorIn
	 */
	public WordTree(Comparator<Node> comparatorIn){
		root = null;
		comparator = comparatorIn;
	}
	
	/**
	 * Compares two objects.
	 * @param t1
	 * @param t2
	 * @return int
	 */
	private int compare(Node t1, Node t2){
		if(getComparator()==null){
			return t1.compareTo(t2);
		}
		else{
			return comparator.compare(t1, t2);
		}
	}
	
	/**
	 * Inserts node to tree.
	 */
	public void insert(Node t){
		root = insert(root, t);
	}
	
	/**
	 * Inserts node to tree.
	 * @param t
	 * @param tIn
	 * @return Node
	 */
	private Node insert(Node t, Node tIn){
		if(t==null){
			return tIn;
		}
		if(compare(tIn, t) < 0){
			t.setLeft(insert(t.getLeft(), tIn));
		}
		else if(compare(tIn, t) > 0){
			t.setRight(insert(t.getRight(), tIn));
		}
		else{
			t.setWordCount(t.getWordCount()+tIn.getWordCount());
		}
		return t;
	}
	
	/**
	 * In order traversal.
	 */
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	
	/**
	 * In order traversal.
	 * @param n
	 */
	private void inOrderTraversal(Node n){
		if(n!=null){
			System.out.println(n.getWord()+" "+n.getWordCount());
			inOrderTraversal(n.getLeft());
			inOrderTraversal(n.getRight());
		}
	}
	
	/**
	 * Pre Order traversal.
	 */
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}
	
	/**
	 * Pre Order traversal.
	 * @param n
	 */
	private void preOrderTraversal(Node n){
		if(n!=null){
			preOrderTraversal(n.getLeft());
			System.out.println(n.getWord()+" "+n.getWordCount());
			preOrderTraversal(n.getRight());
		}
	}
	
	/**
	 * Accept method for visitor.
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Comparator<Node> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<Node> comparator) {
		this.comparator = comparator;
	}	
}