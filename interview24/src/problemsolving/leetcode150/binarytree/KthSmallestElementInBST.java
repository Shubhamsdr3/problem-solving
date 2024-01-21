package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    private static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if(root.left == null && root.right == null) return root.val;
        helper(root, list);
        return list.get(k -1);
    }

    private static void helper(TreeNode root, List<Integer> path) {
        if(root == null) return;
        helper(root.left, path);
        path.add(root.val);
        helper(root.right, path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        int k = 3;

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        System.out.println(kthSmallest(root1, 1));
    }
}
