package easy.data;

import java.util.Stack;

public class TreeTraversalIterative {

    private static void boundaryTraversal(TreeNode root) {

    }

    public static void inOrderTraversal(TreeNode root) {

    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                System.out.println(current.val + " ");
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            } else {
                current = stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        preOrderTraversal(root);
    }
}
