package leetcode75.slidingwindow;

public class LongestSubArrayOfOneDeletingOne {

    private static int longestSubArray(int[] nums) {
        int i = 0;
        int noOfZeroes = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) noOfZeroes++;
            if (noOfZeroes > 1) {
                if (nums[i] == 0) noOfZeroes--;
                i++;
            }
            if (noOfZeroes <= 1) {
                maxCount = Math.max(maxCount, j - i);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0,1,1,1,0,1,1,0,1 };
        int[] arr1 = new int[] {1, 1, 0, 1};
        int[] arr2 = new int[] {1, 1, 1};
        System.out.println(longestSubArray(arr2));
    }
}
