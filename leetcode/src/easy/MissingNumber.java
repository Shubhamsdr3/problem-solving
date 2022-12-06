package easy;

import java.util.Arrays;

public class MissingNumber {

    private static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums[nums.length-1]; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums[nums.length-1] + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1};
        int[] array1 = new int[]{0};
        System.out.println(missingNumber(array));
        System.out.println(missingNumber(array1));
    }
}
