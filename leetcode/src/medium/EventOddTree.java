package medium;

import easy.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventOddTree {

    /**
     * Even-Odd tree.
     *
     * @param root
     * @return
     */
    private static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevValue = -1;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.peek();
                if (level % 2 == 0) {
                    // even level..should have odd values and strictly increasing....
                    if (current.val % 2 == 0) return false;
                    if (current.val <= prevValue) return false;

                } else {
                    // odd level...should have even values and strictly decreasing....
                    if (current.val % 2 != 0) return false;
                    if (prevValue > 0 && current.val >= prevValue) return false;
                }
                prevValue = current.val;
                queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.insertBinaryTree(root, 10);
        root.insertBinaryTree(root, 4);
        root.insertBinaryTree(root, 3);
        root.insertBinaryTree(root, 12);
        root.insertBinaryTree(root, 8);
        root.insertBinaryTree(root, 7);
        root.insertBinaryTree(root, 9);
        root.insertBinaryTree(root, 6);
        root.insertBinaryTree(root, 2);
        System.out.println(isEvenOddTree(root));
    }
}
