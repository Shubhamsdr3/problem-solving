package medium;

import easy.data.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    private static final Map<TreeNode, Integer> distanceMap = new HashMap<>();

    /**
     * Using DFS
     * @param root
     * @param target
     * @param k
     * @return
     */
    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, k, distanceMap.get(root), res);
        return res;
    }

    private static int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root.val == target.val) {
            distanceMap.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            distanceMap.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            distanceMap.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private static void dfs(TreeNode root, int k, int len, List<Integer> res) {
        if (root == null) return;
        if (distanceMap.containsKey(root)) {
            len = distanceMap.get(root);
        }
        if (len == k) res.add(root.val);
        dfs(root.left, k, len + 1, res);
        dfs(root.right, k, len + 1, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = new TreeNode(5);
        int k = 2;
        System.out.println(distanceK(root, target, k));
    }
}
