package problemsolving.leetcode75.binarytree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PathSum3 {

    private static int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);
        return helper(root, 0, targetSum, prevSum);
    }

    private static int helper(TreeNode root, int currentSum, int targetSum, Map<Integer, Integer> prevSum) {
        if (root == null) return 0;
        currentSum = currentSum + root.data;
        int res = prevSum.getOrDefault(currentSum - targetSum, 0);
        prevSum.put(currentSum, prevSum.getOrDefault(currentSum, 0) + 1);

        res = res + helper(root.left, currentSum, targetSum, prevSum) + helper(root.right, currentSum, targetSum, prevSum);
        prevSum.put(currentSum, prevSum.get(currentSum) - 1);
        return res;
    }

    /**
     * My version: No way.
     * @param root
     * @param targetSum
     * @return
     */
    private static int pathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sum = sum + current.data;
            System.out.println(sum);
            if (sum == targetSum) {
                count++;
                sum = current.data;
            } else if (sum > targetSum) {
                sum = current.data;
            } else if (current.left == null && current.right == null) {
                sum = current.data;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        root.left.left.right = new TreeNode(-2);
        int targetSum = 8;
        System.out.println(pathSum2(root, targetSum));
    }
}
