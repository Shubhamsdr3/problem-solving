package interviewprep_23.array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    /**
     * Sorting -> O(mlogn) + O(nlogn)
     * @param nums1
     * @param nums2
     * @return
     */
    private static List<Integer> intersectTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        while (start < nums1.length  && end < nums2.length) {
            if (nums1[start] < nums2[end]) {
                start++;
            } else if (nums1[start] > nums2[end]) {
                end++;
            } else {
                // they are equal
                result.add(nums1[start]);
                start++;
                end++;
            }
        }
        return result;
    }

    /**
     * T.C -> O(m + n)
     * @param nums1
     * @param nums2
     * @return
     */
    private static List<Integer> intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) -1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1= new int[]{ 1, 2, 2, 1 };
        int[] nums2 = new int[]{2, 2 };
        System.out.println(intersectTwoPointers(nums1, nums2));

        int[] nums3 = new int[]{ 4, 9, 5 };
        int[] nums4 = new int[]{ 9, 4, 9, 8, 4 };
        System.out.println(intersectTwoPointers(nums3, nums4));
    }
}
