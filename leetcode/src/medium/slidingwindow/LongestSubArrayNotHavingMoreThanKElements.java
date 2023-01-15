package medium.slidingwindow;

import java.util.*;

public class LongestSubArrayNotHavingMoreThanKElements {

    /**
     * T.C -> O(N)
     * S.C -> O(N)
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> findLongestSubArrayUsingTwoPointers(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int[] count = new int[7];
        int start = 0;
        int end = 0;
        int curr = 0;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
            if (count[arr[i]] == 1) {
                curr++;
            }
            while (curr > k) {
                count[arr[left]]--;
                if (count[arr[left]] == 0) {
                    curr--;
                }
                left++;
            }
            if (i - left + 1 >= end - start + 1) {
                end = i;
                start = left;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
     }

    /**
     * T.C = O(n * k)
     * @param arr
     * @param k
     * @return
     */
    private static int findLongestSubArray(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        while (i < arr.length && j < arr.length) {
            Set<Integer> set = new HashSet<>();
            while (j < arr.length && set.size() < k) {
                set.add(arr[j]);
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            set.clear();
            i++;
            j = i+1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 5, 1, 2, 3, 2, 1, 4, 5 };
        int k = 3;

        int[] arr1 = new int[] { 1, 2, 3, 4, 5};
        int k1 = 6;

        int[] arr2 = new int[] {1, 2, 1, 2, 3};
        int k2 = 2;

        int[] arr3 = new int[] {1, 2, 3, 6, 3, 3, 2, 1, 4, 5};
        int k3 = 3;
        System.out.println(findLongestSubArrayUsingTwoPointers(arr3, k3));
    }
}
