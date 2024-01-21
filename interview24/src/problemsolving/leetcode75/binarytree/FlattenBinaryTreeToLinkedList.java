package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    private static void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode last = current.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        root.inorder(root);
    }
}
