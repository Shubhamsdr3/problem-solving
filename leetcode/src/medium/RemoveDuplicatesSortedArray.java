package medium;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSortedArray {

    private static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) {

            } else {

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                1, 1, 1, 2, 2, 3
        };
        System.out.println(removeDuplicates(input));
    }
}
