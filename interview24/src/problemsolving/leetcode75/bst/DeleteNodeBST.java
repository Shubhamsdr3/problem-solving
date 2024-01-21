package problemsolving.leetcode75.bst;


import easy.data.TreeNode;

public class DeleteNodeBST {

    /**
     * Steps:
     *  1. Search the node.
     *  2. Cases:
     *      1. If leaf -> simply delete i.e. return null.
     *      2. Single child -
     *      3. Has both the child:
     *          a. Inorder-predecessor.
     *          b.
     *  4.
     * @param root
     * @param key
     * @return deleted node.
     */
    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) { // if key is less than root the go to left most.
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) { // otherwise go to the right most.
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) { //
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right); // find the left most in the sub-tree.
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int key = 3;
        TreeNode result = deleteNode(root, key);
        result.preOrder(result);
    }
}
