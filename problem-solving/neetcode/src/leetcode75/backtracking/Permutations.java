package leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     * T.C => n! * n
     * SC => O(n) + O(n)
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutations(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private static void permutations(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                permutations(nums, visited, path, result);
                path.remove(path.size() - 1);
                visited[i] = false; // backtrack.
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3 };
        System.out.println(permute(arr));
    }
}
