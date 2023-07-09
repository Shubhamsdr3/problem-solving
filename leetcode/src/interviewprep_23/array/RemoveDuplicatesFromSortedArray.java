package interviewprep_23.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicatesMedium(int[] nums) {
        return 0;
    }

    /**
     * Easy one
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,1,2,3,3 };
        System.out.println(removeDuplicates(arr));
    }
}
