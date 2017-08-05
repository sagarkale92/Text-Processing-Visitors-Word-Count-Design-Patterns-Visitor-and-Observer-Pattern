package wordCount.dsForStrings;

import wordCount.cloners.Observer;
import wordCount.cloners.Subject;
import wordCount.util.Logger;

/**
 * Node class which is observer and subject both.
 * @author Sagar
 *
 */
public class Node implements Cloneable, Subject, Observer{
	private String word;
	private int wordCount;
	private Node left;
	private Node right;
	private Observer ob;
	private Subject sub;
	
	/**
	 * Constructor.
	 * @param wordIn
	 */
	public Node(String wordIn){
		Logger.writeOutput("Constructor of Node class is called.", 4);
		word = wordIn;
		wordCount = 1;
		left = null;
		right = null;
	}
	
	/**
	 * Register observer.
	 */
	@Override
	public void registerObserver(Observer o) {
		setOb(o);
	}

	/**
	 * Remove observer.
	 */
	@Override
	public void removeObserver(Observer o) {
		setOb(null);
	}

	/**
	 * Notify observer.
	 */
	@Override
	public void notifyObservers() {
		getOb().update();
	}
	
	/**
	 * Updates observer.
	 */
	@Override
	public void update() {
		this.setWordCount(this.getSub().getWordCount());
	}

	public Node myclone(){
		Node cnode=null;
		try{
			cnode = (Node)super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
		return cnode;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
	/**
	 * updates word count.
	 * @param wordCount
	 */
	public void updateWordCount(int wordCount) {
		this.wordCount = wordCount;
		notifyObservers();
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Checks which one is greater object.
	 * @param t2
	 * @return int
	 */
	public int compareTo(Node t2) {
		if(this.getWord().compareTo(t2.getWord()) < 0){
			return -1;
		}
		else if(this.getWord().compareTo(t2.getWord()) > 0){
			return 1;
		}
		else{
			return 0;
		}
	}

	public Observer getOb() {
		return ob;
	}

	public void setOb(Observer ob) {
		this.ob = ob;
	}
	
	public Subject getSub(){
		return sub;
	}

	@Override
	public void setSub(Subject sub) {
		this.sub = sub;
	}
}