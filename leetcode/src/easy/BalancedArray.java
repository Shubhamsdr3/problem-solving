package easy;

public class BalancedArray {

    private static int balanceArray(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum + arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) leftSum += arr[i -1];
            int diff = totalSum - leftSum - arr[i];
            if (diff == leftSum) {
                return i;
            }
            leftSum = leftSum + arr[i];
        }
        return -1;
    }

    private static int pivotIndex(int[] nums) {
        int total = 0;
        int sum = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum * 2 == total + nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                1,7,3,6,5,6
        };
        System.out.println(pivotIndex(arr));
    }
}
