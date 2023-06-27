package hw6;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //String test2 = "'Hush, hush!' whispered the rushing wind.";
        //String test1 = "Buzzing bees buzz.";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String userInputString = scanner.nextLine() ;
        System.out.print("\n");

        myMap testMap = new myMap(userInputString);

        System.out.println("Original string: \t" + userInputString);
        System.out.println("Preprocessed string: \t"+ testMap.preProcessString(userInputString));

        System.out.print("\n");

        System.out.println("Original Map:");
        testMap.printMap();

        System.out.print("\n");

        mergeSort obj1 = new mergeSort();
        obj1.mergeSort(testMap);

        System.out.println("Sorted Map:");

        obj1.sortedMap.printMap();

        System.exit(0);



    }
}