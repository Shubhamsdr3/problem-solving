package easy;

import easy.data.TreeNode;

import java.util.*;

public class PostOrderTraversal {

    private static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode temp1 = root;
        while (temp1 != null) {
            stack.push(temp1.left);
            temp1 = temp1.left;
        }
        TreeNode temp2 = root;
        while (temp2.right != null) {
            stack.push(temp2.right);
            temp2 = temp2.right;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(treeNode));
    }
}
