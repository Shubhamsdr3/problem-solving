package medium;

import easy.data.TreeNode;

public class LowestCommonAncestor {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;// if parent itself is a LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
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
        root.preOrder(root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
