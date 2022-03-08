package medium;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FindTheBottomLeftTreeValue {

    /**
     * Using BFS
     * @param root
     * @return
     */
    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 4);
        root.insertBinaryTree(root, 3);
        root.insertBinaryTree(root, 5);
        root.insertBinaryTree(root, 6);
        root.insertBinaryTree(root, 7);
        System.out.println(findBottomLeftValue(root));
    }
}
