package medium;

import easy.data.TreeNode;

import java.util.*;

public class AllElementsInTwoBinarySearch {

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        if (root1 == null && root2 == null) return res;
        if (root1 != null) {
            Queue<TreeNode> queue1 = new LinkedList<>();
            queue1.add(root1);
            while (!queue1.isEmpty()) {
                TreeNode current = queue1.poll();
                res.add(current.val);
                if (current.left != null) {
                    queue1.add(current.left);
                }
                if (current.right != null) {
                    queue1.add(current.right);
                }
            }
        }
        if (root2 != null) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue2.add(root2);
            while (!queue2.isEmpty()) {
                TreeNode current = queue2.poll();
                res.add(current.val);
                if (current.left != null) {
                    queue2.add(current.left);
                }
                if (current.right != null) {
                    queue2.add(current.right);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private static List<Integer> getAllTheElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        pushLeft(stack1, root1);
        pushLeft(stack2, root2);

        List<Integer> res = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> st;
            if (stack1.isEmpty()) {
                st = stack2;
            } else if (stack2.isEmpty()) {
                st = stack1;
            } else {
                st = stack1.peek().val < stack2.peek().val ? stack1 : stack2;
            }
            TreeNode current = st.pop();
            res.add(current.val);
            pushLeft(st, current.right);
        }
        return res;
    }

    private static void pushLeft(Stack<TreeNode> stack1, TreeNode root1) {
        while (root1 != null) {
            stack1.push(root1);
            root1 = root1.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        System.out.println(getAllTheElements(root1, root2));
    }
}
