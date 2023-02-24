package medium;

import easy.data.TreeNode;

public class DistributedCoinsInBinaryTree {

    private static int moves = 0;

    private static int distributedCoins(TreeNode root) {
        postOrderTraversal(root);
        return moves;
    }

    private static int postOrderTraversal(TreeNode root) {
        if (root == null) return 0;
        int left = postOrderTraversal(root.left);
        int right = postOrderTraversal(root.right);
        moves = moves + Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(0);
        System.out.println(distributedCoins(root));
    }
}
