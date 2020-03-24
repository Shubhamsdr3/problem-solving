package easy;

import easy.data.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                size--;
            }
            finalList.add(0, list);
        }
//        Collections.reverse(finalList);
        return finalList;
    }

    public static void main(String[] args) {

    }
}
