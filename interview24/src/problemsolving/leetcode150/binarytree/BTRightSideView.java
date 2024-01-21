package problemsolving.leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int depth = 0;
        helper(root, list, depth);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list, int depth) {
        if (root == null) return;
        if (depth == list.size()) {
            list.add(root.val);
        }
        helper(root.right, list, depth + 1);
        helper(root.left, list, depth + 1);
    }

    public static void main(String[] args) {

    }
}
