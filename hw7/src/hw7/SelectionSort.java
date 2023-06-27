package hw7;

import java.util.Set;

/**
 * The SelectionSort class implements a selection sort algorithm to sort a map.
 */
public class SelectionSort {

    // The original map to be sorted.
    protected myMap originalMap;
    // The sorted map
    protected myMap sortedMap;
    // Auxiliary array for storing the keys of the map as strings.
    protected String[] aux;

    /**
     * Constructs a SelectionSort object.
     * Initializes the sortedMap to an empty myMap object.
     */
    protected SelectionSort() {
        this.originalMap = null;
        this.sortedMap = new myMap();
        this.aux = null;
    }

    /**
     * Sorts the given map using the selection sort algorithm.
     *
     * @param newMap The myMap object to be sorted.
     */
    protected void selectionSort(myMap newMap) {
        this.originalMap = newMap;
        this.aux = new String[originalMap.map.size()];
        Set<String> tempSet = originalMap.map.keySet();
        int i = 0;
        for (String key : tempSet) {
            aux[i++] = key;
        }

        selectionSortHelper(aux);
        for (int j = 0; j < aux.length; j++) {
            sortedMap.map.put(aux[j], originalMap.map.get(aux[j]));
        }
    }

    /**
     * Helper method for the selection sort algorithm.
     * Sorts the keys array in ascending order of their associated values.
     *
     * @param keys The array of keys to be sorted.
     */
    private void selectionSortHelper(String[] keys) {
        int minIndex = 0;

        for (int i = 0; i < keys.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < keys.length; j++) {
                if (originalMap.map.get(keys[j]).count < originalMap.map.get(keys[minIndex]).count) {
                    minIndex = j;
                }
            }
            // Swap operation
            String temp = keys[i];
            keys[i] = keys[minIndex];
            keys[minIndex] = temp;
        }
    }
}