package leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.*;

public class LeafSimilarTrees {

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (dfs(stack1) != dfs(stack2)) return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private static int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(9);
        root1.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root1, root2));
    }
}
