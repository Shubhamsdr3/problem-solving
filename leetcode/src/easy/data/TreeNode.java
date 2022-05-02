package easy.data;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left =  null;
        right = null;
    }
    
    /**
     * Visit the left subtree
     * Visit the root
     * Visit the right subtree
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    /**
     * Visit the root
     * Visit the left subtree
     * Visit the right subtree
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * Visit the root
     * Visit the left subtree
     * Visit the right subtree
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        postOrder(root.left);
        postOrder(root.right);
    }

    /**
     * Recursive approach to insert value in Binary Search Tree
     * @param root:
     * @param key: value to be inserted
     * @return :
     */
    public TreeNode insertBST(TreeNode root, int key) {
        if (root == null) {
            // tree is empty
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val) {
            // if value is less than root value insert at left
            root.left = insertBST(root.left, key);
        }
        else if (key > root.val) {
            // if value is greater than root value , insert at right
            root.right = insertBST(root.right, key);
        }
        return root;
    }

    /**
     * Insertion in Binary tree
     * @param root
     * @param key
     */
    public TreeNode insertBinaryTree(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.poll();

            if (root.left == null) {
                root.left = new TreeNode(key);
                break;
            } else {
                q.add(root.left);
            }

            if (root.right == null) {
                root.right = new TreeNode(key);
                break;
            } else {
                q.add(root.right);
            }
        }
        return root;
    }
}
