package leetcode75.heap;

import java.util.PriorityQueue;

public class MaximumSumArray {

    private static int maxSumArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
            sum = sum + arr[i];
        }
        int j = k + 1;
        while (j < arr.length) {
            int temp = pq.peek();
            int totalSum = sum - temp + arr[j];
            if (totalSum % 2 == 0 && totalSum > maxValue) {
                maxValue = totalSum;
                pq.poll();
            }
            j++;
        }
        return maxValue == Integer.MIN_VALUE ? -1 : maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 6, 7, 8};
        int[] arr1 = new int[] {5, 5, 1, 1, 3};
        int k = 3;
        System.out.println(maxSumArray(arr1, k)); // 18.
    }
}
