package interviewprep_23;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CheckCompleteBinaryTree {

    private static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isEnd = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) isEnd = true;
            else {
                if (isEnd) return false;
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(isCompleteTree(root));
    }
}
