package leetcode150.binarytree;

import easy.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree2 {

    /**
     *
     * @param postOrder: left-right-root
     * @param inorder : root-left-right
     * @return
     */
    private static TreeNode buildTree(int[] postOrder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postOrder.length; i++) {
            map.put(postOrder[i], i);
        }
        TreeNode root = buildTreeHelper(postOrder, postOrder.length - 1, 0, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private static TreeNode buildTreeHelper(int[] postOrder, int postEnd, int postStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        TreeNode root = new TreeNode(postOrder[postEnd]); // root lies at the end in post-order.
        // get the position where root elements lies in in-order.
        int inRootPosition = map.get(root.val);
        // left elements of this position, will be left tree and right elements will right tree.
        int noOfLeftElements = inRootPosition - inStart;
//        root.left = buildTreeHelper(postOrder, postEnd - 1, postStart + noOfLeftElements, )
        return root;
    }

    public static void main(String[] args) {

    }
}
