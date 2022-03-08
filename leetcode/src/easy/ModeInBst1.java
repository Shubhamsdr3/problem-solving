package easy;

import easy.data.TreeNode;

import java.util.*;

public class ModeInBst1 {

    private static int[] findMode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            countMap.put(current.val, countMap.getOrDefault(current.val, 0) + 1);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
        return new int[]{1};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(findMode(root)));
    }
}
