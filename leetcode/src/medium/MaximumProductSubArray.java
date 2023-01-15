package medium;

public class MaximumProductSubArray {

    private static int maxProduct(int[] nums) {
       int prod = 1;
       int result = Integer.MIN_VALUE;
       for (int i = 0; i < nums.length; i++) {
           prod = prod * nums[i];
           result = Math.max(prod, result);
           if (prod == 0) {
               prod = 1;
           }
       }
        prod = 1;
        for (int j = nums.length -1; j >= 0; j--) {
            prod = prod * nums[j];
            result = Math.max(prod, result);
            if (prod == 0) {
                prod = 1;
            }
        }
       return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-3, -1, -1};
        System.out.println(maxProduct(arr));
    }
}
