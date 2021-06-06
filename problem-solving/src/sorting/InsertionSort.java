package sorting;

import java.util.Arrays;

public class InsertionSort {

    /**
     * divide the array in sorted and unsorted and pick element
     * from unsorted array one by one and move them to sorted array.
     * no swapping required.
     * @param arr: given array
     */
    private static void insertionSort(int[] arr) {
        for (int i =1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;
            while (j > 0 && current < arr[j -1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                30, 10, 50, 20, 60, 40
        };
        insertionSort(arr);
    }
}
