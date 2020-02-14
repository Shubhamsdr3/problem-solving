package easy;

public class ThirdMaximumNumber {

    private static int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int i=0; i <nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
            }
        }

        for (int i=0; i <nums.length; i++) {
            if (nums[i] > max2 && nums[i] < max1) {
                max2 = nums[i];
            }
        }

        for (int i=0; i < nums.length; i++) {
            if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }
        if (max3 == Long.MIN_VALUE) {
            return (int) max1;
        } else {
            return (int) max3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2, -2147483648};
        System.out.println(thirdMax(arr));
    }
}
