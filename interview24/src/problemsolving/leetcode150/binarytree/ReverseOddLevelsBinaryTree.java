package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsBinaryTree {

    private static TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // reversing the values.
            if (level % 2 == 1 && !queue.isEmpty()) {
                int[] nums = new int[queue.size()];
                int i = 0;
                for (TreeNode node: queue) {
                    nums[i++] = node.val; // store the node value.
                }
                // and reverse it.
                int j = queue.size() - 1;
                for (TreeNode node: queue) {
                    node.val = nums[j--];
                }
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(34);
        root.right.left = new TreeNode(21);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.levelOrder(root);
        System.out.println();
        TreeNode result = reverseOddLevels(root);
        result.levelOrder(result);
    }
}
