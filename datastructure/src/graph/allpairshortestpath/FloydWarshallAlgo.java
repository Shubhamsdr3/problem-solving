package graph.allpairshortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * To find the all pair shortest path
 *
 */
public class FloydWarshallAlgo {

    private int sizeOfMatrix;

    private double[][] dp;

    private Integer[][] next;

    private static final int REACHES_NEGATIVE_CYCLE = -1;

    private FloydWarshallAlgo(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;
        this.dp = new double[sizeOfMatrix][sizeOfMatrix];
        this.next = new Integer[sizeOfMatrix][sizeOfMatrix];
    }

    private static double[][] createGraph(int n) {
        double[][] matrix = new double[n][n];
        for (int i=0; i < n; i++) {
            Arrays.fill(matrix[i], Double.POSITIVE_INFINITY);
            matrix[i][i] = 0; // fill diagonal value to 0.
        }
        return matrix;
    }

    private double[][] floydWarshall(double[][] matrix) {
        // setup
        for (int m=0; m <sizeOfMatrix; ++m) {
            for (int n=0; n< sizeOfMatrix; ++n) {
                dp[m][n] = matrix[m][n];
                if (matrix[m][n] != Double.POSITIVE_INFINITY) {
                    next[m][n] = n;
                }
            }
        }

        // Execute FW all pairs shortest pa th
        for (int k =0; k < sizeOfMatrix; ++k) {
            for (int i=0; i < sizeOfMatrix; ++i) {
                for (int j=0; j < sizeOfMatrix; ++j) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // optional: check if path is affected by negative cycle.

        for (int k =0; k < sizeOfMatrix; ++k) {
            for (int i=0; i < sizeOfMatrix; ++i) {
                for (int j=0; j < sizeOfMatrix; ++j) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = Double.NEGATIVE_INFINITY;
                        next[i][j] = REACHES_NEGATIVE_CYCLE; // just as n identifier.
                    }
                }
            }
        }

        return dp;
    }

    private List<Integer> reconstructPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        if (dp[start][end] == Double.POSITIVE_INFINITY) {
            return path;
        }
        int index = start;

        for (; index != end; index = next[index][end]) {
            if (index == REACHES_NEGATIVE_CYCLE) {
                return null;
            }
            path.add(index);
        }

        if (next[index][end] == REACHES_NEGATIVE_CYCLE) {
            return null;
        }
        path.add(end);
        return path;
    }

    public static void main(String[] args) {
        int n = 7;
        double[][] matrix = createGraph(n);
        // adding edge values to graph.

        matrix[0][1] = 2;
        matrix[0][2] = 5;
        matrix[0][6] = 10;
        matrix[1][2] = 2;
        matrix[1][4] = 11;
        matrix[2][6] = 2;
        matrix[6][5] = 11;
        matrix[4][5] = 1;
        matrix[5][4] = -2;

        FloydWarshallAlgo algo = new FloydWarshallAlgo(n);
        double[][]  shortestMatrix = algo.floydWarshall(matrix);

        for (double[] doubles : shortestMatrix) {
            for (double aDouble : doubles) {
                System.out.println(aDouble);
            }
        }
    }
}
