package interviewprep;

import java.util.Arrays;

public class ZerosAndOnes {

    private static void shiftElements(int[] arr) {
        int count = 0;
        for (int val: arr) {
            if (val == 0) {
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (count  > 0) {
                arr[i] = 0;
                count--;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void shiftElementsMethod2(int[] arr) {
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int[] arr = new int[] {
                0, 1, 0, 1, 0, 0, 1, 1, 1, 0
        };
//        shiftElements(arr);
        shiftElementsMethod2(arr);
    }
}
