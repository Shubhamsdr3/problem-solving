package easy;

import easy.data.TreeNode;

public class CousinInBinaryTree {

    private static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        if (root.left.val == x && root.right.val == y) {
            return true;
        }

        root.left = root.left.left;
        root.right = root.right.right;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 5, 4));
    }
}
