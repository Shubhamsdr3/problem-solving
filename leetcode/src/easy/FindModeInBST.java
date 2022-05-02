package easy;

import easy.data.TreeNode;

import java.util.*;

public class FindModeInBST {

    private static int[] findMode(TreeNode root) {
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
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue().compareTo(max) > 0) {
                max = entry.getValue();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    private static int currVal;
    private static int currCount = 0;
    private static int maxCount = 0;
    private static int modeCount = 0;
    private static int[] modes;

    /**
     * using Morris traversal.
     * @param root
     * @return
     */
    private static int[] findMode2(TreeNode root) {
        inOrder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inOrder(root);
        return modes;
    }

    private static void inOrder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) { // we reached at end, connect it to it's right parent.
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node) { // if we haven't visited the node.
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }

    private static void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode2(root)));
    }
}
