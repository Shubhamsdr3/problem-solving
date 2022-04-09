package easy.array;

import java.util.Arrays;

public class BuildArrayFromPermutation {

    private static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5,0,1,2,3,4};
        System.out.println(Arrays.toString(buildArray(input)));
    }
}
