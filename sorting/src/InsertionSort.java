import java.util.Arrays;

public class InsertionSort {
    /**
     * We don't swap elements in insertion sort rather shift one by one.
     * @param arr : To be sorted.
     * @return : Sorted array.
     */
    private static int[] insertionSort(int[] arr) {
        //For the unsorted part.
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i ;
            //For the sorted part.
            // It moves unless i reaches to fist index and element at
            // position i-1 (previous element) is greater than the element to insert(newElement).
            for (i= firstUnsortedIndex; i > 0 && arr[i -1] > newElement; i--) {
                //Shift the element left by one.
                arr[i] = arr[i -1];
            }
            // When we drop out of the loop means we found the correct position to insert.
            arr[i] = newElement;
        }
        return arr;
    }

    private static void insertionSortRecursion(int[] arr, int numOfItems) {

        if (numOfItems < 2) {
            return ;
        }
        insertionSortRecursion(arr, numOfItems -1);
        int newElement  = arr[numOfItems - 1];
        int i;

        for (i = numOfItems - 1; i > 0 && arr[i -1] >newElement; i-- ) {
            arr[i] = arr[i -1];
        }
        arr[i] =  newElement;

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] arr) {
        int[] array = new int[]{20, 35, -15, 7, 55, 1, -22};
//        System.out.println(Arrays.toString(insertionSort(array)));
        insertionSortRecursion(array, 7);
    }
}
