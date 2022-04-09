package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPostOrderTraversal {

    /**
     * Recursive solution.
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    /**
     * Using single stack.
     * TC: O(n)
     * SC: O(n)
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;  // to track previously visited node.
       while (root != null || !stack.isEmpty()) {
           if (root != null) { // push all the left nodes in to stack.
               stack.push(root);
               root = root.left;
           } else {
               root = stack.peek();
               if (root.right == null || root.right == prev) { // we have already visited the right node.
                   list.add(root.val);
                   stack.pop();
                   prev = root;
                   root = null; // so that we don't visit the left child again.
               } else {
                   root = root.right; // Traverse the right subtree before printing root
               }
           }
       }
       return list;
    }

    /**
     * Using two stacks.
     * TC: O(n)
     * SC: O(n)
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversalIterativeUsingTowStacks(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> path = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (!path.isEmpty() && path.peek() == root) {
                list.add(root.val);
                stack.pop();
                path.pop();
            } else {
                path.push(root);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return list;
    }

    /**
     * Without stack.
     * using Morris traversal.
     * TC: O(n)
     * SC: O(1)
     * @param root
     * @return
     *
     * Inorder predecessor of root is the right most child of it's left child.
     */
    private static List<Integer> postorderTraversalIterativeUsingMorrisTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode dummy = new TreeNode(-1);
        TreeNode prev;
        dummy.left = root;
        root = dummy;
        while (root != null) {
            if (root.left != null) {
                prev = root.left;
                while (prev.right != null && prev.right != root) { // if it's not pointing to root.
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root; //we have reached to leaf, keep a pointer to it's root to traverse back.
                    root = root.left; // go the left of root.
                } else {
                    TreeNode node = prev;
                    reverse(root.left, prev);
                    while (node != root.left) {
                        list.add(node.val);
                        node = node.right;
                    }
                    list.add(node.val);
                    reverse(prev, root.left);
                    prev.right = null;
                    root = root.right;
                }
            } else {
                root = root.right;
            }
        }
        return list;
    }

    private static void reverse(TreeNode from, TreeNode to) {
        if (from == to)
            return;
        TreeNode prev = from, node = from.right;
        while (prev != to) {
            TreeNode next = node.right;
            node.right = prev;
            prev = node;
            node = next;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversalIterativeUsingMorrisTraversal(root));
    }
}
