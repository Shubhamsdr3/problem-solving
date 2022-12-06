package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Created at: 04/05/22
*/
public class LargestDivisibleSubset {

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int[] length = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.sort(nums);
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            length[i] = 1;
            prev[i] = -1;
            for (int j = i -1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    prev[i] = j;
                }
            }
            if (length[i] > max) {
                max = length[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = prev[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1,2,4,8 };
        System.out.println(largestDivisibleSubset(nums));
    }
}
