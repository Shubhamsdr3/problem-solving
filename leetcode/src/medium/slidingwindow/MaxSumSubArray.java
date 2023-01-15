package medium.slidingwindow;

public class MaxSumSubArray {

    /**
     * Calculate the maximum sum of 'k' consecutive elements in the array.
     * @param arr
     * @param k
     * @return
     */
    private static int findMaxSumSubArray(int[] arr, int k) {
        // compute the first window of size k.
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + arr[i];
        }
        // compute the remaining window by removing the
        // first element and adding the last element
        int windowSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 5, 2, -1, 0, 3 };
        int k = 3;
        System.out.println(findMaxSumSubArray(arr, k));
    }
}
