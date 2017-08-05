package wordCount.util;

import wordCount.dsForStrings.Node;

public class TestClass {
	
	/**
	 * Write data structure to file after modification.
	 * @param n
	 * @param wtfp
	 */
	public void wtWriteToFile(Node n, FileProcessor wtfp){
		if(n!=null){
			wtWriteToFile(n.getLeft(), wtfp);
			wtfp.writeLine(n.getWord()+": "+n.getWordCount()+"\n");
			wtWriteToFile(n.getRight(), wtfp);
		}
	}
	
	/**
	 * Write backup of data structure to file.
	 * @param n
	 * @param wtbufp
	 */
	public void wtbuWriteToFile(Node n, FileProcessor wtbufp){
		if(n!=null){
			wtbuWriteToFile(n.getLeft(), wtbufp);
			wtbufp.writeLine(n.getWord()+": "+n.getWordCount()+"\n");
			wtbuWriteToFile(n.getRight(), wtbufp);
		}
	}
}
