package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

public class MinimumDepthOfBinaryTree {

    private static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    private static int depth(TreeNode root, int minDepth) {
        if (root == null) return 0;
        minDepth = Math.min(depth(root.left, minDepth) , depth(root.right, minDepth)) + 1;
        return minDepth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
}
