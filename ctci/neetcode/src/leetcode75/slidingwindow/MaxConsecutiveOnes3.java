package leetcode75.slidingwindow;

public class MaxConsecutiveOnes3 {

    private static int longestOnes(int[] nums, int k) {
        int i = 0;
        int n =  nums.length;
        int maxCount = Integer.MIN_VALUE;
        int noOfZeroes = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) noOfZeroes++;

            // sliding to right direction.
            if (noOfZeroes > k) { // invalid solution
                if (nums[i] == 0) noOfZeroes--; // removed zero from window.
                i++;
            }

            if (noOfZeroes <=k) { // valid solution.
                maxCount = Math.max(maxCount, j - i + 1);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1,1,1,0,0,0,1,1,1,1,0 };
        int k = 2;
        System.out.println(longestOnes(arr, k));
    }
}

