package medium.backtracking;

import java.util.*;

public class CombinationSum2 {

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new LinkedList<>(), 0, 0, ans);
        return ans;
    }

    private static void backtrack(int[] candidates, int target, LinkedList<Integer> combinations, int currentSum, int currentIndex, List<List<Integer>> ans) {
        if (currentSum > target) return;
        if (currentSum == target) {
            ans.add(new ArrayList<>(combinations));
            return;
        }
        for (int i = currentIndex; i < candidates.length; i++) {
            if (i > currentIndex && candidates[i] == candidates[i -1]) continue; // skip the duplicates
            int num = candidates[i];
            combinations.addLast(num);
            currentSum = currentSum + num;
            backtrack(candidates, target, combinations, currentSum, i + 1, ans); // i + 1 -> same number can't be considered twice.
            combinations.removeLast();
            currentSum = currentSum - num;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 5, 2, 1, 2 };
        int target = 5;
        System.out.println(combinationSum2(arr, target));
    }
}
