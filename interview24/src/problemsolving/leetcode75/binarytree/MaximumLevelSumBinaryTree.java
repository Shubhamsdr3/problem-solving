package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumLevelSumBinaryTree {

    /**
     * Recursive.
     * @param root
     * @return
     */
    private static int maxLevelSum2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        // find level with max value.
        int maxLevel = 0;
        for (int i = 0; i < result.size(); ++i) {
            if (result.get(maxLevel) < result.get(i)) {
                maxLevel = i;
            }
        }
        return maxLevel + 1;
    }

    private static void dfs(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;
        if (result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, result.get(level) + root.val);
        }
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }

    /**
     * Iterative one using BFS/level order traversal.
     * @param root
     * @return
     */
    private static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int maxLevel = 1;
        int maxValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current  = queue.poll();
                sum = sum + current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (sum > maxValue) {
                maxValue = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(maxLevelSum2(root));

        TreeNode root1 = new TreeNode(989);
        root1.right = new TreeNode(10250);
        root1.right.left = new TreeNode(98693);
        root1.right.right = new TreeNode(-89388);
        root1.right.right.right = new TreeNode(-32127);

        System.out.println(maxLevelSum2(root1));
    }
}
