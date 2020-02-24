package easy;

import easy.data.TreeNode;

public class SymmetricTree {

    private static boolean isSymmetric(TreeNode root) {
        return (root == null || isSymmetricHelp(root.left, root.right));
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) &&  isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
