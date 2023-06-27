package hw6;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 A class that implements merge sort algorithm for myMap objects.
 */
public class mergeSort {
    // The original map to be sorted.
    protected myMap originalMap;
    // The sorted map
    protected myMap sortedMap;
    // Auxillary array for storing the keys of the map as strings.
    protected String[] aux;

    /**
     * Constructor with no parameters.
     * Sets originalMap to null, sets the sortedMap to a new empty myMap object and sets the aux array to null.
     */
    public mergeSort()  {

        this.originalMap = null;
        this.sortedMap = new myMap();
        this.aux = null;

    }
    /**
     * Sorts the input map by the count values of the entries using the merge sort algorithm.
     * Puts the sorted key-value pairs in sortedMap.
     * @param newMap the myMap object to be sorted.
     */
    protected void mergeSort(myMap newMap){
        // Traverses the original map and puts the chars in it ordered ( uses merge sort to compare and sort the chars/strings (keys) according to their count values. ).
        // After that, iterates through this array and gets the related key-value pair from the original map and put it
        // in the sorted map. Since the aux array is sorted, the sortedMap will be filled with entries in
        // a sorted way.

        this.originalMap = newMap;
        this.aux = new String[originalMap.map.size()];
        Set<String> tempSet = originalMap.map.keySet();
        int i = 0;
        for (String key : tempSet) {
            aux[i++] = key;
        }

        mergeSortHelper(aux, 0, aux.length - 1);

        for (int j = 0; j < aux.length; j++) {
            sortedMap.map.put(aux[j], originalMap.map.get(aux[j]));
        }

    }

    /**
     * Recursively sorts an array of strings( letters as keys ) in accordance to the count values of the map entry related to the string/letter.
     * @param arr the array to be sorted.
     * @param start the starting index.
     * @param end the ending index.
     * @throws IllegalArgumentException if the input array is null or start or end indexes are out of bounds.
     */
    private void mergeSortHelper(String[] arr, int start, int end) throws IllegalArgumentException{

        if (arr == null) {
            throw new IllegalArgumentException("input array can not be null");
        }
        if (start < 0 || end >= arr.length) {
            throw new IllegalArgumentException("start and end indexes must be between the bounds of the array");
        }

        if(start < end){
            int mid = start + (end - start) / 2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr,mid + 1, end);
            merge(arr, start, mid, end);
        }


    }

    /**
     * Merges two sorted subarrays of an array.
     * @param arr the array to be merged.
     * @param start the starting index.
     * @param mid the middle index.
     * @param end the ending index.
     * @throws IllegalArgumentException if the input array is null or start or end indexes are out of bounds.
     */
    private void merge(String[] arr, int start, int mid, int end) throws IllegalArgumentException{

        if (arr == null) {
            throw new IllegalArgumentException("input array can not be null");
        }
        if (start < 0 || end >= arr.length) {
            throw new IllegalArgumentException("start and end indexes must be between the bounds of the array");
        }

        int i,j,k;
        int n1 = mid - start + 1;
        int n2 = end - mid;

        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        for( i=0;i<n1;i++){

            leftArr[i] = arr[start+i];

        }

        for( j=0; j < n2;j++){
            rightArr[j] = arr[mid + 1 + j];
        }

        i = 0;
        j = 0;
        k = start;

        while(i < n1 && j < n2){

            if( originalMap.map.get(leftArr[i]).count <=  originalMap.map.get(rightArr[j]).count ){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

    }




}
