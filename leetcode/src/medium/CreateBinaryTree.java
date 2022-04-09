package medium;

import easy.data.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTree {

    private static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[0];
            int child = arr[1];
            int isLeft = arr[2];
            TreeNode root = map.getOrDefault(parent, new TreeNode(parent)); // if root already exist.
            children.add(child);
            if (isLeft == 1) {
                root.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, root.left);
            } else {
                root.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, root.right);
            }
            map.put(parent, root);
        }

        int root = -1;
        for (int[] arr: descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }
        return map.getOrDefault(root, null);
    }

    public static void main (String[]args){
        int[][] descriptions = new int[][] {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };
        TreeNode root  = createBinaryTree(descriptions);
        root.preOrder(root);
    }
}
