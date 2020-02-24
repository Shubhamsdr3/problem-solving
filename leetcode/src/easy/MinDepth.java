package easy;

import easy.data.TreeNode;

public class MinDepth {

    private static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right +1;
        } else {
            return Math.min(left, right) +1;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.insert(root1, 9);
        root1.insert(root1, 20);
        root1.insert(root1, 15);
        root1.insert(root1, 7);
        System.out.println(minDepth(root1));
    }
}
