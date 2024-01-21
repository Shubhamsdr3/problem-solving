package problemsolving.leetcode75.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path, int start, int n, int k) {
        if(k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=n; i++) {
            path.add(i);
            backtrack(result, path, i + 1, n, k - 1);
            path.remove(path.size() -1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }
}
