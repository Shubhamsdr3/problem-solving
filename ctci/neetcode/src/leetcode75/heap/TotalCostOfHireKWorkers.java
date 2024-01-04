package leetcode75.heap;

import java.util.PriorityQueue;

public class TotalCostOfHireKWorkers {

    private static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int i = 0;
        int j = costs.length - 1;
        long cost = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.add(costs[i++]);
            }

            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            // chose minimum from the left and right queue.
            int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                cost = cost + t1;
                pq1.poll();
            } else {
                cost = cost + t2;
                pq2.poll();
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 4, 1};
        int k = 3;
        int candidates = 3;

        int[] arr1 = new int[] { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        int k1 = 3;
        int candidates1 = 4;

        int[] arr2 = new int[] {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        int k2 = 11;
        int candidates2 = 2;
        System.out.println(totalCost(arr2, k2, candidates2));
    }
}
