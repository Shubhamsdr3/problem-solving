package medium.prefixsum;

public class SubArraySumsDivisibleByK {

    /**
     * Using prefix sum
     * prefixSum[j] - prefixSum[i] % k == 0
     * @param nums
     * @param k
     * @return
     */
    private static int subArrayDivByKUsingPrefixSum(int[] nums, int k) {
        return 0;
    }

    /**
     * Brute force approach.
     * @param nums
     * @param k
     * @return
     */
    private static int subarrayDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum % k == 0) count++;
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum % k == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarrayDivByK(arr, k));
    }
}
