package easy;

import easy.data.TreeNode;

import java.util.*;

public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            map.put(current.val, map.getOrDefault(current.val, 0) + 1);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
