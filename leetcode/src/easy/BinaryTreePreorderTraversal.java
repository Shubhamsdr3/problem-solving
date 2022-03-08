package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    public static void main(String[] args) {

    }
}
