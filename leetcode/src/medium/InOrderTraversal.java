package medium;

import easy.data.ListNode;
import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    /**
     * My idea (:
     */
    private  static List<Integer> list = new ArrayList<>();
    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root.left != null) {
            traverseLeft(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            traverseLeft(root.right);
        }
        return list;
    }

    private static void traverseLeft(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    /**
     * Correct solution:
     * @param root
     */
    private static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        pushAllLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            pushAllLeft(current.right, stack);
        }
        return list;
    }

    private static void pushAllLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 3);
        System.out.println(inorderTraversal1(root));
    }
}
