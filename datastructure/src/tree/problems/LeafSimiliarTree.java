package tree.problems;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimiliarTree {

    //TODO:FIXME SHUBHAM
    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaf(root1);
        List<Integer> list2 = getLeaf(root2);
        for (int i =0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getLeaf(TreeNode head) {
       List<Integer> list = new ArrayList<>();
        if (head == null || head.left == null && head.right == null) {
            return list;
        }

       getLeaf(head.left);
       list.add(head.data);
       getLeaf(head.right);
       list.add(head.data);
       return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.insert(2);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.insert(2);

        System.out.println(leafSimilar(treeNode1, treeNode2));
    }
}
