package easy;

import easy.data.TreeNode;

import java.util.*;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }


    private static List<Integer> inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            while (root.right != null) {
                stack.add(root.right);
                root = root.right;
            }
        }
        return list;
    }

    private void pushAllLeft(TreeNode root, Stack stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderIterative(root));
    }
}
