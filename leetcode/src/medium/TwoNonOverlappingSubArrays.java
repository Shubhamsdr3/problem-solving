package medium;

import java.util.*;

public class TwoNonOverlappingSubArrays {


    private static int minSumOfLengthsImproved(int[] arr, int target) {
        int[] left = new int[arr.length];
        int sum = 0;
        int best = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (map.containsKey(sum - target)) {
                best = Math.min(best, i - map.get(sum - target));
            }
            left[i] = best;
            map.put(sum, i);
        }

        // for right subarray
        int[] right = new int[arr.length];
        sum = 0;
        map = new HashMap<>();
        map.put(0, arr.length);
        for (int i = arr.length -1; i >= 0; --i) {
            sum = sum + arr[i];
            if (map.containsKey(sum - target)) {
                best = Math.min(best, map.get(sum - target) - i);
            }
            right[i] = best;
            map.put(sum, i);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (left[i -1] != Integer.MAX_VALUE && right[i] != Integer.MAX_VALUE) {
                result = Math.min(result, left[i -1] + right[i]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int minSumOfLengths(int[] arr, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();
        findSubArrays(arr, 0, 0, target, subArrays);
        System.out.println(subArrays);
        if (subArrays.size() >= 2) {
            subArrays.sort(Comparator.comparingInt(List::size));
            return subArrays.get(0).size() + subArrays.get(1).size();
        }
        return -1;
    }

    /**
     * T.C -> O(2^n)
     * S.C -> O(2^n)
     * @param arr
     * @param start
     * @param end
     */
    private static void findSubArrays(int[] arr, int start, int end, int target, List<List<Integer>> subArrays) {
        if (end == arr.length) {
            return;
        }
        if (start > end) {
            findSubArrays(arr, 0, end + 1, target, subArrays);
        } else {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                sum = sum + arr[i];
                list.add(arr[i]);
            }
            if (sum == target) {
                subArrays.add(list);
            }
            findSubArrays(arr, start + 1, end, target, subArrays);
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[] { 7, 3, 4, 7 };
//        int target = 7;
//        System.out.println(minSumOfLengths(arr, target));
//
//        int[] arr1 = new int[] { 3, 2, 2, 4, 3 };
//        int target1 = 3;
//        System.out.println(minSumOfLengths(arr1, target1));
//
//        int[] arr2 = new int[] { 4, 3, 2, 6, 2, 3, 4 };
//        int target2 = 6;
//        System.out.println(minSumOfLengths(arr2, target2));

        int[] arr3 = new int[] { 1, 6, 1 };
        int target3 = 7;
        System.out.println(minSumOfLengthsImproved(arr3, target3));
    }
}
