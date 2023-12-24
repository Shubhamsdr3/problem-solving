package easy.data;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTreeTraversal {

    private static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (!isLeaf(root)) result.add(root.val);
        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);
        return result;
    }

    private static boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> result) {
        TreeNode current = root.left; // left most.
        while (current != null) {
            if (!isLeaf(current)) result.add(current.val);
            if (current.left != null) current = current.left;
            else current = current.right;
        }
    }

    private static void addRightBoundary(TreeNode root, List<Integer> result) {
        TreeNode current = root.right;
        List<Integer> temps =  new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) temps.add(current.val);
            if (current.right != null) current = current.right;
            else current = current.left;
        }
        for (int i = temps.size() - 1; i >= 0; i--) { // reverse.
            result.add(temps.get(i));
        }
    }

    private static void addLeaves(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, result);
        if (root.right != null) addLeaves(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right =new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
        System.out.println(boundaryTraversal(root));
    }
}
