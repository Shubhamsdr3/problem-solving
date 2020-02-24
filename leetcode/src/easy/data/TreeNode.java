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


    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void insert(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.peek();
            q.remove();

            if (root.left == null) {
                root.left = new TreeNode(key);
                break;
            } else
                q.add(root.left);

            if (root.right == null) {
                root.right = new TreeNode(key);
                break;
            } else
                q.add(root.right);
        }
    }

}
