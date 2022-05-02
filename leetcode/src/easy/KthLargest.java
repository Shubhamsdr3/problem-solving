package easy;

import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private int[] nums;

    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums) {
            pq.add(num);
        }
    }


    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
    }
}
