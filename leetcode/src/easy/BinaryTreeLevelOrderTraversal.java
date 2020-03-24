package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(printLevelOrder(root));
        return finalList;
    }

    private static List<Integer> printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            list.add(tempNode.val);
            // enqueue the left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            // enqueue the right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.insertBST(root1, 9);
        root1.insertBST(root1, 20);
        root1.insertBST(root1, 15);
        root1.insertBST(root1, 7);

        System.out.println(levelOrderBottom(root1));
    }
}
