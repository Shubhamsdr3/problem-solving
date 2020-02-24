package easy.data;

public class MaximumSubarray {

    //O(N) sliding window method
    private static int maxSubArray(int[] nums) {
        int i =0;
        int j = i+1;
        int max = Integer.MIN_VALUE;
        while (i < nums.length && j < nums.length) {
            int currentSum = sumOfArray(nums, i, j);
            if (currentSum > max) {
                max = currentSum;
                i = j;
            }
            j++;
        }
        return max;
    }

    private static int sumOfArray(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
