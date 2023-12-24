package leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.Map;
import java.util.Stack;

public class CountGoodNodesInBT {

    private static int goodNodesIterative(TreeNode root) {
       return 0;
    }

    private static int goodNodesRecursive(TreeNode root) {
        if (root == null) return 0;
        int maxSoFar = Integer.MIN_VALUE;
        return dfs(root, maxSoFar);
    }

    private static int dfs(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        int res = root.val >= maxSoFar ? 1: 0; // maintain the max value.
        res = res + dfs(root.left, Math.max(maxSoFar, root.val));
        res = res + dfs(root.right, Math.max(maxSoFar, root.val));
        return res;
    }

    private static int goodNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            int size = stack.size();
            boolean isGreater = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.peek();
                if (node.val > current.val) {
                    isGreater = false;
                } else  {
                    isGreater = true;
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
            stack.pop();
            if (isGreater) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        System.out.println(goodNodesRecursive(root));
    }
}
