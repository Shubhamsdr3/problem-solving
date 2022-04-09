package medium;

import easy.data.TreeNode;

public class StepByStepDirection {

    private static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, dest);
        start.reverse();
        dest.reverse();
        while (start.length() > 0 && dest.length() > 0 && start.charAt(0) == dest.charAt(0)) {
            start.deleteCharAt(0);
            dest.deleteCharAt(0);
        }
        return "U".repeat(start.length()) + dest;
    }

    private static boolean find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) return true;
        if (root.left != null && find(root.left, val, sb)) {
            sb.append("L");
            return true;
        }
        if (root.right != null && find(root.right, val, sb))  {
            sb.append("R");
            return true;
        }
        return false;
    }

    /**
     *
     */

    private static String getDirectionUsingLCA(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder toStart = new StringBuilder();
        StringBuilder toEnd = new StringBuilder();
        traverse(lca, startValue, toStart);
        traverse(lca, destValue, toEnd);
        String s = "U";
        s = s.repeat(toStart.length());
        return s + toEnd;
    }

    /**
     * TC: O(n)
     * @param root
     * @param start
     * @param end
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, int start, int end) {
        if (root == null) return null;
        if (root.val == start || root.val == end) return root;
        TreeNode left = lowestCommonAncestor(root.left, start, end);
        TreeNode right = lowestCommonAncestor(root.right, start, end);
        if (left != null && right != null) return right;
        if (left == null && right == null) return null;
        return left != null ? left: right;
    }

    private static boolean traverse(TreeNode start, int dest, StringBuilder sb) {
        if (start == null) return false;
        if (start.val == dest) return true;
        sb.append('L');
        if (traverse(start.left, dest, sb)) return true;
        sb.setCharAt(sb.length() -1, 'R');
        if (traverse(start.right, dest, sb)) return true;
        else sb.setLength(sb.length() -1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirectionUsingLCA(root, 3, 6));
    }
}
