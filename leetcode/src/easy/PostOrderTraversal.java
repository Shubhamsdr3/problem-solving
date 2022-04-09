package easy;

import easy.data.TreeNode;

import java.util.*;

public class PostOrderTraversal {

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) { // traverse the left most
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right == null || root.right == pre) { // means we have already traversed the right subtree.
                    list.add(root.val);
                    stack.pop();
                    pre = root;
                    root = null; // so we don't go down to left child again.
                } else {
                    root = root.right; // traverse the right subtree.
                }
            }
        }
        return list;
    }

    /**
     * using Two stacks
     * @param root
     */
    private static List<Integer> postOrderTraversalUsingTwoStacks(TreeNode root) {
        Stack<Integer> result = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.push(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        while (!result.isEmpty()) {
            list.add(result.pop());
        }
        return list;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(postOrderTraversalUsingTwoStacks(treeNode));
    }
}
