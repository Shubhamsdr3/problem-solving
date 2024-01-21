package problemsolving.leetcode75.medium;

public class IncreasingTripletSubsequence {

    private static boolean increasingTriplet(int[] nums) {
        // if nums is less than 3.
        if (nums == null || nums.length < 3) return false;
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int n = nums.length;
        for (int idx = 0; idx < n; idx++) {
            if (nums[idx] <= i) {
                i = nums[idx];
            } else if (nums[idx] <= j) {
                j = nums[idx];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2,1,5,0,4,6 };
        int[] nums1 = new int[] {1, 2};
        System.out.println(increasingTriplet(nums));
    }
}
