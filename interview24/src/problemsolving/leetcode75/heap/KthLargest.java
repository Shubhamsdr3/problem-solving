package problemsolving.leetcode75.heap;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int num: nums) {
            pq.add(num);
        }
    }

    public int add(int val) {
       if(pq.size() < k) {
           pq.offer(val);
       } else if (pq.peek() < val) {
           pq.poll();
           pq.offer(val);
       }
       return pq.peek();
    }
}
