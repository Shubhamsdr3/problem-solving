package leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class CountCompleteTreeNodes {

    /**
     *
     * @param root
     * @return
     */
    private static int countNodes1(TreeNode root) {
        int nodes = 0;
        int h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes = nodes + 1 << h;
                root = root.right;
            } else {
                nodes = nodes + 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    private static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
