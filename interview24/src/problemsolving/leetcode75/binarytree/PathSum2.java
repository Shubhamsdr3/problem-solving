package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPath(root, targetSum, path, result);
        return result;
    }

    private static void findPath(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(path);
        }
        findPath(root.left, targetSum - root.val, path, result);
        findPath(root.right, targetSum - root.val, path, result);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        int targetSum = 22;
        System.out.println(pathSum(root, targetSum));
    }
}
