package interviewprep_23.design;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle means that every permutation of array element should be equally likely.
 * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm"></a>
 */
public class ShuffleAnArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        Solution sl = new Solution(arr);
        System.out.println(Arrays.toString(sl.shuffle()));
        System.out.println(Arrays.toString(sl.reset()));
    }
}


class Solution {

    private int[] arr;

    private Random random;

    public Solution(int[] nums) {
        this.arr = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return arr;
    }

    public int[] shuffle() {
        if (arr == null) return null;
        int[] nums = arr.clone();
        for (int j = 1; j < nums.length; j++) {
            int i = random.nextInt(j + 1);
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}