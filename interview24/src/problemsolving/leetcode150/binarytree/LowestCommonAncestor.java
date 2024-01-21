package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

public class LowestCommonAncestor {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p) return p;
        else if (root == q) return q;
        else return lowestCommonAncestor(root.left, p, q) ;
    }

    public static void main(String[] args) {

    }
}
