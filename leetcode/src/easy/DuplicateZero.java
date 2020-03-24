package easy;

import java.util.Arrays;

public class DuplicateZero {

    private static void duplicateZeros(int[] arr) {
        int i=0;
        while (i <= arr.length-2) {
            if (arr[i] == 0) {
                rightShift(arr, i+1);
                arr[i+1] = 0;
                i = i+2;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void rightShift(int[] arr, int start) {
        int i = arr.length-1;
        while (i >= start) {
            arr[i] = arr[i-1];
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        int[] arr1 = new int[]{1, 2, 3};
        duplicateZeros(arr1);
    }
}
