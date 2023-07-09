package interviewprep_23.array;

import java.util.Arrays;

public class SortAllEvenNumberAndOddNumbers {

    // first odd then even
    private static int[] twoWaySort(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) { // if number is even.
                arr[end--] = nums[i];
                int temp = end;
                while (temp + 1 < n) {
                    if (arr[temp] > arr[temp + 1]) {
                        int val = arr[temp + 1];
                        arr[temp + 1] = arr[temp];
                        arr[temp] = val;
                    }
                    temp++;
                }
            } else { // if number is odd.
                arr[start++] = nums[i];
                int temp = start;
                while (temp - 1 >= 0) {
                    if (arr[temp] > arr[temp - 1]) {
                        int val = arr[temp - 1];
                        arr[temp - 1] = arr[temp];
                        arr[temp] = val;
                    }
                    temp--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 5, 4, 7, 10};
        int[] arr1 = new int[] {0, 4, 5, 3, 7, 2, 1 };
        System.out.println(Arrays.toString(twoWaySort(arr)));
        System.out.println(Arrays.toString(twoWaySort(arr1)));
    }
}
