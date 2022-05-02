package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SecondMinimumNodeInBinaryTree {

    private static int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() > 1) {
            return list.get(1);
        }
        return -1;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {

    }
}
