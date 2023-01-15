package medium;

import kotlin.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumEatenApple {

    /**
     *
     * @param apples
     * @param days
     * @return
     */
    private static int maximumEatenApple(int[] apples, int[] days) {
        int n = apples.length;
        // Pair(apple count, expiry date)
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair<Integer, Integer>::getSecond));
        int numberOfApples = 0;
        for (int i = 0; i < n || !pq.isEmpty(); i++) {
            if (i < n && apples[i] != 0) {
                pq.offer(new Pair<>(apples[i], i + days[i])); // store the apples with it's validity.
            }
            while (!pq.isEmpty() && pq.peek().getSecond() <= i) { // spoiled apples, so remove
                pq.poll();
            }
            if (!pq.isEmpty()) {
                numberOfApples++;
                int remainingApples = pq.peek().getFirst();
                if (--remainingApples == 0) { // remove if no apples left in the tray
                    pq.poll();
                }
            }
        }
        return numberOfApples;
    }

    public static void main(String[] args) {
        int[] apples = new int[] { 1, 2, 3, 5, 2 };
        int[] days = new int[] { 3, 2, 1, 4, 2 };
        System.out.println(maximumEatenApple(apples, days));
    }
}
