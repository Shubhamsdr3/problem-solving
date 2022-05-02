package medium;

import easy.data.TreeNode;

import java.util.*;

/**
Created at: 13/04/22
*/
public class FindTheLargestValueInEachTreeRow {

    private static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(largestValues(root));
    }
}
