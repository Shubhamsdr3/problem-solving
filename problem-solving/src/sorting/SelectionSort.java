package sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * get the minimum/maximum element index of array and
     * keep them swapping to their right position.
     * @param arr
     * T.C :
     *  Worst -> O(n2)
     *  best ->
     *
     */
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)  {
            int minValIndex = i;
            for (int j = i +1; j < arr.length; j++) {
                if (arr[j] < arr[minValIndex]) {
                    minValIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minValIndex];
            arr[minValIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                30, 10, 50, 20, 60, 40
        };
        selectionSort(arr);
    }
}
