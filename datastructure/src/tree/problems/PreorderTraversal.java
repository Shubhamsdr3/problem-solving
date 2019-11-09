package tree.problems;

import tree.TreeNode;

public class PreorderTraversal {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            // Tree is empty.
            return;
        }
        System.out.print(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{};
    }
}
