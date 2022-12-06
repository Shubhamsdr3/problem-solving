package medium;

import java.util.Arrays;

public class PartitionArrayForMaxSum {

    private static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int i = n - 1;
        int sum = 0;
        Arrays.sort(arr);
        while (n > 0) {
            int num = arr[i];
            sum = sum + (num * k);
            n = n - k;
            i--;
            if (n <= k) {
                k = n;
            }
        }
        return sum;
    }

    private static int maxSumAfterPartitioning1(int[] arr, int k) {
        int[] memo = new int[arr.length];
        memo[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < k; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            memo[i] = (i + 1) * max;
        }

        for (int i = k; i < arr.length; i++) {
            int current = 0;
            int kIntervalMax = arr[i];
            for (int j = 1; j <= k; ++j) {
                if (arr[i - j + 1] > kIntervalMax) {
                    kIntervalMax = arr[i - j + 1];
                }
                current = memo[i - j] + j * kIntervalMax;
            }
            if (current > memo[i]) {
                memo[i] = current;
            }
        }
        return memo[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int[] arr2 = new int[]{1,4,1,5,7,3,6,1,9,9,3};
        int k1 = 4;
        System.out.println(maxSumAfterPartitioning1(arr2, k1));
    }
}
