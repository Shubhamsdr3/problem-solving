package easy;

import easy.data.TreeNode;

import java.util.*;

public class MinAbsDiffBST {

    //FIxME:SHUBHAm
    private static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        while (root.left != null) {
            list.add(root.left.val);
        }
        while (root.right != null) {
            list.add(root.right.val);
        }
        Collections.sort(list);
        return Math.abs(list.get(0) - list.get(1));
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(getMinimumDifference(root));
    }
}
