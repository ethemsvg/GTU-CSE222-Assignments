package hw5;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class TreeBuilder {

    /**
     * Performs a post-order traversal of the specified JTree, starting from its root node,
     * and checks if the given value is found in any of its nodes.
     *
     * @param tree the JTree to be traversed
     * @param value the value to be searched for
     * @return true if the value is found, false otherwise
     */
    protected boolean postOrderTraversal(JTree tree, String value){
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
       // if(postOrderTraversalRecursive(root,value)==false){
          //  System.out.println("Not found: "+value);
          //  return false;
       // }
	return postOrderTraversalRecursive(root,value);
        //return true;
    }
    /**
     * Recursive helper method for the postOrderTraversal method. Traverses the given
     * DefaultMutableTreeNode in post-order, checks if the given value is found in any of
     * its nodes, and returns true if it is.
     *
     * @param node the node to be traversed
     * @param value the value to be searched for
     * @return true if the value is found, false otherwise
     */
    private boolean postOrderTraversalRecursive(DefaultMutableTreeNode node, String value) {

    // Check if the current node is not null
        if (node != null) {
            // Iterate over each child node of the current node
            for (int i = 0; i < node.getChildCount(); i++) {
                // Get the child node at the current index
                DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) node.getChildAt(i);

                // Recursively call the method on the child node
                postOrderTraversalRecursive(currentNode, value);
                // Print the current node being visited
                System.out.println( "Step -> " + currentNode.toString());
                // Check if the user object of the current node matches the target value
                if(currentNode.getUserObject().equals(value)){
                    // Return true and print success message
                    System.out.println("Found:  " + value);
		    		
                    return true;
                }

            }
        }
        return false;

    }
    /**
     * Performs a depth-first search of the specified JTree, starting from its root node,
     * and checks if the given value is found in any of its nodes.
     *
     * @param tree the JTree to be searched
     * @param value the value to be searched for
     * @return true if the value is found, false otherwise
     */
    protected boolean DepthFirstSearch(JTree tree, String value){
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();


        // create a stack to hold nodes to be visited, and a queue to hold visited nodes
        Stack<DefaultMutableTreeNode> toBeVisited = new Stack<>();
        Queue<DefaultMutableTreeNode> visitedNodes = new LinkedList<>();

        // add the root node to the stack
        toBeVisited.add(root);

        int stepCounter=1;

        while (!toBeVisited.isEmpty()) {
            // remove the top node from the stack
            DefaultMutableTreeNode currentNode = toBeVisited.pop();
            // add the node to the queue of visited nodes
            visitedNodes.add(currentNode);

            // print the node for debugging purposes
            System.out.println("Step " + stepCounter + " -> " + currentNode.toString());
            stepCounter++;

            // if the node contains the desired value, return true
            if (currentNode.getUserObject().equals(value)) {
                System.out.println("Found: " + value);
                return true;
            }

            // add any unvisited child nodes to the stack
            int childCount = currentNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                if (!visitedNodes.contains(childNode) && !toBeVisited.contains(childNode)) {
                    toBeVisited.add(childNode);
                }
            }
        }

        System.out.println("Not found: " + value);
        return false;

    }
    /**
     * Performs a breadth-first search of the specified JTree, starting from its root node,
     * and checks if the given value is found in any of its nodes.
     *
     * @param tree the JTree to be searched
     * @param value the value to be searched for
     * @return true if the value is found, false otherwise
     */
    protected boolean BreadthFirstSearch(JTree tree, String value){
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
    // Create queues to store nodes to be visited and already visited nodes
        Queue<DefaultMutableTreeNode> toBeVisited = new LinkedList<>();
        Queue<DefaultMutableTreeNode> visitedNodes = new LinkedList<>();
        // Add the root node to the "toBeVisited" queue

        toBeVisited.add(root);
        // Initialize a counter to keep track of the number of steps taken

        int stepCounter=1;
        // Continue the search until there are no more nodes to visit
        while (!toBeVisited.isEmpty()) {
            // Get the next node to visit from the "toBeVisited" queue
            DefaultMutableTreeNode currentNode = toBeVisited.remove();
            // Get the next node to visit from the "toBeVisited" queue
            visitedNodes.add(currentNode);
            System.out.println("Step " + stepCounter + " -> " + currentNode.toString());
            stepCounter++;
            // Check if the current node contains the value it's been searching for
            if (currentNode.getUserObject().equals(value)) {
                System.out.println("Found: " + value);
                return true;
            }
            // Add any unvisited child nodes to the "toBeVisited" queue
            int childCount = currentNode.getChildCount();
            for (int i = 0; i < childCount; i++) {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                if (!visitedNodes.contains(childNode) && !toBeVisited.contains(childNode)) {
                    toBeVisited.add(childNode);
                }
            }
        }

        System.out.println("Not found: " + value);
        return false;

    }
    /**

     Combines two subtrees of the same type and returns the root of the resulting combined tree.
     The output tree is free of duplicates.

     @param guest the subtree to be added to the host

     @param host the existing tree to which the guest subtree should be added

     @return the root node of the combined tree
     */
    protected DefaultMutableTreeNode treeCombiner(DefaultMutableTreeNode guest, DefaultMutableTreeNode host){

        DefaultMutableTreeNode tempHost = host;
        guest = (DefaultMutableTreeNode)guest.getFirstChild();

        boolean matchFound = true;
        // While the guest(the tree which'll be added to the main one), is not null, keep iterating.
        while( guest != null ){
            // marks the match found false
            matchFound = false;
            // Iterates over all the children of the current node.
            for(int i=0;i<tempHost.getChildCount();i++){
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) tempHost.getChildAt(i);
                // If any of the child nodes contains the same value with the other trees node at the same depth,
                // matchFound is marked true and the current nodes are switched one level deeper, and the process is
                // started again on that level until there is no match.
                if(childNode.getUserObject().equals(guest.getUserObject())){
                    tempHost = childNode;
                    guest = guest.getNextNode();
                    matchFound = true;
                    break;
                }
            }

            if(!matchFound){
                break;
            }

        }
        // When the matchFound is left false, (no match is found at that level), the guest node is added to
        // the host tree from that level.
        if(guest != null){
            tempHost.add(guest);
        }
        // the root of the host tree is returned.
        return (DefaultMutableTreeNode) host.getRoot();

    }
    /**

     Displays a JTree object in a new JFrame.
     @param tree The JTree object to be displayed.
     */
    protected void displayTree(JTree tree){
        // Simply displays the tree as a gui
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(tree));
        frame.pack();
        frame.setVisible(true);
    }
    /**

     Builds a JTree from a given file, where each row represents a sub-tree, and forms a meaningful tree
     by adding these subtrees to a root node.
     @param filename the name of the file to be read and parsed
     @return a JTree representing the meaningful tree formed from the sub-trees
     */
    protected JTree buildTree(String filename){

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        int NUM_OF_ROWS = fileRowCounter(filename);

        // The txt file is parsed and each element(string) is stored in a 2D array.
        String[][] elements = fileParser(filename);

        //First, we need to form trees from each row in the string. Then, we will add these trees on the root node,
        // forming a meaningful tree.

        LinkedList<DefaultMutableTreeNode> tinyTrees = new LinkedList<>();

        for(int i=0;i<NUM_OF_ROWS;i++){

            DefaultMutableTreeNode subRoot = new DefaultMutableTreeNode((String) elements[i][0]);
            DefaultMutableTreeNode tempRoot = subRoot;

            // forming the subtrees
            for(int j=1;j<elements[i].length;j++){
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode((String) elements[i][j]);
                tempRoot.add(newNode);
                if(j<elements[i].length - 1){
                    if(elements[i][j].charAt(0) != elements[i][j+1].charAt(0)){
                        tempRoot = newNode;
                    }
                }

            }

            // The tree is stored
            tinyTrees.add(subRoot);

        }

        int i=0;
        // Then, we iterate over the 2D array and try to combine each tree with the rest of the trees, to eliminate duplicates.
        for( i=0;i<tinyTrees.size();i++){

            for(int j=i+1;j<tinyTrees.size();j++){

                if( tinyTrees.get(i).getUserObject().equals(tinyTrees.get(j).getUserObject() )){
                    // If the root nodes of two subtrees are equal, they are combined. This also avoids
                    // the combination of distinct trees, since they are not combined but the method
                    // tries to combine them costing us process complexity.
                    DefaultMutableTreeNode temp = treeCombiner(tinyTrees.get(j),tinyTrees.get(i));
                    tinyTrees.set(i,temp);
                    tinyTrees.remove(j);
                    i--;

                }
            }
        }

        for( i=0;i<tinyTrees.size();i++){ // (changed size to size - 1 to eliminate addition of an empty node)
            root.add(tinyTrees.get(i));
        }

        return new JTree(root);
    }


    /**

     Parses a given file and returns its contents as a two-dimensional String array, where each
     row represents a line in the file and each column represents a field in the row separated by a semicolon.
     @param fileName the name of the file to be read and parsed
     @return a two-dimensional String array containing the contents of the file
     */
    protected String[][] fileParser(String fileName){
        // create a 2D String array to hold the file contents
        String[][] table = new String[fileRowCounter(fileName)][];
        try{
            // open the file and create a scanner to read it
            // iterate through each line of the file
            File fToRead = new File(fileName);
            Scanner fReader = new Scanner(fToRead);
            int i = 0;
            while ( fReader.hasNextLine() ) {
                // read the next line of the file and split it into an array of Strings
                String nLine = fReader.nextLine();
                String[] parsed = nLine.split(";");
                // add the parsed line to the table
                table[i] = parsed;
                i++;
                //System.out.println(nLine);
            }
            // close the file reader
            fReader.close();
        }catch (IOException exception){
            // handle any errors that occur while reading the file
            System.out.println("An error occured.");
            exception.printStackTrace();
        }

        // return the 2D array of Strings with the elements parsed.
        return table;
    }

    /**

     Returns the number of rows in the file with the given file name.
     @param fileName the name of the file to be counted
     @return the number of rows in the file, or -1 if an error occurs
     */
    protected int fileRowCounter(String fileName){

        // This method basically increments a counter value while reading the file line by line,
        // until the file is completely read. Then returns the number of rows.
        try{
            int i=0;
            File ft = new File(fileName);
            Scanner reader = new Scanner(ft);
            while(reader.hasNextLine()){
                i++;
                reader.nextLine();
            }
            reader.close();
            return i;

        }catch (IOException exception){
            System.out.println("An error occured.");
            exception.printStackTrace();
        }

        return -1;
    }


}
