package medium;

import java.util.PriorityQueue;

public class HandOfStraights {

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: hand) pq.add(num);
        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            for (int i = 0; i < groupSize; i++) {
                if (!pq.contains(smallest + i)) return false;
                else pq.remove(smallest + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        int groupSize = 4;
        System.out.println(isNStraightHand(arr, groupSize));
    }
}
