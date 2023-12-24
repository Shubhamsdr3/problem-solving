package leetcode75.binarytree;

import easy.data.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTree {

    /**
     * Recursive approach.
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart < preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    /**
     * using iterative approach.
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode currentNode = new TreeNode(value);
            // check if it would left child/right child.
            TreeNode currentRoot = stack.peek();
            // if value < root value then left.(pre-order traversal)
            if (map.get(value) < map.get(currentRoot.val)) {
                currentRoot.left = currentNode;
            } else  {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) > map.get(currentRoot.left)) {
                    parent = stack.pop();
                }
                parent.right = currentNode;
            }
            stack.push(currentNode);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        TreeNode res = buildTree2(preorder, inorder);
        res.preOrder(res);
    }
}
