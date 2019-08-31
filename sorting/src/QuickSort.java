import java.util.Arrays;

public class QuickSort {

    /**
     * There are two operation to be performed for Quick sort.
     * 1. Partitioning the array.
     * 2. Sorting the left and right sub-array.
     * (We don't need to merge here as this an in place algorithm and we don't temp array)
     * @param inputArr: To sort
     * @param start: The start end index of array.
     * @param end : The end index of the array.
     * @return : sorted array.
     */
    private static int[] quickSort(int[] inputArr, int start, int end) {

        // Base condition.
        if (end - start < 2) {
            return new int[]{};
        }
        // The left elements of this pivot index will be less than the pivot element.
        // and right to this pivot will be greater than the pivot.
        int pivotIndex = partition(inputArr, start, end);
        //For the left sub-array
        quickSort(inputArr, start, pivotIndex);
        //For the right sub-array
        quickSort(inputArr, pivotIndex +1, end);
        return inputArr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot  = arr[start];
        int i = start;
        int j = end;

        // If i and j has not crossed each other.
        while (i < j) {
            // From right to left.
            while (i < j && arr[--j] >= pivot);
            if (i < j) {
                arr[i] = arr[j];
            }
            // From left to right.
            while (i < j && arr[++i] <= pivot);
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 35, -15, 7, 55, -22};
        System.out.println(Arrays.toString(quickSort(array, 0, array.length)));
    }
}
