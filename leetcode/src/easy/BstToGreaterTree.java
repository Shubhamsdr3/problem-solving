package easy;

import easy.data.TreeNode;

public class BstToGreaterTree {

    //FIXME: Don't use static variable here, it's dangerous
    private int sum = 0;

    private TreeNode convertBST(TreeNode root) {
        convertBsT(root);
        return root;
    }

    private void convertBsT(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBsT(root.right);
        root.val = root.val + sum;
        sum = root.val;
        convertBsT(root.left);
    }

    private static int findGreatest(TreeNode root) {
       if (root == null) {
           return 0;
       }
       if (root.right == null) {
           return root.val;
       }
       return findGreatest(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(13);
        BstToGreaterTree bst = new BstToGreaterTree();
        System.out.println(bst.convertBST(root1).val);
    }
}
