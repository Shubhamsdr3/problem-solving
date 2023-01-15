package medium;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestSubTree {

    private static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return root;
    }

    private static TreeNode findDeepestNode(TreeNode root) {
        if (root == null) return null;
        TreeNode current = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.insertBinaryTree(root, 5);
        root.insertBinaryTree(root, 1);
        root.insertBinaryTree(root, 6);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 0);
        root.insertBinaryTree(root, 8);
        root.insertBinaryTree(root, 7);
        root.insertBinaryTree(root, 4);
        TreeNode node = findDeepestNode(root);
        System.out.println(node.val);
    }
}
