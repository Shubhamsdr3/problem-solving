package leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.Stack;

public class SumRooToLeadNumbers {

    /**
     * Recursive appraoch.
     * @param root
     * @return
     */
    private static int sumNumbers1(TreeNode root) {
        int sum = 0;
        int num = 0;
        sum = sum + getNumber(root, num);
        return sum;
    }

    private static int getNumber(TreeNode root, int num) {
        if (root == null) return 0;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return  num;
        }
        int leftSum = getNumber(root.left, num);
        int rightSum = getNumber(root.right, num);
        return leftSum + rightSum;
    }

    private static int sumNumbers3(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(String.valueOf(root.val));
        int sum = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            String currentPath = pathStack.pop();
            if (current.right != null) {
                nodeStack.push(current.right);
                pathStack.push(currentPath + current.right.val);
            }
            if (current.left != null) {
                nodeStack.push(current.left);
                pathStack.push(currentPath + current.left.val);
            }

            // if leaf node sum the all the values down from root.
            if (current.left == null && current.right == null) {
                sum = sum + Integer.valueOf(currentPath);
            }
        }
        return sum;
    }

    private static int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        int num = 0;
        int depth = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size && !stack.isEmpty(); i++) {
                TreeNode current = stack.pop();
                num = num * 10 + current.val;
                if (current.left == null && current.right == null) {
                    sum = sum + num;
                    num = (num - current.val) / (depth * 10); // this is where i was doing wrong..we can store the path in stack.
                    depth = 0;
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
                depth++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.right.right = new TreeNode(6);

        System.out.print(sumNumbers3(root1));
    }
}
