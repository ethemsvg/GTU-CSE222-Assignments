package hw7;

import java.util.Set;

/**
 * The BubbleSort class implements a bubble sort algorithm to sort a map.
 */
public class BubbleSort {

    // The original map to be sorted.
    protected myMap originalMap;
    // The sorted map
    protected myMap sortedMap;
    // Auxiliary array for storing the keys of the map as strings.
    protected String[] aux;

    /**
     * Constructs a BubbleSort object.
     * Initializes the sortedMap to an empty myMap object.
     */
    public BubbleSort() {
        this.originalMap = null;
        this.sortedMap = new myMap();
        this.aux = null;
    }

    /**
     * Sorts the given map using the bubble sort algorithm.
     *
     * @param newMap The map to be sorted.
     */
    protected void bubbleSort(myMap newMap) {
        this.originalMap = newMap;
        this.aux = new String[originalMap.map.size()];
        Set<String> tempSet = originalMap.map.keySet();
        int i = 0;
        for (String key : tempSet) {
            aux[i++] = key;
        }

        bubbleSortHelper(aux);
        for (int j = 0; j < aux.length; j++) {
            sortedMap.map.put(aux[j], originalMap.map.get(aux[j]));
        }
    }

    /**
     * Helper method for the bubble sort algorithm.
     * Sorts the keys array in ascending order of their associated values.
     *
     * @param keys The array of keys to be sorted.
     */
    private void bubbleSortHelper(String[] keys) {
        boolean swapOccurred = true;

        for (int i = 0; i < keys.length - 1; i++) {
            if (!swapOccurred) {
                return;
            }
            swapOccurred = false;
            // The range of the inner loop is length-1-i because the largest values are
            // already pushed to the end of the array, so we don't need to iterate over them again.
            for (int j = 0; j < keys.length - 1 - i; j++) {
                if (originalMap.map.get(keys[j]).count > originalMap.map.get(keys[j + 1]).count) {
                    // Swap keys[j+1] and keys[j]
                    String temp = keys[j];
                    keys[j] = keys[j + 1];
                    keys[j + 1] = temp;
                    swapOccurred = true;
                }
            }
        }
    }
}