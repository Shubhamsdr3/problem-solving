package easy;

public class MaximumSubarray {

    private static int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int localSum = nums[i];
            if(localSum > sum) {
                sum = localSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                 localSum = localSum + nums[j];
                if (localSum > sum) {
                    sum = localSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1};
        System.out.println(maxSubArray(arr));
    }
}
