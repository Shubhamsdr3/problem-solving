package medium;

import java.util.ArrayList;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int num = nums[i];
            list.add(num);
            int val = -num;
            for (int j = i +1; j < nums.length; j++) {
                if (nums[j] == val) {
                    list.add(nums[j]);
                }
            }
            
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
