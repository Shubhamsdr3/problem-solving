package leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    private static void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (root.left == null && !stack.isEmpty()) {
                root.right = stack.pop();
            } else {
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    /**
     * Recursive approach.
     * @param root
     */
    public void flatten(TreeNode root) {
        root = helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) return prev;
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        return root;
    }

    public static void main(String[] args) {

    }
}
