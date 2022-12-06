package medium;


import java.util.Arrays;
import java.util.Stack;

/**
 * Based on pivot and partition.
 * Choosing pivot:
 *  1. random
 *  2. median
 *  3. first element.
 *  4. Last element
 *
 *  Time complexity:
 *      Worst case: O(n^2)
 *      Avg: O(nlogn)
 *
 *  Space complexity: Space used in recursive stack.
 *      Worst case: O(n)
 *      Avg case: O(logn)
 *
 * Note: Worst case occurs when pivot is always the smallest or largest element.
 */
public class QuickSort {

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Pivot: the last element.
     * @param arr
     * @param low
     * @param high
     * @return : pivto index
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap..sort the elements lesser than pivot
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        // moves the pivot element at it's right position
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    private static void quickSortIterative(int[] arr, int low, int high) {
        Stack<Pair> stack = new Stack<>();
        int start = 0;
        int end = arr.length -1;
        stack.push(new Pair(start, end));
        while (!stack.isEmpty()) {
            start = stack.peek().first;
            end = stack.peek().second;
            stack.pop();
            int pivot = partition(arr, start, end);
            if (pivot -1 > start) {
                stack.push(new Pair(start, pivot -1));
            }
            if (pivot + 1 < end) {
                stack.push(new Pair(pivot + 1, end));
            }
        }
    }

    static class Pair {

        private final int first;
        private final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        quickSortIterative(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
