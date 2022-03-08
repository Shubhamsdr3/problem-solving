package easy;

import java.util.Arrays;

public class RelativeRank {

    private static String[] findRelativeRanks(int[] score) {
        String[] arr = new String[score.length];
        int rank = 1;
        for (int ignored : score) {
            int maxIndex = findMaxIndex(score);
            if (maxIndex >= 0) {
                score[maxIndex] = -1;
                score[maxIndex] = -1;
                if (rank == 1) {
                    arr[maxIndex] = "Gold Medal";
                } else if (rank == 2) {
                    arr[maxIndex] = "Silver Medal";
                } else if (rank == 3) {
                    arr[maxIndex] = "Bronze Medal";
                } else {
                    arr[maxIndex] = String.valueOf(rank);
                }
                rank++;
            }
        }
        return arr;
    }

    private static int  findMaxIndex(int[] arr) {
        int MAX = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] > MAX) {
                MAX = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 123123, 11921, 1, 0, 123};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
