package interviewprep_23.kadenesalgorithm;

public class LargestSumContiguousSubArray {

    private static int maxSubArraySum(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            currentMax = currentMax + nums[i];
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubArraySum(arr));
    }
}
