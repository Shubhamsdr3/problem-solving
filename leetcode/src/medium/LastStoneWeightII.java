package medium;

import java.util.Arrays;

public class LastStoneWeightII {

    /**
     * My version// wrong
     * @param stones
     * @return
     */
    private static int lastStoneWeightII(int[] stones) {
        for (int i = 0; i < stones.length; i++) {
            int num1 = stones[i];
            if (num1 > 0) {
                int minDiff = Integer.MAX_VALUE;
                int endIndex = 0;
                for (int j = 0; j < stones.length; j++) {
                    if (i != j) {
                        int num2 = stones[j];
                        if (num2 > 0) {
                            int diff = Math.abs(num2 - num1);
                            if (diff < minDiff) {
                                minDiff = diff;
                                endIndex = j;
                            }
                        }
                    }
                }
                stones[i] = minDiff;
                stones[endIndex] = 0;
            }
        }
        for (int item : stones) {
            if (item > 0) {
                return item;
            }
        }
        return -1;
    }

    /**
     * 
     * @param stones
     * @return
     */
    private static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int sum = 0;
        for (int stone: stones) {
            sum = sum + stone;
        }
        int nearToFind = sum /2;
        Integer[][] dp = new Integer[stones.length][nearToFind + 1];
        int nearest = nearest(stones, stones.length -1, nearToFind, dp);
        return sum - 2 * nearest;
    }

    private static int nearest(int[] stones, int idx, int nearToFind, Integer[][] dp) {
        if (nearToFind == 0 || idx < 0) return 0;
        if (dp[idx][nearToFind] != null) return dp[idx][nearToFind];
        int stone = stones[idx];
        int max = nearest(stones, idx -1, nearToFind, dp);
        if (stone <= nearToFind) max = Math.max(max, stone + nearest(stones, idx -1, nearToFind - stone, dp));
        dp[idx][nearToFind] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }
}
