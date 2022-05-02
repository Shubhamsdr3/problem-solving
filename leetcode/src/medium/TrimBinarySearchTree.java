package medium;

import easy.data.TreeNode;

public class TrimBinarySearchTree {

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val >= low && root.val <= high) { // within range.
            root.left = trimBST(root.left, low, high); // trim the left subtree
            root.right = trimBST(root.right, low, high); // trim the right subtree
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else {
            root = trimBST(root.left, low, high);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        TreeNode res = trimBST(root, 1, 2);
        res.postOrder(res);
    }
}
