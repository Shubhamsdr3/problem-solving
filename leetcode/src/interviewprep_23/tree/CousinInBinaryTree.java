package interviewprep_23.tree;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinInBinaryTree {


    private static boolean isCousins2(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            foundX = false;
            foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val  == x) foundX = true;
                if (node.val  == y) foundY = true;
            }
        }
        return true;
    }

    /**
     * Two nodes of a binary tree are cousins if they have the same depth with different parents.
     * In a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
     * @param root
     * @param x
     * @param y
     * @return
     */
    private static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) isAexist = true;
                if (cur.val == y) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int x = 5;
        int y = 4;
        System.out.println(isCousins(root, x, y));
    }
}
