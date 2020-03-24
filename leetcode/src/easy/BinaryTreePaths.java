package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sb.append(current.val);
            if (current.left != null) {
                sb.append("->");
                stack.push(current.left);
            }
        }
        list.add(sb.toString());
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        StringBuilder sb1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            sb1.append(current.val);
            if (current.right != null) {
                sb1.append("->");
                stack1.push(current.right);
            }
        }
        list.add(sb1.toString());
        return list;
    }


    private static String traverse(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        sb.append(root.val);
        traverse(root.left);
        return "";
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 3);
        root.insertBinaryTree(root, 5);
//        root.inorder(root);
        System.out.println(binaryTreePaths(root));
    }
}
