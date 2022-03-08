package medium;

import easy.data.TreeNode;

import java.util.*;

public class MostFrequentSubtreeSum {

    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;

    private int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s: count.keySet()) {
            if (count.get(s) == maxCount) {
                res.add(s);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int s = dfs(root.left) + dfs(root.right) + root.val;
        count.put(s, count.getOrDefault(s, 0) + 1);
        maxCount = Math.max(maxCount, count.get(s));
        return s;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(new MostFrequentSubtreeSum().findFrequentTreeSum(root)));
    }
}
