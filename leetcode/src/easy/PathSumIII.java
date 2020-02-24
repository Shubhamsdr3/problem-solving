package easy;

import easy.data.TreeNode;

import java.util.Stack;

public class PathSumIII {

    private static int pathSum(TreeNode root, int sum) {
        int count = 0;
        while (root != null) {
            if (root.left != null) {
                int sum1 = pathSumHelper(root.left);
                root = root.left;
                if (sum == sum1) {
                    count++;
                }
            }
            if (root.right != null) {
                int sum2 = pathSumHelper(root.right);
                root = root.right;
                if (sum2 == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int pathSumHelper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) {
                return current.val;
            }
            if (current.left != null) {
                current.left.val = current.val + current.left.val;
                stack.push(current.left);
            }
            if (current.right != null) {
                current.right.val = current.val + current.right.val;
                stack.push(current.right);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(11);
        root.right.left = null;

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.left = null;
        root.left.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 8));

    }
}
