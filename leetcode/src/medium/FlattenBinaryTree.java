package medium;

import easy.data.TreeNode;

import java.util.Stack;

public class FlattenBinaryTree {

    private static TreeNode prev;

    private static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {

    }
}
