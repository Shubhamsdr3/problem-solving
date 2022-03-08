package easy;

import easy.data.TreeNode;

public class LostStoneWeight {

    private static Integer res = Integer.MAX_VALUE, pre = null;

    private static int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        System.out.println(minDiffInBST(root));
    }
}
