package tree.problems;

import tree.TreeNode;

public class TreeHeight {

    private static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int height1 = height(root.left);
        int height2 = height(root.right);
        return 1 + Math.max(height2, height1);
    }

    private static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = null;
        for (int value : arr) {
            root = insert(root, value);
        }
        int height = height(root);
        System.out.println(height);
    }
}