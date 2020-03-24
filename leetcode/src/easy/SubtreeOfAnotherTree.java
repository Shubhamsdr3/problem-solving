package easy;

import easy.data.TreeNode;

public class SubtreeOfAnotherTree {

    private static boolean isSubtree(TreeNode s, TreeNode t) {
        return s.val == t.val && isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(isSubtree(root1, root2));
    }
}
