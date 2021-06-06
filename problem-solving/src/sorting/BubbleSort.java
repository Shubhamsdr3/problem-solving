package sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSort(int[] arr) {
        for (int i =0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                3, 2, 9, 4, 2, 5, 7, 1, 7
        };
        bubbleSort(input);
    }
}
