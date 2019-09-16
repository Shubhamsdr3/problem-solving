public class MaximumSubArray {

    private static int findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i > low; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        return leftSum + rightSum;
    }

    static int maxSubArraySum(int arr[], int low, int high) {
        // Base Case: Only one element
        if (low == high)
            return arr[low];

        // Find middle point
        int mid = (low + high)/2;

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
        return Math.max(Math.max(maxSubArraySum(arr, low, mid),
                maxSubArraySum(arr, mid+1, high)),
                findMaxCrossingSubArray(arr, low, mid, high));
    }

    public static void main(String[] args)
    {
        int arr[] = {2, 3, 4, 5, 7, -6, 10, -12, -50, 45};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n-1);

        System.out.println("Maximum contiguous sum is "+
                max_sum);
    }

}
