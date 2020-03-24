package medium;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBinaryTree {

    /**
     * We perform the in-order traversal on a binary
     * tree we get the element in sorted order.
     * @param root
     * @return
     */
    private static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        performInorder(list, root);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1))  {
                return false;
            }
        }
        return true;
    }

    private static void performInorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        performInorder(list, root.left);
        list.add(root.val);
        performInorder(list, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.insertBST(root, 5);
        root.insertBST(root, 15);
        root.insertBST(root, 6);
        root.insertBST(root, 20);
        System.out.print(isValidBST(root));
    }
}  