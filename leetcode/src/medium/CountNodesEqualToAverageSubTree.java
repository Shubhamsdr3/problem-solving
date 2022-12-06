package medium;

import easy.data.TreeNode;

public class CountNodesEqualToAverageSubTree {

    private static int res = 0;

    private static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int currentSum = left[0] + right[0] + root.val;
        int currentCount = left[1] + right[1] + 1;
        if (currentSum / currentCount == root.val) {
            res++;
        }
        return new int[]{currentSum, currentCount};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        System.out.println(averageOfSubtree(root));
//        root.inorder(root);
//        System.out.println(root);
    }
}
