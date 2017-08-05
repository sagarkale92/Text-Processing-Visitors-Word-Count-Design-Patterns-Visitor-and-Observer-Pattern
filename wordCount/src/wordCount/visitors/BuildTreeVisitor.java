package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.WordTreeI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * Builds Tree from file input. 
 * @author Sagar
 *
 */
public class BuildTreeVisitor implements Visitor{
	private FileProcessor fp;
	
	/**
	 * Constructor.
	 * @param fpIn
	 */
	public BuildTreeVisitor(FileProcessor fpIn){
		Logger.writeOutput("Constructor of BuildTreeVisitor class is called.", 2);
		setFp(fpIn);
	}
	
	/**
	 * Visit function to build tree from input.
	 */
	@Override
	public void visit(WordTreeI wt) {
		Logger.writeOutput("visit function of Visitor BuildTreeVisitor is called.",3);
		String line ="";
		while((line = fp.readLine())!=null){
			line = line.replaceAll("[^\\w\\s+]", "");
			String[] lineArray = line.split("\\s+");
			for(int i=0; i<lineArray.length; i++){
				if (!lineArray[i].isEmpty()){
					wt.insert(new Node(lineArray[i]));
				}
			}
		}
	}

	public FileProcessor getFp() {
		return fp;
	}

	public void setFp(FileProcessor fp) {
		this.fp = fp;
	}

}