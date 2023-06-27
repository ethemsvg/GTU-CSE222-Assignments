package hw7;

public class Main {
    public static void main(String[] args) {


        //String test1 = "Buzzing bees buzz.";
        String worstCase = "Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z X X X X X X X X X Y Y Y Y Y Y Y Y Y Y Y L L L L L L L L L L L L L K K K K K K M M M M M M N N N N N I I I I I I J J J J J J L L L L S S S S F F F F C C C C C E E E E D D D B B B A A";
        String bestCase = "A B B C C C D D D D E E E E E F F F F F F G G G G G G G H H H H H H H H I I I I I I I I I J J J J J J J J J J K K K K K K K K K K K K";
        String avgCase = "A B B C C C D D D D E E E E E F F F F F F G G G G G G G H H H H H H H H K K K K K K K K K K K K J J J J J J J J J J I I I I I I I I I";


        // Creating multiple maps with the same user string to prevent sending an already sorted map to the other sorting methods.
        myMap avgMap1 = new myMap(avgCase);
        myMap avgMap2 = new myMap(avgCase);
        myMap avgMap3 = new myMap(avgCase);
        myMap avgMap4 = new myMap(avgCase);
        myMap avgMap5 = new myMap(avgCase);

        System.out.println(" ~~~~~~~~~~~~~~~~~~~ AVERAGE CASE TESTS ~~~~~~~~~~~~~~~~~~~~ \n");

        System.out.println("Original string: \t" + avgCase);
        System.out.println("Preprocessed string: \t"+ avgMap1.preProcessString(avgCase));

        System.out.print("\n");

        System.out.println("Original Map:");
        avgMap1.printMap();


        long startTime = System.nanoTime();

        BubbleSort obj1 = new BubbleSort();

        obj1.bubbleSort(avgMap1);

        System.out.println("\n Sorted by bubble sort:");

        obj1.sortedMap.printMap();

        long endTime = System.nanoTime();

        System.out.println("BubbleSort Elapsed Time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        InsertionSort obj2 = new InsertionSort();

        obj2.insertionSort(avgMap2);

        System.out.println("Sorted by insertion sort:");

        obj2.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("InsertionSort Elapsed time: " + (endTime - startTime) / 1000 + "\n");



        startTime = System.nanoTime();

        mergeSort obj3 = new mergeSort();

        obj3.mergeSort(avgMap3);

        System.out.println("Sorted by merge sort:");

        obj3.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("MergeSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        QuickSort obj4 = new QuickSort();

        obj4.quickSort(avgMap4);

        System.out.println("Sorted by quick sort:");

        obj4.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("QuickSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        SelectionSort obj5 = new SelectionSort();

        obj5.selectionSort(avgMap5);

        System.out.println("Sorted by selection sort:");

        obj5.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("SelectionSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");






        System.out.println(" ~~~~~~~~~~~~~~~~~~~ BEST CASE TESTS ~~~~~~~~~~~~~~~~~~~~ \n");

        // Creating multiple maps with the same user string to prevent sending an already sorted map to the other sorting methods.
        myMap bestMap1 = new myMap(bestCase);
        myMap bestMap2 = new myMap(bestCase);
        myMap bestMap3 = new myMap(bestCase);
        myMap bestMap4 = new myMap(bestCase);
        myMap bestMap5 = new myMap(bestCase);

        System.out.println("Original string: \t" + bestCase);
        System.out.println("Preprocessed string: \t"+ bestMap1.preProcessString(bestCase));

        System.out.print("\n");

        System.out.println("Original Map:");
        bestMap1.printMap();


        startTime = System.nanoTime();

        BubbleSort obj6 = new BubbleSort();

        obj6.bubbleSort(bestMap1);

        System.out.println("\n Sorted by bubble sort:");

        obj6.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("BubbleSort Elapsed Time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        InsertionSort obj7 = new InsertionSort();

        obj7.insertionSort(bestMap2);

        System.out.println("Sorted by insertion sort:");

        obj7.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("InsertionSort Elapsed time: " + (endTime - startTime) / 1000 + "\n");



        startTime = System.nanoTime();

        mergeSort obj8 = new mergeSort();

        obj8.mergeSort(bestMap3);

        System.out.println("Sorted by merge sort:");

        obj8.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("MergeSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        QuickSort obj9 = new QuickSort();

        obj9.quickSort(bestMap4);

        System.out.println("Sorted by quick sort:");

        obj9.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("QuickSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        SelectionSort obj10 = new SelectionSort();

        obj10.selectionSort(bestMap5);

        System.out.println("Sorted by selection sort:");

        obj10.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("SelectionSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");







        System.out.println(" ~~~~~~~~~~~~~~~~~~~ WORST CASE TESTS ~~~~~~~~~~~~~~~~~~~~ \n");

        // Creating multiple maps with the same user string to prevent sending an already sorted map to the other sorting methods.
        myMap worstMap1 = new myMap(worstCase);
        myMap worstMap2 = new myMap(worstCase);
        myMap worstMap3 = new myMap(worstCase);
        myMap worstMap4 = new myMap(worstCase);
        myMap worstMap5 = new myMap(worstCase);

        System.out.println("Original string: \t" + worstCase);
        System.out.println("Preprocessed string: \t"+ worstMap1.preProcessString(worstCase));

        System.out.print("\n");

        System.out.println("Original Map:");
        worstMap1.printMap();


        startTime = System.nanoTime();

        BubbleSort obj11 = new BubbleSort();

        obj11.bubbleSort(worstMap1);

        System.out.println("\n Sorted by bubble sort:");

        obj11.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("BubbleSort Elapsed Time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        InsertionSort obj12 = new InsertionSort();

        obj12.insertionSort(worstMap2);

        System.out.println("Sorted by insertion sort:");

        obj12.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("InsertionSort Elapsed time: " + (endTime - startTime) / 1000 + "\n");



        startTime = System.nanoTime();

        mergeSort obj13 = new mergeSort();

        obj13.mergeSort(worstMap3);

        System.out.println("Sorted by merge sort:");

        obj13.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("MergeSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        QuickSort obj14 = new QuickSort();

        obj14.quickSort(worstMap4);

        System.out.println("Sorted by quick sort:");

        obj14.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("QuickSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");



        startTime = System.nanoTime();

        SelectionSort obj15 = new SelectionSort();

        obj15.selectionSort(worstMap5);

        System.out.println("Sorted by selection sort:");

        obj15.sortedMap.printMap();

        endTime = System.nanoTime();

        System.out.println("SelectionSort Elapsed time: " + (endTime - startTime) / 1000  + "\n");





        System.exit(0);



    }
}
