package problemsolving.leetcode75.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    private static int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    /**
     * T.C -> O(n^2)
     * @param nums
     * @param k
     * @return
     */
    private static int maxOperations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > 0 && nums[j] > 0) {
                    int sum = nums[i] + nums[j];
                    if (sum == k) {
                        count++;
                        nums[i] = -1;
                        nums[j] = -1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        int k = 5;

        int[] arr1 = new int[] { 3, 1, 3, 4, 3 };
        int k1 = 6;


        System.out.println(maxOperations2(arr1, k1));
    }
}
