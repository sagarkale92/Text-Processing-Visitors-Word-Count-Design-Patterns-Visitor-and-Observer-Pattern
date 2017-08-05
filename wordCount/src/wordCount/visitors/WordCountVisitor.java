package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.WordTreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * Count words, distinct words and characters from word tree.
 * @author Sagar
 *
 */
public class WordCountVisitor implements Visitor{
	private FileProcessor fp;
	private int wordcount;
	private int dwordcount;
	private int charcount;
	
	/**
	 * Constructor.
	 * @param fpIn
	 */
	public WordCountVisitor(FileProcessor fpIn){
		Logger.writeOutput("Constructor of WordCountVisitor class is called.", 2);
		setFp(fpIn);
	}
	
	/**
	 * Passes root to function and write words, distinct words and characters to the file.
	 */
	@Override
	public void visit(WordTreeI wt) {
		Logger.writeOutput("visit function of Visitor WordCountVisitor is called.",3);
		wordCount(wt.getRoot());
		fp.writeLine("Total words: "+getDwordcount()+"\n");
		fp.writeLine("Distinct Words: "+getWordcount()+"\n");
		fp.writeLine("Characters: "+getCharcount());
	}
	
	/**
	 * Traverse word tree to calculate total words, distinct words and characters.
	 * @param n
	 */
	private void wordCount(Node n){
		if(n!=null){
			wordCount(n.getLeft());
			//System.out.println("Word: "+n.getWord()+" WordCount: "+n.getWordCount());
			setWordcount(getWordcount()+1);
			setCharcount(getCharcount()+n.getWord().length()*n.getWordCount());
			setDwordcount(getDwordcount()+n.getWordCount());
			wordCount(n.getRight());
		}
	}

	public FileProcessor getFp() {
		return fp;
	}

	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}

	public int getWordcount() {
		return wordcount;
	}

	public void setWordcount(int wordcount) {
		this.wordcount = wordcount;
	}

	public int getDwordcount() {
		return dwordcount;
	}

	public void setDwordcount(int dwordcount) {
		this.dwordcount = dwordcount;
	}

	public int getCharcount() {
		return charcount;
	}

	public void setCharcount(int charcount) {
		this.charcount = charcount;
	}
}
