package leetcode150.binarytree;


import easy.data.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructBinaryTree {

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private static TreeNode buildTree(
            int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preEnd + numsLeft, inorder, inRoot, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[] {3, 9, 20, 15, 7 };
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = buildTree(preOrder, inOrder);
        result.levelOrder(result);
    }
}
