package greedyalgorithm;

import java.util.Arrays;

public class MarkAndToys {

    // Complete the maximumToys function below.
    private static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int numberOfToys = 0;
        int i = 0;
        while (k >= prices[i]) {
            numberOfToys++;
            k = k - prices[i];
            i++;
        }
        return numberOfToys;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 12, 5, 111, 200, 1000, 10};
        System.out.println(maximumToys(prices, 50));
    }
}
