package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros {

    //using extra space
    private static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        int index = 0;
        for (int item: list) {
            nums[index] = item;
            index++;
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
        System.out.println(Arrays.toString(nums));
    }

    // In place without using any extra space
    private static void moveZeroes1(int[] nums) {
        int index = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes1(arr);
    }
}
