package easy;

import easy.data.TreeNode;

public class SameTree {

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.insert(root1, 1);
        root1.insert(root1, 5);

        TreeNode root2 = new TreeNode(2);
        root2.insert(root2, 1);
        root2.insert(root2, 3);

        System.out.println(isSameTree(root1, root2));
    }
}
