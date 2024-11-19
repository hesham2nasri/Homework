import java.util.*;

/**
 * This class provides examples of sorting algorithms, including Quick Sort and Merge Sort.
 * It demonstrates the usage of these sorting methods on integer arrays.
 *
 * @author [Hesham Nasri ]
 * @version 1.1.2
 */
public class SortExample {

    /**
     * Main method to demonstrate sorting algorithms.
     *
     * @param args array elements from data type string
     */
    public static void main(String[] args) {
        // This is an unsorted array
        Integer[] array1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
        int array2[] = { 2, 6, 3, 5, 1 };

        // Sort using Quick Sort
        quickSort(array1, 0, array1.length - 1);
        // Verify sorted array
        System.out.println(Arrays.toString(array1));

        // Sort using Merge Sort
        mergeSort(array2, array2.length);
        // Verify sorted array
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     * Based on divided array
     * @param arr  the array to be sorted
     * @param low  the starting index
     * @param high the ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        // Check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // Make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            // Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Check until all values on right side array are greater than pivot
            while (arr[j] > pivot) {
                j--;
            }
            // Compare values from both sides and swap if necessary
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursively sort the two sub-arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in the array.
     * 
     * @param array from data type integear
     * @param x     the index of the first element
     * @param y     the index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param a the array to be sorted
     * @param n the size of the array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sub-arrays into a single sorted array.
     *
     * @param a     the original array
     * @param l     the left sub-array
     * @param r     the right sub-array
     * @param left  the size of the left sub-array
     * @param right the size of the right sub-array
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks if an array is sorted in ascending order.
     *
     * @param x the array to check
     * @return {@code 1} if the array is sorted, {@code 0} otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
