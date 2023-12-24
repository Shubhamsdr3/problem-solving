package interviewprep_23.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEatenApples {

    private static int eatenApples(int[] apples, int[] days) {
        int count = 0;
        int n = apples.length;
        PriorityQueue<Fruit> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.validDays));

        for (int i = 0; i < n || !queue.isEmpty(); ++i) {  // !queue.isEmpty() cos we need to continue even after n
            if (i < n) {
                queue.offer(new Fruit(apples[i], i + days[i]));
            }
            while (!queue.isEmpty() && queue.peek().validDays <= i) { // spoiled apples, so remove the tray
                 queue.poll();
            }

            if (!queue.isEmpty()) {
                ++count;
                if (--queue.peek().numberOfApples == 0) { // remove if no apples on this tray
                    queue.poll();
                }
            }
        }
        return count;
    }


    static class Fruit {
        int numberOfApples;
        int validDays;

        Fruit(int numberOfApples, int validDays) {
            this.numberOfApples = numberOfApples;
            this.validDays = validDays;
        }
    }

    public static void main(String[] args) {
        int[] apples = new int[] { 1, 2, 3, 5, 2 };
        int[] days = new int[] { 3, 2, 1, 4, 2 };
        System.out.println(eatenApples(apples, days));
    }
}
