package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    private static List<List<Integer>> subsetsBacktracking(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for (int k = 0; k < n + 1; k++) {
            backtrack(0, k, nums, new ArrayList<>(), output);
        }
        return output;
    }

    private static void backtrack(int first, int k, int[] nums, ArrayList<Integer> current, List<List<Integer>> output) {
        if (current.size() == k) {
            output.add(new ArrayList<>(current));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, k, nums, current, output);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Brute force.
     * @param nums
     * @return
     */
    private static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr) { {
                    add(num);
                }});
            }
            output.addAll(newSubsets);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        System.out.println(subsetsBacktracking(arr));
    }
}
