package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {

    private static boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty() && root != null) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) {
                if (sum == current.val) {
                    return true;
                }
            }
            if (current.right != null) {
                current.right.val = current.val + current.right.val;
                stack.push(current.right);
            }
            if (current.left != null) {
                current.left.val = current.val + current.left.val;
                stack.push(current.left);
            }
        }
        return false;
    }

    private static boolean printAllRootToLeafPaths(TreeNode node, List<Integer> path, int sum) {
        if(node == null) {
            return false;
        }
        boolean isSum = false;
        path.add(node.val);

        if(node.left == null && node.right == null) {
            System.out.println(path);
            if (getSum(path) == sum) {
                isSum = true;
            }
        } else {
            printAllRootToLeafPaths(node.left, new ArrayList<>(path), sum);
            printAllRootToLeafPaths(node.right, new ArrayList<>(path), sum);
        }
        return isSum;
    }

    private static int getSum(List<Integer> list) {
        int sum = 0;
        for (int item : list) {
            sum = sum + item;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);

        root1.left = new TreeNode(4);
        root1.left.left =  new TreeNode(11);
        root1.left.right =  null;
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);


        root1.right =  new TreeNode(8);
        root1.right.right =  new TreeNode(4);
        root1.right.left =  new TreeNode(13);
        root1.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root1, 22));

//        printAllRootToLeafPaths(root1, new ArrayList<>());
    }
}
