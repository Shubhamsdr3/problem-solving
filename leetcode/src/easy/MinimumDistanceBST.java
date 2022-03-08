package easy;

import com.sun.source.tree.Tree;
import easy.data.TreeNode;

import java.util.Stack;

public class MinimumDistanceBST {

    private static int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            // push left first
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // pop the root
            TreeNode current = stack.pop();
            if (prev != null) {
                min = Math.min(min, current.val - prev.val);
            }
            prev = current;
            root = current.right;
        }
        return min;
    }

    private static int minDiffInBSTRight(TreeNode node) {
        int diff = Integer.MAX_VALUE;
        if(node == null)
            return diff;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        while(!stk.isEmpty() || node != null){
            while(node != null){
                stk.push(node);
                node = node.left;
            }
            TreeNode popped = stk.pop();
            if(prev != null){
                diff = Math.min(diff, popped.val-prev.val);
            }
            prev = popped;
            node = popped.right;
        }
        return diff;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.insertBST(root, 2);
        root.insertBST(root, 6);
        root.insertBST(root, 1);
        root.insertBST(root, 3);
        root.inorder(root);
        System.out.println(minDiffInBST(root));
        char[] arr1 = new char[]{'S', 'H'};
        char[] arr2 = new char[]{'S', 'H'};
        System.out.println(arr1.equals(arr2));
    }
}
