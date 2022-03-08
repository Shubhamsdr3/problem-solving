package medium;

import easy.data.TreeNode;

public class InsertIntoBinaryTree {

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }
        TreeNode curr = root;
        while (true) {
            if (val  > curr.val) {
                if (root.right == null) {
                    root.right = newNode;
                    break;
                } else  {
                    root = root.right;
                }
            } else if (val < curr.val) {
                if (root.left == null) {
                    root.left = newNode;
                    break;
                } else {
                    root = root.left;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        insertIntoBST(root, 5);
        root.inorder(root);
    }
}
