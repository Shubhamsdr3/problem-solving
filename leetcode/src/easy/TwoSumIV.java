package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIV {

    private static boolean findTarget(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(list, root);
        int start = 0;
        int end = list.size() -1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    private static void inOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(list, root.left);
        list.add(root.val);
        inOrderTraversal(list, root.right);
    }

    /**
     * using HahTable
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null) {
            return false;
        }
        if(set.contains(k - root.val)) { // #THE_CATCH
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public static void main(String[] args) {
        int target = 6;
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, target));
    }
}
