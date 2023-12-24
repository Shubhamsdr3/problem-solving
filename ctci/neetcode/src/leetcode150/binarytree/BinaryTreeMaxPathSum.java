package leetcode150.binarytree;

import easy.data.TreeNode;


public class BinaryTreeMaxPathSum {
    private static int maxValue = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private static int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left)); // if negative, take 0.
        int right = Math.max(0, maxPathDown(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left , right) + root.val;
    }

    public static void main(String[] args) {

    }
}
