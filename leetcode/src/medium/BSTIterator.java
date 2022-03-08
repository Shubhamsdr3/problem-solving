package medium;

import easy.data.TreeNode;

import java.util.Stack;

/**
Created at: 08/03/22
*/
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
