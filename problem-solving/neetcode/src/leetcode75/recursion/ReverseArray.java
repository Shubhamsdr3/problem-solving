package leetcode75.recursion;

import java.util.Arrays;

public class ReverseArray {

    private static void reverseArray(int[] arr, int left, int right) {
        if (left >= right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverseArray(arr, left + 1, right -1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
