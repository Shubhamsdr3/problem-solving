package easy;

public class MaximumProductOfThreeNumbers {

    private static int maximumProduct(int[] nums) {
        int i = 0;
        int product = Integer.MIN_VALUE;
        while (i < nums.length -2) {
            int res = nums[i] * nums[i+1] * nums[i +2];
            if (res > product) {
                product = res;
            }
            i++;
        }
        return product;
    }

    public static void main(String[] args) {
        int[] result = new int[]{-1,-2,-3};
        System.out.println(maximumProduct(result));
    }
}
