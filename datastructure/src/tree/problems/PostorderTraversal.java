package tree.problems;

import tree.TreeNode;

public class PostorderTraversal {

        private static void postOrder(TreeNode root) {
          if (root == null) {
              return;
          } else {
              postOrder(root.left);
              postOrder(root.right);
              System.out.print(root.data);
          }
        }

        private static TreeNode insert(TreeNode root, int data) {
            if(root == null) {
                return new TreeNode(data);
            } else {
                TreeNode cur;
                if(data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 3, 4, 6};
        TreeNode root = null;
        for (int value : arr) {
            root = insert(root, value);
        }
        postOrder(root);
    }
}
