package easy;

import easy.data.TreeNode;

public class MaximumDepth {

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.insertBinaryTree(root1, 9);
        root1.insertBinaryTree(root1, 20);
        root1.insertBinaryTree(root1, 15);
        root1.insertBinaryTree(root1, 7);

        System.out.println(maxDepth(root1));
    }
}
