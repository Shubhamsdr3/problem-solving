package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new LinkedList<>(), target, 0, 0,  result);
        return result;
    }

    private static void backtrack(int[] candidates, LinkedList<Integer> currentComb, int target, int currentIndex, int currentSum, List<List<Integer>> result) {
        if (currentSum > target) return; // backtrack
        if (currentSum == target) {
            result.add(new ArrayList<>(currentComb)); // store the solution and backtrack
            return;
        }
        for (int i = currentIndex; i < candidates.length; i++) {
            int num = candidates[i]; // 2
            currentComb.addLast(num);
            currentSum = currentSum + num;
            backtrack(candidates, currentComb, target, i, currentSum, result);
            currentComb.removeLast(); // go back.
            currentSum = currentSum - num;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {  2, 3, 5 };
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
}
