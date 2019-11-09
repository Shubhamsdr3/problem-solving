package greedyalgorithm;

import java.util.Arrays;

public class MinimumCandies {

    // Complete the candies function below.
    private static long candies(int n, int[] arr) {
        // Sort according to their rating.
        int numberOfCandies = 1; // for the first one.
        int result =  1;
        for (int i=1; i < arr.length; i++) {
            if(arr[i] > arr[i -1]) {
                numberOfCandies ++;
            } else {
                numberOfCandies --;
            }
            if (arr[i] == arr[i - 1]) {
                if (numberOfCandies > 1) {
                    numberOfCandies -- ;
                } else {
                    numberOfCandies ++;
                }
            }
            result = result + numberOfCandies;
        }
        return result;
    }

    /**
     * We can divide the children in below categories.
     * if rating[i-1] >= rating[i] <= rating[i+1] , we say Child  is a valley.
     * If rating[i-1] < rating[i] <= rating[i+1], we say Child  is a rise.
     * If rating[i-1] >= rating[i] >= rating[i+1], we say Child  is a fall.
     * If rating[i-1] < rating[i] > </>rating[i+1], we say Child  is a peak.
     * Based on the above categorization we can distribute the candies as below:
     *
     * For each valley child, give him/her 1 candy.
     * For each rise child, give him/her C[i-1] +1 candies.
     * For each fall child, give him/her C[i+1] +1  candies.
     * For each peak child, give him/her Max(C[i-1], C[i+1]) candies.
     *
     * 1. Distribute the candies to the valleys.
     * 2. Distribute the candies to the rises from left to right.
     * 3. Distribute the candies to the falls from right to left.
     * 4. Distribute the candies to the peaks.
     * Note that the order in which we distribute candies to rises and falls is pretty important!
     *
     * @param n
     * @param rating
     * @return
     */

    public static long candies1(int n, int[] rating) {
         int[] dp = new int[rating.length];
        // Distribute the 1 candies to the valley children.
        Arrays.fill(dp, 1);
         for (int i=1; i< rating.length; i++) {
             if (rating[i] > rating[i-1]) {
                 // Distribute the candies to the rising children
                 dp[i] = dp[i-1] +1;
             }
         }
         for (int i = rating.length-2; i >= 0; i-- ) {
             if (rating[i] > rating[i +1]) {
                 // Distribute the candies to the rising falling children
                 dp[i] = Math.max(dp[i] +1, dp[i+1]);
             }
         }

         // find the sum of the array.
         long sum = 0;
        for (int i : dp) {
            sum = sum + i;
        }
         return sum;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        System.out.println(candies1(10, inputArray));
    }
}
