package medium;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafNodesPair {

    private static int countPairs(TreeNode root, int distance) {
        return dfs(root, new ArrayList<>(), distance);
    }

    private static int dfs(TreeNode root, List<Integer> list, int distance) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            list.add(0); // leaf node.
            return 0;
        }
        int count = 0;
        List<Integer> ld = new ArrayList<>();
        List<Integer> rd = new ArrayList<>();
        int left = dfs(root.left, ld, distance);
        int right = dfs(root.right, rd, distance);
        for (Integer integer : ld) {
            for (Integer value : rd) {
                if (integer + value + 2 <= distance) {
                    count++;
                }
            }
        }
        for (int l: ld) list.add(l + 1);
        for (int r: rd) list.add(r + 1);
        return count + left + right;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(countPairs(root, 3));
    }
}
