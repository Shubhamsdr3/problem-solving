package sortingproblems;

public class InsertionSort2 {

    private static void insertionSort2(int n, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j;
            for(j = i; j > 0 && arr[j -1] > element; j --) {
                arr[j] = arr[j -1];
            }
            arr[j] = element;
            printArray(arr);
        }
    }

    private static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i;
            while(j > 0 && A[j -1] > value){
                A[j] = A[j - 1];
                j = j - 1;
            }
            A[j] = value;
        }
        printArray(A);
    }

    private static int runningTime(int[] arr) {
        int shifts = 0;
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j- 1] > element) {
                    shifts ++;
                }
            }
            arr[j] = element;
        }
        return shifts;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] input = new int[]{7, 4, 3, 5, 6, 2};
//        insertionSort(input);

        int[] arr = new int[]{2, 1, 3, 1, 2};
        System.out.println(runningTime(arr));
    }
}
