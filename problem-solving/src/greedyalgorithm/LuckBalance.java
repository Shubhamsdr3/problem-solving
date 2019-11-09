package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LuckBalance {

    /**
     * If Lena wins the contest, her luck balance will decrease by Luck[i].
     * @param k: The number of important contest that Lena can lose.
     * @param contests : Number of contest with their importance.
     * @return : Maximum number of luck Lena can have.
     */
    private static int luckBalance(int k, int[][] contests) {
        // Sort the array based on luck balance
        Arrays.sort(contests, (o1, o2) -> o2[0] - o1[0]);

        int numberOfImportantContest = 0;
        for (int i=0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                numberOfImportantContest ++;
            }
        }

        // Total luck balance.
        int luckBalance = 0;
        int numberOfContestToWin = numberOfImportantContest - k;
        for (int j=0; j < contests.length ; j++) {
            luckBalance = luckBalance + contests[j][0];
        }

        int negativeBalance = 0;
        for (int j = contests.length -1; j > 0; j--) {
            if (numberOfContestToWin != 0) {
                negativeBalance = negativeBalance + contests[j][0] + contests[j][0];
                numberOfContestToWin --;
            }
        }

        return luckBalance - negativeBalance;
    }

    private static int luckBalance1(int k, int[][] contests) {
        // Elements with decreasing order of luck.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(obj -> obj));

        int numLuck = 0;
        int totalImportant = 0;

        for(int[] contest : contests){
            numLuck = numLuck + contest[0]; // Total luck
            if(contest[1] == 1){
                minHeap.offer(contest[0]);
                totalImportant++;
            }
        }
        for(int i = 0; i < totalImportant - k; i++){
            numLuck = numLuck -  2 * minHeap.poll();
        }
        return numLuck;
    }

    public static void main(String[] args) {
        int[][] contests = new int[][] {
                {3, 1},
                {13, 1},
                {21, 1},
                {31, 1},
                {17, 1},
                {20, 1},
                {8, 1},
                {12, 0},
                {14, 0},
                {21, 1}
        };

        System.out.println(luckBalance1(3, contests));
    }
}
