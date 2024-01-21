package leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, 1, k, n);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path, int sum, int start, int k, int totalSum) {
        if (path.size() == k && sum == totalSum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(result, path,  sum + i, i + 1, k, totalSum);
            path.remove(path.size() - 1); //check whether to tak or not take.
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum3(k, n));
    }
}
