package org.vegan.algorithm;

import java.util.Arrays;
/**
 * Java program to implement insertion sort in Java. In this example, we will
 * sort an integer array using insertion sort algorithm. This logic can be used
 * to sort array of String, or any other object which implements Comparable or
 * Comparator interface in Java.
 * 
 * The insertion sort is usually faster than the traditional bubble sort, because the insertion sort requires fewer comparisons.
 * 
 * 
 * See http://javarevisited.blogspot.com/2014/12/insertion-sort-algorithm-in-java-to-array-example.html#ixzz42Px9Ymkg
 *
 * @author Javin Paul
 */
public class InsertionSortDemo {

    public static void main(String args[]) {
        // unsorted integer array
        int[] unsorted = {32, 23, 45, 87, 92, 31, 19};
        System.out.println("integer array before sorting : " + Arrays.toString(unsorted));
        insertionSort(unsorted);
        System.out.println("integer array after sorting  : " + Arrays.toString(unsorted));
    }


    /*
     * Sort integer array using Insertion sort algorithm.
     * only good for small array.
     */
    public static void insertionSort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) { // we can start at index 1, because we assume that index zero is already sorted.
            int j = i;
            
            //compare current value with the value in the right.
            //also shift to the right if/when necessary.
            while (j > 0 && unsorted[j] < unsorted[j - 1]) {  //while loop is necessary for shifting, and comparing if the two adjacent values are in proper sort order.
                //swap
                int temp = unsorted[j - 1];
                unsorted[j - 1] = unsorted[j];  // actual insertion.
                unsorted[j] = temp;  // actual shifting.
                j--;
            } // end while
            
        } // end for
    } // end insertionSort method.

}

