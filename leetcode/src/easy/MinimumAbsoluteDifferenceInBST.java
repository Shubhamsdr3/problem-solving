package easy;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    private static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderRecursive(root, list);
        System.out.println(list);
        int min = Integer.MAX_VALUE;
        for (int i = list.size() -1; i > 0; i--) {
            int diff = Math.abs(list.get(i) - list.get(i -1));
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    private static void inOrderRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left, list);
        list.add(root.val);
        inOrderRecursive(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(543);
        root.insertBST(root, 384);
        root.insertBST(root, 652);
        root.insertBST(root, 445);
        root.insertBST(root, 699);
        System.out.println(getMinimumDifference(root));
    }
}
