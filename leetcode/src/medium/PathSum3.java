package medium;

import easy.data.TreeNode;

import java.util.Stack;

public class PathSum3 {

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    private static int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode temp = current;
            int sum = current.val;
            while (temp.left != null) {
                sum =  sum + current.left.val;
                temp = temp.left;
                if (sum == targetSum) {
                    count++;
                }
            }
            sum = current.val;
            temp = current;
            while (temp.right != null) {
                sum = sum + temp.right.val;
                temp = temp.right;
            }
            if (sum == targetSum) {
                count++;
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        System.out.println(pathSum(root, 8));
    }
}
