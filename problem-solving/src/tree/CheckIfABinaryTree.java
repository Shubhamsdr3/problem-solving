package tree;

import tree.data.Node;

public class CheckIfABinaryTree {

    private static boolean checkBST(Node root) {
       return checkBST(root, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private static boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return false;
        }

        if (root.data < min && root.data > max) {
            return false;
        }
        return checkBST(root.left, min, root.data-1) && checkBST(root.right,root.data +1, max);
    }

    public static void main(String[] args) {

    }
}
