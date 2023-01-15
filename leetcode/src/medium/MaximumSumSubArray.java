package medium;

/**
 * Using Kadane's algorithm/
 */
public class MaximumSumSubArray {

    private static int maxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (maxSum < sum){
                maxSum = sum;
            }
            if (maxSum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{ -2, -1, -3, -4};
        System.out.println(maxSumSubArray(arr));
    }
}
