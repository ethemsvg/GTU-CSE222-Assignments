package hw7;

import java.util.Set;

/**
 * This class implements the insertion sort algorithm for sorting a map.
 *
 */
public class InsertionSort {

    /**
     * The original map to be sorted.
     */
    protected myMap originalMap;

    /**
     * The sorted map
     */
    protected myMap sortedMap;

    /**
     * Auxillary array for storing the keys of the map as strings.
     */
    protected String[] aux;

    /**
     * Constructs a new instance of the `InsertionSort` class.
     */
    protected InsertionSort() {
        this.originalMap = null;
        this.sortedMap = new myMap();
        this.aux = null;
    }

    /**
     * Sorts the specified map using the insertion sort algorithm.
     *
     * @param newMap The map to be sorted.
     */
    protected void insertionSort(myMap newMap) {
        this.originalMap = newMap;
        this.aux = new String[originalMap.map.size()];
        Set<String> tempSet = originalMap.map.keySet();
        int i = 0;
        for (String key : tempSet) {
            aux[i++] = key;
        }

        insertionSortHelper(aux);
        for (int j = 0; j < aux.length; j++) {
            sortedMap.map.put(aux[j], originalMap.map.get(aux[j]));
        }
    }

    /**
     * Performs the insertion sort algorithm on the specified array of keys.
     *
     * @param keys The array of keys to be sorted.
     */
    private void insertionSortHelper(String[] keys) {
        for (int i = 1; i < keys.length; i++) {
            String temp = keys[i];
            int j = i - 1;

            while (j >= 0 && originalMap.map.get(keys[j]).count > originalMap.map.get(temp).count) {
                keys[j + 1] = keys[j];
                j--;
            }

            keys[j + 1] = temp;
        }
    }

}
