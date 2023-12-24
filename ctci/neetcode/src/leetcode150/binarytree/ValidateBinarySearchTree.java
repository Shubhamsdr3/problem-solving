package leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree {

    private static boolean isValidBSTRec(TreeNode root) {
        return helper(root, null);
    }

    /**
     * Do in-order traversal.
     * @param root
     * @param prev
     * @return
     */
    private static boolean helper(TreeNode root, TreeNode prev) {
        if (root == null) return true;
        helper(root.left, prev);
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        return helper(root.right, prev);
    }

    private static boolean isValidBST(TreeNode root) {
       if (root == null) return true;
       Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; // check the left most.
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val) return false;
            prev = root;
            root = root.right; // check the right most.
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }
}
