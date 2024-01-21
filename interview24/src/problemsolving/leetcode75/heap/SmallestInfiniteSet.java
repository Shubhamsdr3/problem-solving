package problemsolving.leetcode75.heap;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {

    PriorityQueue<Integer> pq;
    int smallest = 1;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
    }

    public int popSmallest() {
        if(!pq.isEmpty()) return pq.poll();
        return smallest++;
    }

    public void addBack(int num) {
        if(num < smallest && !pq.contains(num)) pq.add(num);
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
