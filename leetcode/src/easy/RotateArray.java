package easy;

import java.util.Arrays;

public class RotateArray {

    private static void rotate(int[] nums, int k) {
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length -1; i > 0; i--) {
                nums[i] = nums[i -1];
            }
            nums[0] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k =3;
        rotate(arr, k);
    }
}
