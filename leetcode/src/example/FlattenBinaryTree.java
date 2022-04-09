package example;

import easy.data.TreeNode;

import java.util.Stack;

public class FlattenBinaryTree {

    // TODO:
    private static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode temp = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            temp.right = current;
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {

    }
}
