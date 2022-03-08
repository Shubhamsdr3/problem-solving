package easy;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBinaryTree {

    private static int searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node.val;
            }
           if (node.left != null) {
               queue.add(node.left);
           }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 2));
    }
}
