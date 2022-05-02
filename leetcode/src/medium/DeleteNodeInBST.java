package medium;

import easy.data.TreeNode;

public class DeleteNodeInBST {

    /**
     * Three cases:
     *  1. Delete leaf node.
     *  2. Delete node with single child.
     *  3. Delete node with two children.
     * @param root
     * @param key
     * @return
     */
    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // if tree is empty
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = findMin(root.right); // minimum value in inorder successor.
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    /**
     * Find minimum inorder successor
     * We can use max value of inorder predecessor.
     * @param root
     * @return
     */
    private static int findMin(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insertBinaryTree(root, 3);
        root.insertBinaryTree(root, 6);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 4);
        root.insertBinaryTree(root, 7);
        TreeNode res = deleteNode(root, 3);
        res.postOrder(root);
    }
}
