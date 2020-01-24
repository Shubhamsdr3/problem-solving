package greedyalgorithm;

import java.util.Arrays;

public class GreedyFlorist {

    private static int getMinimumCost(int k, Integer[] c) {
        // If number of friends are equal to flower
        // every one has to buy at least one.
        if (k == c.length) {
            return sum(c);
        }

        int[] count = new int[100];
        int pIndex = 0;

        Arrays.sort(c);
        int sum = 0;

        for (int i = c.length -1; i >= 0; i--) {
            sum += (count[pIndex] +1) * c[i];
            count[pIndex]++;
        }
        pIndex++;
        if (pIndex >= k) {
            pIndex = 0;
        }
        return sum;
    }

    private static int sum(Integer[] array) {
        int sum = 0;
        for (Integer val: array) {
            sum = sum + val;
        }
        return sum;
    }

    public static void main(String[] args) {
        int numberOfFriends = 3;
        Integer[] cost = new Integer[]{1, 3, 5, 7, 9};

        int numberOfFriends1 = 2;
        Integer[] cost1 = new Integer[]{2, 5, 6};

        System.out.println(getMinimumCost(numberOfFriends, cost));
    }
}
