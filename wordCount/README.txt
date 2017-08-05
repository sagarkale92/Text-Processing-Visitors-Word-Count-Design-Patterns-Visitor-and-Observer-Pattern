CS542 Design Patterns
FALL 2016
ASSIGNMENT <ASSIGNMENT 4> README FILE

Due Date: <ASSIGNMENT DUE DATE,  Wednesday, November 23, 2016>
Submission Date: <DATE SUBMITED,  Wednesday, November 23, 2016>
Author(s): <Sagar Kale> 
e-mail(s): <skale4@binghamton.edu>

PURPOSE:
Implement Text Processing Visitors using visitor and oberver pattern.

PERCENT COMPLETE:
100%. (Generating wordtree.txt(Tree) and wordtreebu.txt(Backup Tree) files after modification to just original tree. Both files will have same content).

FILES:
Driver.java
FileProcessor.java
Logger.java
TestClass.java
WordTree.java
WordTreeI.java
Node.java
BuildTreeVisitor.java
ModifierVisitor.java
TreeCloneVisitor.java
WordCountVisitor.java
Visitor.java
Clonable.java
Cloner.java
Observer.java
Subject.java

SAMPLE OUTPUT:
For DebugValue = 1
Time taken to build data structure and word count: 12 milliseconds

For DebugValue = 2
Constructor of Logger class is called.
Constructor of FileProcessor class is called.
Constructor of FileProcessor class is called.
Constructor of FileProcessor class is called.
Constructor of BuildTreeVisitor class is called.
Constructor of WordCountVisitor class is called.
.
.

For DebugValue = 3
visit function of Visitor BuildTreeVisitor is called.
visit function of Visitor WordCountVisitor is called.
visit function of Visitor TreeCloneVisitor is called.
visit function of Visitor ModifierVisitor is called.

TO COMPILE: 
ant -buildfile src/build.xml all

TO RUN:
ant -buildfile src/build.xml run -Darg0=<INPUT_FILE> -Darg1=<OUTPUT_FILE> -Darg2=<NUM_ITERATIONS> -Darg3=<TREE_OUTPUTFILE> -Darg4=<TREEBCK_OUTPUTFILE> -Darg5=<DEBUG_VALUE>
Example:
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=wordtree.txt -Darg4=wordtreebu.txt -Darg5=1

TO CLEAN: 
ant -buildfile src/build.xml clean

DATA STRUCTURES USED:
Binary Search Tree:
	Worst case time complexity of BST is O(nlogn). The tree at any given point will be balanced. The data stored at each node has a distinguished key which is unique in the tree and belongs to a total order.