package medium.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Find longest subarray where absolute difference
 * between any two element is not greater than k.
 */
public class LongestSubArrayWithAbsoluteDifference {

    private static int findLongestSubArray(int[] arr, int x) {
        int start = 0;
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (start < arr.length) {
            int slider = start + 1;
            while (slider < arr.length) {
                int diff = Math.abs(arr[start] - arr[slider]);
                if (diff <= x) {
                    slider++;
                }
            }
            max = Math.max(max, slider - start);
            start++;
            slider = start + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 8, 4, 2, 6, 7 };
        int x = 4;
        System.out.println(findLongestSubArray(arr, x));
    }
}
