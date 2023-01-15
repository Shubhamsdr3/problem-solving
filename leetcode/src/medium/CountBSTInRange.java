package medium;

import easy.data.TreeNode;

public class CountBSTInRange {


    private static int count = 0;

    private static int getCount(TreeNode root, int left, int right) {
        inOrderTraversal(root, left, right);
        return count;
    }

    private static void inOrderTraversal(TreeNode root, int left, int right) {
        if (root == null) return;
        inOrderTraversal(root.left, left, right);
        if (root.val >= left && root.val <= right) {
            count++;
        }
        inOrderTraversal(root.right, left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(100);
        root.right.left = new TreeNode(40);
        int left = 5;
        int right = 45;
        System.out.println(getCount(root, left, right));
    }
}
