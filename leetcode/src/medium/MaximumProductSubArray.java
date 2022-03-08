package medium;

public class MaximumProductSubArray {

    private static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                val = val * nums[j];
                max = Math.max(val, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 5, 3,  -1, 7, 8
        };
        System.out.println(maxProduct(arr));
    }
}
