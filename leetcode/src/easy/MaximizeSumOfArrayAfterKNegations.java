package easy;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {

    private static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x: nums) {
            pq.add(x);
        }
        while (k-- > 0) {
            pq.add(-pq.poll());
        }
        int sum = 0;
        for (int i =0; i < nums.length; i++) {
            sum = sum + pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, -3, -1, 5, -4};
        int k = 2;
        int[] arr1 = new int[]{3, -1, 0, 2};
        int k1 = 3;
        int[] arr2 = new int[]{4, 2, 3};
        int k2 = 1;
        int[] arr3 = new int[]{ -2, 9, 9, 8, 4};
        int k3 = 5;
        System.out.println(largestSumAfterKNegations(arr, k));
        System.out.println(largestSumAfterKNegations(arr1, k1));
        System.out.println(largestSumAfterKNegations(arr2, k2));
        System.out.println(largestSumAfterKNegations(arr3, k3));
    }
}
