package wordCount.driver;

import wordCount.cloners.Clonable;
import wordCount.cloners.Cloner;
import wordCount.dsForStrings.WordTree;
import wordCount.dsForStrings.WordTreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.TestClass;
import wordCount.visitors.BuildTreeVisitor;
import wordCount.visitors.ModifierVisitor;
import wordCount.visitors.TreeCloneVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

/**
 * This is Driver class to call visitors to build, traverse tree. 
 * @author Sagar
 *
 */
public class Driver {
	private String wordFile;
	private String outputFile;
	private int numLoops;
	private String wordTreeFile;
	private String wordTreeBuFile;
	private int debugValue;
	
	/**
	 * Main function to set parameters and call function to visitors. 
	 * @param args
	 */
	public static void main(String[] args){
		try{
		Driver driver = new Driver(); 
			if(!driver.validateArgs(args)){
				System.exit(0);
			}
			driver.setWordFile(args[0]);
			driver.setOutputFile(args[1]);
			driver.setNumLoops(Integer.parseInt(args[2]));
			driver.setWordTreeFile(args[3]);
			driver.setWordTreeBuFile(args[4]);
			driver.setDebugValue(Integer.parseInt(args[5]));
			driver.drive();
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Drive function to calculate time to build, traverse tree and clone. 
	 */
	public void drive(){
		try{
			new Logger(getDebugValue());
			FileProcessor fp = null;
			WordTreeI wt=null;
			WordTreeI wtbu=null;
			long startTime = System.currentTimeMillis();
			for(int i=0;i<getNumLoops();i++){
				fp = new FileProcessor(getWordFile(), getOutputFile());
				wt = new WordTree();
				Visitor buildTreeVisitor = new BuildTreeVisitor(fp);
				Visitor wordCountVisitor = new WordCountVisitor(fp);
				wt.accept(buildTreeVisitor);
				wt.accept(wordCountVisitor);
				fp.terminateInputFile();
				fp.terminateOutputFile();
			}
			long finishTime = System.currentTimeMillis();
			long totalTime = (finishTime-startTime)/getNumLoops();
			Logger.writeOutput("Time taken to build data structure and word count: "+totalTime+" milliseconds",1);
			wtbu = new WordTree();
			Clonable cloner = new Cloner(); 
			Visitor treeCloneVisitor = new TreeCloneVisitor(wtbu, cloner);
			wt.accept(treeCloneVisitor);
			Visitor modifierVisitor = new ModifierVisitor();
			wt.accept(modifierVisitor);
			TestClass tc = new TestClass();
			FileProcessor wtfp = new FileProcessor("", getWordTreeFile());
			tc.wtWriteToFile(wt.getRoot(), wtfp);
			wtfp.terminateOutputFile();
			FileProcessor wtbufp = new FileProcessor("", getWordTreeBuFile());
			tc.wtbuWriteToFile(wtbu.getRoot(), wtbufp);
			wtbufp.terminateOutputFile();
		}
		catch(NullPointerException e){
			e.printStackTrace();
			System.exit(-1);
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Validates input arguments.
	 * @param args
	 * @return boolean
	 */
	public boolean validateArgs(String[] args){
		if(args.length < 6){
			System.out.println("Invalid number of arguments passed.");
			return false;
		}
		return true;
	}

	public String getWordFile() {
		return wordFile;
	}

	public void setWordFile(String wordFile) {
		this.wordFile = wordFile;
	}

	public int getNumLoops() {
		return numLoops;
	}

	public void setNumLoops(int numLoops) {
		this.numLoops = numLoops;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public String getWordTreeFile() {
		return wordTreeFile;
	}

	public void setWordTreeFile(String wordTreeFile) {
		this.wordTreeFile = wordTreeFile;
	}

	public String getWordTreeBuFile() {
		return wordTreeBuFile;
	}

	public void setWordTreeBuFile(String wordTreeBuFile) {
		this.wordTreeBuFile = wordTreeBuFile;
	}

	public int getDebugValue() {
		return debugValue;
	}

	public void setDebugValue(int debugValue) {
		this.debugValue = debugValue;
	}
}
