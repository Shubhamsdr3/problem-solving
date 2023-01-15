package medium;

import easy.data.TreeNode;

import java.util.*;

public class ClosestNodesQueries {

    private  static TreeMap<Integer, Integer> map = new TreeMap<>();

    /**
     * Using TreeMap
     * @param root
     * @param queries
     * @return
     */
    private static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root);
        for (int num: queries) {
            //if num is present add num else add lower value than num
            Integer low = map.containsKey(num) ? Integer.valueOf(num) : map.lowerKey(num);
            // if num is present add num else and higher value than num
            Integer high = map.containsKey(num) ? Integer.valueOf(num) : map.higherKey(num);
            // If low or high value also not present add -1 else low or high
            ans.add(Arrays.asList(low == null ? -1 : low, high == null ? -1 : high));
        }
        return ans;
    }

    private static void helper(TreeNode root) {
        if (root == null) return;
        map.put(root.val, 0);
        helper(root.left);
        helper(root.right);
    }

    /**
     * Using TreeSet
     * @param root
     * @param queries
     * @return
     */
    private static List<List<Integer>> closestNodesUsingTreeSet(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        List<List<Integer>> result = new ArrayList<>();
        for (int num: queries) {
            Integer min = set.lower(num + 1);
            Integer max = set.higher(num - 1);
            if (min == null) {
                min = -1;
            }
            if (max == null) {
                max = -1;
            }
            result.add(List.of(min, max));
        }
        return result;
    }

    private static void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        dfs(root.left, set);
        set.add(root.val);
        dfs(root.right, set);
    }

    /**
     * Find smallest that is greater or equal to key.
     * @param root
     * @param key
     * @return
     */
    private static int findMin(List<Integer> list, TreeNode root, int key) {
        if (root == null) return -1;
        int res = root.val;
        if (res >= key) {
            list.add(res);
            return res;
        }
        int left = findMin(list, root.left, key);
        int right = findMin(list, root.right, key);
        if (left < res) {
            res = left;
        } else if (right < res) {
            res = right;
        }
        return res;
    }

    /**
     * The greatest number that is smaller than or equal to key.
     * @param root
     * @param key
     * @return
     */
    private static int findMax(List<Integer> list, TreeNode root, int key) {
        if (root == null) return -1;
        int res = root.val;
        if (res <= key) {
            list.add(res);
            return res;
        }
        int left = findMax(list, root.left, key);
        int right = findMax(list, root.right, key);
        if (left > res) {
            res = left;
        } else if (right > res) {
            res = right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right.left = new TreeNode(14);
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
        System.out.println(closestNodesUsingTreeSet(root, queries));
    }
}
