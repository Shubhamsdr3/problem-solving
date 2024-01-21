package problemsolving.leetcode75.heap;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubsequenceScore {

    private static long maxScore(int[] nums1, int[] nums2, int k) {
//        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            subsequence(nums1, i, new ArrayList<>());
        }
        return 0;
    }

    /**
     * O(2^n) * n
     * @param nums1
     * @param i
     * @param path
     */

    private static void subsequence(int[] nums1, int i, List<Integer> path) {
        if (i >= path.size()) {
            System.out.println(new ArrayList<>(path));
            return;
        }
        path.add(nums1[i]); // take
        subsequence(nums1, i + 1, path);
        path.remove(nums1[i]); // don't take.
        subsequence(nums1, i + 1, path);
    }

    public static void main(String[] args) {
        int[] num1 = new int[] { 1, 3, 3, 2 };
        int[] num2 = new int[] { 2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(num1, num2, k));
    }
}
