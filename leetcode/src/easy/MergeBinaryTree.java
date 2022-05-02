package easy;

import easy.data.TreeNode;

public class MergeBinaryTree {

    // TODO: fixme
    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }

    private static void inOrderTraversal(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return;
        root1.val = root1.val + root2.val;
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
        } else if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
        }
        inOrderTraversal(root1.left, root2.left);
        inOrderTraversal(root1.right, root2.right);
    }

    public static void main(String[] args) {

    }
}
