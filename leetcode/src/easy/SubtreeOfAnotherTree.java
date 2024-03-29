package easy;

import easy.data.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
Updated on: 15/04/22
*/
public class SubtreeOfAnotherTree {

    private static boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (isSame(current, t)) {
                return true;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        else return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(isSubtree(root1, root2));
    }
}
