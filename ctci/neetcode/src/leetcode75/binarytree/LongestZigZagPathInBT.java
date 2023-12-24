package leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.Map;
import java.util.Stack;

public class LongestZigZagPathInBT {

    private static int maxDepth = Integer.MIN_VALUE;

    private static int longestZigZag2(TreeNode root) {
        if (root == null) return 0;
        // try both left/right direction and chose the better one.
        path(root.left, 0, false);
        path(root.right, 0, false);
        return maxDepth;
    }

    private static void path(TreeNode root, int depth, boolean isRight) {
        maxDepth = Math.max(depth, maxDepth);
        if (root == null) return;
        path(root.left, (isRight) ? depth + 1: 0, false);
        path(root.right, (isRight) ? depth + 1: 0, true);
    }

    private static int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean isLeft = true;
        int count = 1;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.val);
            count++;
            if (isLeft && current.right != null) {
                stack.push(current.right);
                isLeft = false;
            } else if (current.left != null){
                stack.push(current.left);
                isLeft = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);
        System.out.println(longestZigZag2(root));
    }
}
