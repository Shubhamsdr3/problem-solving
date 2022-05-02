package medium;

import easy.data.TreeNode;

public class LongestUniversalPath {

    private int len = 0;

    public int longestUnivaluePath(TreeNode root) {
       if (root == null) return 0;
       len = 0;
       helper(root, root.val);
       return len;
    }

    private int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        len = Math.max(len, left + right);
        if (val == root.val) {
            return Math.max(left, right) + 1; // including current node.
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
