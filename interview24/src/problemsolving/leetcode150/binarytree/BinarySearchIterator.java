package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class BinarySearchIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchIterator(TreeNode root) {
        addInOrderTraversal(root);
    }

    private void addInOrderTraversal(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        addInOrderTraversal(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
