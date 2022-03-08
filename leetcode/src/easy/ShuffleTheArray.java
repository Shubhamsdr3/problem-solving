package easy;

import java.util.Arrays;

public class ShuffleTheArray {

    private static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index] = nums[i];
            index = index +2;
        }
        index = 1;
        for (int i = n; i < nums.length; i++) {
            res[index] = nums[i];
            index = index + 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2};
        System.out.println(Arrays.toString(shuffle(arr, 2)));
    }
}
