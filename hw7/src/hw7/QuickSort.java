package hw7;

import java.util.Set;

/**
 * The QuickSort class implements a quicksort algorithm to sort a map.
 */
public class QuickSort {

    // The original map to be sorted.
    protected myMap originalMap;
    // The sorted map
    protected myMap sortedMap;
    // Auxiliary array for storing the keys of the map as strings.
    protected String[] aux;

    /**
     * Constructs a QuickSort object.
     * Initializes the sortedMap to an empty myMap object.
     */
    public QuickSort() {
        this.originalMap = null;
        this.sortedMap = new myMap();
        this.aux = null;
    }

    /**
     * Sorts the given map using the quicksort algorithm.
     *
     * @param newMap The map to be sorted.
     */
    protected void quickSort(myMap newMap) {
        this.originalMap = newMap;
        this.aux = new String[originalMap.map.size()];
        Set<String> tempSet = originalMap.map.keySet();
        int i = 0;
        for (String key : tempSet) {
            aux[i++] = key;
        }

        quickSortHelper(aux, 0, aux.length - 1);

        for (int j = 0; j < aux.length; j++) {
            sortedMap.map.put(aux[j], originalMap.map.get(aux[j]));
        }
    }

    /**
     * Helper method for the quicksort algorithm.
     * Recursively sorts the keys array between beg and end.
     *
     * @param keys The array of keys to be sorted.
     * @param beg  The starting index of the array segment to be sorted.
     * @param end  The ending index of the array segment to be sorted.
     */
    private void quickSortHelper(String[] keys, int beg, int end) {
        if (end <= beg) {
            return;
        }

        int pivot = partition(keys, beg, end);

        quickSortHelper(keys, beg, pivot - 1);
        quickSortHelper(keys, pivot + 1, end);
    }
    /**
     * Partitions the keys array based on the pivot element.
     * Elements smaller than the pivot are moved to the left,
     * and elements greater than the pivot are moved to the right.
     *
     * @param keys The array of keys to be partitioned.
     * @param beg  The starting index of the array segment to be partitioned.
     * @param end  The ending index of the array segment to be partitioned.
     * @return The index of the pivot element.
     */
    private int partition(String[] keys, int beg, int end){

        // Last element is picked as the pivot.
        int pivot =  originalMap.map.get(keys[end]).count;

        // Index of the tracker element.
        int i = (beg - 1);

        // Iterates over the values, if a value is smaller than the pivot, the tracker index is incremented by one
        // and the values are swapped (the tracker and the currently iterated element.).
        for (int j = beg; j <= end - 1; j++) {

            // If current element is smaller than the pivot
            if ( originalMap.map.get(keys[j]).count <= pivot) {

                // Increment index of tracker
                i++;
                // basic swap operation
                String temp= keys[i];
                keys[i] = keys[j];
                keys[j] = temp;


            }
        }
        // When the iteration is complete, put the pivot in it's correct place.
        String temp= keys[i+1];
        keys[i+1] = keys[end];
        keys[end] = temp;

        // And return the index of pivot. On the next recursive call in the quickSort method, the array will be
        // divided into 2 sub arrays by the index of the pivot this method returns.
        return (i + 1);


    }


}
