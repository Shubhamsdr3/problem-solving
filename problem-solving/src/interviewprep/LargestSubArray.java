package interviewprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {

    /**
     * TC = O(n2)
     * @param arr
     * @return
     */
    private static int largestSubarrayWithEqualNumberOf0And1s(int[] arr) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int numberOf1s = 0;
            int numberOf0s = 0;
            for (int j = i; j < arr.length; j++) {
                 if (arr[j] == 0) {
                     numberOf0s++;
                 } else if (arr[j] == 1) {
                     numberOf1s++;
                 }
                 if (numberOf0s == numberOf1s) {
                     maxLength = Math.max(maxLength, j - i);
                 }
            }

        }
        return maxLength;
    }

    //TODO: improve this.
    private static int largestSubarrayWithEqualNumberOf0And1sUsingHashMap(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 1) +1);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                1, 0, 1, 1, 1, 0, 0
        };
        System.out.println(largestSubarrayWithEqualNumberOf0And1s(arr));
    }
}
