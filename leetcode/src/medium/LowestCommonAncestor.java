package medium;

import easy.data.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    /**
     * Iterative.
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        // ancestors set for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestors of q which appears in.
        // p's ancestor set is their lowest common ancestor
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    /**
     * T.C -> O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;// if parent itself is a LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.insertBinaryTree(root, 5);
        root.insertBinaryTree(root, 1);
        root.insertBinaryTree(root, 6);
        root.insertBinaryTree(root, 2);
        root.insertBinaryTree(root, 0);
        root.insertBinaryTree(root, 8);
        root.insertBinaryTree(root, 7);
        root.insertBinaryTree(root, 4);
        root.preOrder(root);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = lowestCommonAncestor2(root, p, q);
        System.out.println(res.val);
    }
}
