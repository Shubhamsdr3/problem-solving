package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**
     * Iterative.
     * @param root
     * @return
     */
    private static TreeNode invertTree1(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>(); //BFS
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            current.left = current.right;
            current.right = left;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }

    /**
     * Recursive.
     * @param root
     * @return
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {

    }
}
