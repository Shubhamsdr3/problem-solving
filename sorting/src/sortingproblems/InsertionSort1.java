package sortingproblems;

public class InsertionSort1 {

    private static void insertionSort1(int n, int[] arr) {
        int temp = arr[n - 1];
        for (int i = n -2; i >= 0; i--) {
            if (arr[i] > temp) {
                arr[i + 1] = arr[i];
                if (i == 0){
                    arr[i] = temp;
                    printArray(arr);
                    break;
                }
            } else {
                arr[i + 1] = temp;
                printArray(arr);
                break;
            }
            printArray(arr);
        }
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
        insertionSort1(10, inputArray);
    }
}
