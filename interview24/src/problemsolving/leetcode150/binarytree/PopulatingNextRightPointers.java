package problemsolving.leetcode150.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {

    /**
     * Using recursion.
     * T.C -> O(n)
     * S.C -> O(logN)
     * @param root
     * @return
     */
    private static TreeNode2 connect2(TreeNode2 root) {
        if (root == null) return null;
        TreeNode2 left = root.left;
        TreeNode2 right = root.right;
        TreeNode2 next = right.next;

        if (left != null) {
            left.next = right;
            if (next != null) right.next = next.left;
            connect2(left);
            connect2(right);
        }
        return root;
    }

    /**
     * DFS (right-to-left):Iterative solution.
     * @param root
     * @return
     */
    private static TreeNode2 connect1(TreeNode2 root) {
        if(root == null) return null;
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 right = null;
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode2 current = queue.poll();
                current.next = right;
                right = current;
                if (current.right != null) {
                    queue.offer(current.right);
                    queue.offer(current.left);
                }
            }
        }
        return root;
    }

    /**
     * DFS (left-to-right):Iterative solution.
     * @param root
     * @return
     */
    private static TreeNode2 connect(TreeNode2 root) {
        if(root == null) return null;
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode2 current = queue.poll();
                if(i == size - 1) {
                    current.next = null;
                } else {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        root.right.left = new TreeNode2(6);
        root.right.right = new TreeNode2(7);

        TreeNode2 result = connect1(root);
        result.printLevelOrder(result);
    }
}
