package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class PathSum {

    private static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = stack.peek();
                sum = sum + current.val;
                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
            stack.pop();
            if (sum == targetSum) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(3);
        int targetSum = 5;
        System.out.println(hasPathSum(root, targetSum));
    }
}
