package easy;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**
     * Method: 1
     * @param root
     * @return
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap the pointer
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Method II
     * @param root
     * @return
     */
    private static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    private static void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * Iterative approach: using Queue (Level order traversals)
     * @param root
     * @return
     */
    private static TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // swapping
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return root;
    }

    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        printInorder(root);
        System.out.println();
        printInorder(invertTree(root));
    }
}
