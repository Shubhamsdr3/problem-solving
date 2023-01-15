package medium;

import easy.data.TreeNode;

import java.util.Stack;

public class BinaryTreePruning {

    private static TreeNode pruneTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current =  stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left == null && current.right == null && current.val == 0) {
                return null;
            } else {
                return current;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeNode root1 = pruneTree(root);
        root1.preOrder(root1);
    }
}