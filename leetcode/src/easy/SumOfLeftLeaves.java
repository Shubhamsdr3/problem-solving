package easy;

import easy.data.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves {

    private static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left.left == null && current.left.right == null) {
                sum = sum  + current.left.val;
            } else {
                stack.push(current.left);
            }
            if (current.right != null) {
                if (current.right.left != null && current.right.right != null) {
                    stack.push(current.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
}
