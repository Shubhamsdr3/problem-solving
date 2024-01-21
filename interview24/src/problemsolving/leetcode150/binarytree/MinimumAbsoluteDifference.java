package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

public class MinimumAbsoluteDifference {

    public int getMinimumDifference(TreeNode root) {
        TreeNode prev = null;
        int min = Integer.MAX_VALUE;
        return  helper(root, min, prev);
    }

    private int helper(TreeNode root, int min, TreeNode prev) {
        if (root == null)
        helper(root.left, min, prev);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev.val - root.val));
        }
        prev = root;
        helper(root.right, min, prev);
        return min;
    }

    public static void main(String[] args) {

    }
}
