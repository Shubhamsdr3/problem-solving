package easy;

import easy.data.TreeNode;

public class ConvertArrayToBST {

    /**
     * @param nums
     * @return [0, -3, 9, -10, null, 5]
     */
    private static TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length /2;
        TreeNode root =  new TreeNode(nums[mid]);
        for (int i = 0; i < nums.length; i++) {
            insert(root, nums[i]);
        }
        return root;
    }

    private static void insert(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                root.left.insertBinaryTree(root, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                root.right.insertBinaryTree(root, value);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(arr));
    }
}
