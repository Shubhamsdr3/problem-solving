package problemsolving.leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.*;

public class BTRightSideView {

    /**
     * Using Level order traversal.
     * @param root
     * @return
     */
    private static List<Integer> rightSideView3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) result.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return result;
    }

    private static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private static void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;
        if (depth == list.size()) { // adding the first element.
            list.add(root.val);
        }
        dfs(root.right, depth + 1, list); // make sure right elements are added first for right view.
        dfs(root.left, depth + 1, list); // for left view make it first.
    }

    /**
     * Using DFS
     * @param root
     * @return
     */
    private static List<Integer> rightSideView(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideView3(root));
    }
}
