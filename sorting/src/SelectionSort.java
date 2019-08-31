import java.util.Arrays;

public class SelectionSort {

    private static int[] selectionSort(int[] arr) {
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }
            Utils.swapElement(arr, largest, lastUnsortedIndex);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
}
