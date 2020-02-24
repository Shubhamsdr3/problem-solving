package easy;

import easy.data.TreeNode;

public class MergeTwoBinaryTree {

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        mergeTree(t1, t2);
        return t1;
    }

    private static void mergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return;
        }
        mergeTrees(t1.left, t2.left);
        t1.val = t1.val + t2.val;
        mergeTrees(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);

        mergeTrees(root1, root2).inorder(root1);
    }
}
