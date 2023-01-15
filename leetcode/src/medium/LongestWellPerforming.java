package medium;

import java.util.Map;

public class LongestWellPerforming {

    private static int longestWPI(int[] hours) {
        int tiring = 0;
        int nonTiring = 0;
        int n = hours.length;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) {
                tiring++;
            } else {
                nonTiring++;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] hours = new int[] { 9, 9, 6, 0, 6, 6, 9 };
        System.out.println(longestWPI(hours));
    }
}
