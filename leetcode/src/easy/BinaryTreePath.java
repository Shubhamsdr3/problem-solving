package easy;

import easy.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findPath(root, list, sb);
        return list;
    }

    private static void findPath(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        } else {
            sb.append("->");
            findPath(root.left, list, sb);
            findPath(root.right, list, sb);
        }
        sb.setLength(len);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }
}
