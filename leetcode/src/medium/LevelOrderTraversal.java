package medium;

import easy.data.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) {
            return finalList;
        }
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
            finalList.add(list);
        }
        return finalList;
    }

    private static void printLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printLeft(root.left);
    }

    private static void leftView(TreeNode root) {
        if (root == null) {
            return;
        }
        // create an empty queue and enqueue the root node
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // to store the current node
        TreeNode curr;
        // loop till queue is empty
        while (!queue.isEmpty()) {
            // calculate the total number of nodes at the current level
            int size = queue.size();
            int i = 0;

            // process every node of the current level and enqueue their
            // non-empty left and right child
            while (i++ < size) {
                curr = queue.poll();

                // if this is the first node of the current level, print it
                if (i == 1) {
                    System.out.print(curr.val + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

//        TreeNode root = new TreeNode(1);
//        root.insertBinaryTree(root, 2);
//        root.insertBinaryTree(root, 3);
//        root.insertBinaryTree(root, 4);
//        root.insertBinaryTree(root, 5);
//        root.insertBinaryTree(root, 6);
//        root.insertBinaryTree(root, 7);
//        root.insertBinaryTree(root, 8);
        leftView(root);
    }
}
