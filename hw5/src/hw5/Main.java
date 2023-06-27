package hw5;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        TreeBuilder obj = new TreeBuilder();

        // This method gets the name of the txt file as input, and then prints the tree.
        obj.displayTree( obj.buildTree("tree.txt") );

        // Stored the tree in a JTree variable for the test of search algorithms.
        JTree treeForSearch =  obj.buildTree("tree.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a string input to search: ");
        String searchValue = scanner.nextLine();

        System.out.println("Performing: Breadth First Search...");
        obj.BreadthFirstSearch(treeForSearch,searchValue);
        System.out.println("---------------------------------");

        System.out.println("Performing: Depth First Search...");
        obj.DepthFirstSearch(treeForSearch,searchValue);
        System.out.println("---------------------------------");

        System.out.println("Performing: Post Order Traversal Search...");
        obj.postOrderTraversal(treeForSearch,searchValue);
        System.out.println("---------------------------------");



    }
}

