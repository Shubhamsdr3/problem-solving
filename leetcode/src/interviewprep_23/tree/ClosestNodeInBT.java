package interviewprep_23.tree;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodeInBT {

    /**
     * Smaller number that is greater than or equal to
     * @param root
     * @param queries
     * @return
     */

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        return new ArrayList(sortedList);
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public static void main(String[] args) {

    }
}
