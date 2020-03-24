package easy;

public class ArrayPartition {

    private static int arrayPairSum(int[] nums) {
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int i =0;
        int j = nums.length -1;
        int maxSum = Integer.MIN_VALUE;
        while (i < j) {
            int min1 = Math.min(nums[i], nums[j]);
            int min2 = Math.min(nums[i+1], nums[j-1]);
            if (min1 + min2 > maxSum) {
                maxSum = min1 + min2;
            }
            i = i+2;
            j = j-2;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(arr));
    }
}
