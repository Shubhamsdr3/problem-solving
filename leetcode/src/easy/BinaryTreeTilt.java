package easy;

import easy.data.TreeNode;

public class BinaryTreeTilt {

    private static int result = 0;

    private static int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private static int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result = result + Math.abs(left - right);
        return  left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(findTilt(root));
    }
}
