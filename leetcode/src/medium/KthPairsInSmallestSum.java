package medium;

import java.util.*;
/**
Created at: 08/05/22
*/
public class KthPairsInSmallestSum {

    private static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] + o2[1] - o2[0] - o2[1]);
        List<int[]> list  = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return list;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            list.add(new int[]{curr[0], curr[1]});
            if (curr[2] == nums2.length -1) continue;
            pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 1, 2};
        int[] nums2 = new int[] {1, 2, 3};
        int k = 2;
        System.out.println(kSmallestPairs(nums1,nums2, k));
    }
}
