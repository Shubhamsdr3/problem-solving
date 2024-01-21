package problemsolving.leetcode75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheMissingNumber {

    /**
     * Using XOR
     * @param arr
     * @return
     */
    private static int findMissingNumber6(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ i + 1;
        }
        return res;
    }

    /**
     * find the sum of N-natural numbers.
     * sum of N natural number = (n + 1) * (n + 2) / 2
     * n -> n + 1 (bcz 1 number is missing)
     * T.C ->
     * @param arr
     * @return
     */
    private static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int totalSum = (n + 1) * (n + 2) / 2;
        for (int i = 0; i < n; i++)
            totalSum = totalSum - arr[i];
        return totalSum;
    }

    /**
     * Find the missing elements in the array given from 1..N.
     * Using hashing.
     * @param arr
     * @return
     */
    private static int findMissingNumber5(int[] arr, int n) {
        Map<Integer, Integer> hash = new HashMap();
        for (int num: arr) {
            hash.put(num, 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!hash.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Using sorting
     * @param arr
     * @return
     */

    private static int findMissingNumber4(int[] arr) {
        int n = arr.length;
        int res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                res = res + (i + 1);
                break;
            }
        }
        if (res == 0) {
            res = n;
        }
        return res;
    }

    private static int findMissingNumber3(int[] arr) {
        int total = 1;
        int n = arr.length;
        for (int i = 2; i < (n + 1); i++) {
            total = total + i;
            total = total - arr[i - 2];
        }
        return total;
    }

    /**
     * Find the missing number in an array from 1..n
     */
    private static int findMissingNumber2(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n + 1];
        Arrays.fill(temp, 0);
        for (int i = 0; i < n; i++) {
            temp[arr[i] - 1] = 1;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (temp[i] == 0) {
                ans = i + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 9};
        int n = 9;
        System.out.println(findMissingNumber6(arr));
    }
}
