package interviewprep;

import java.util.List;

public class ProductDefects {

    public static int printMaxSubSquare(int[][] samples) {
        
        int[][] dp = new int[samples.length][samples[0].length];
        int ans = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length-1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = samples[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = samples[i][j];
                } else if (j == dp[0].length -1) {
                    dp[i][j] = samples[i][j];
                } else  {
                    if (samples[i][j] == 0) {
                        dp[i][j] = 0;
                    } else  {
                        int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                        min = Math.min(min, dp[i +1][j+1]);
                        dp[i][j] = min + 1;

                        if (dp[i][j] > ans) {
                            ans = dp[i][j];
                        }
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println(printMaxSubSquare(M));
    }
}
