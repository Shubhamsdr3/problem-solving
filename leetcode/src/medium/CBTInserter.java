package medium;

import easy.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Complete binary tree, where each level except the last has 2^l nodes,
 * and nodes at the last level are left-aligned.
 */

public class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    /**
     * T.C -> O(n)
     * @param val
     * @return
     */
    public int insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode current = queue.poll();
            if (current.right != null) {
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                } else {
                    current.right = new TreeNode(val);
                }
                return current.val;
            }
        }
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        CBTInserter obj = new CBTInserter(root);
        obj.insert(3);
        obj.insert(4);
        obj.get_root().preOrder(obj.get_root());
    }
}
