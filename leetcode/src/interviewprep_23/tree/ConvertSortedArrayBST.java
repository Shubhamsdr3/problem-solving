package interviewprep_23.tree;

import easy.data.TreeNode;

public class ConvertSortedArrayBST {

    private static TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }

    private static TreeNode makeBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, low, mid - 1);
        root.right = makeBST(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -10, -3, 0, 5, 9 };
        TreeNode root = sortedArrayToBST(nums);
        root.preOrder(root);
    }
}
