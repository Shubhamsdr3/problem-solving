package leetcode150.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2 next;

    TreeNode2(int val) {
        this.val = val;
    }

    public void printLevelOrder(TreeNode2 root) {
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode2 current = queue.poll();
                if (current != null) {
                    System.out.print(" Value: " + current.val + " ");
                    if (current.next != null) {
                        System.out.print(" Next -> " + current.next.val);
                    } else {
                        System.out.print("Next -> #");
                    }
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }
        }
    }
}