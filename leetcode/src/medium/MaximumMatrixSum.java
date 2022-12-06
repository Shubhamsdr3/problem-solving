package medium;

public class MaximumMatrixSum {

    /**
     * If count of negative number is even: then all elements can be made +ve by
     * performing the operation..i.e total sum of matrix.
     * If count of negatives is odd , then we can make the smallest number in the matrix
     * as negative and then return the sum.
     * @param matrix
     * @return
     */
    private static long maxMatrixSum1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int countNegative = 0;
        long sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = matrix[i][j];
                min =  Math.min(min, Math.abs(val)); // smallest absolute value in the matrix
                if (val < 0) {
                    countNegative++;
                }
                sum = sum + Math.abs(val);
            }
        }
        if (countNegative % 2 == 0) {
            return sum;
        } else  {
            return sum - 2L * min;
        }
    }

    /**
     * First check row wise and then column wise.
     * @param matrix
     * @return
     */
    private static long maxMatrixSum(int[][] matrix) {
        int sum1 = 0;
        int sum2 = 0;
        int firstNegative = 0;
        int secondNegative = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i]; // for rows
            for (int j = 0; j < row.length; j++) {
                if (row[j] < row[firstNegative]) {
                    secondNegative = firstNegative;
                    firstNegative = j;
                } else if (row[j] < row[secondNegative] && row[j] != row[firstNegative]) {
                    secondNegative = j;
                }
                if (j != firstNegative || j != secondNegative) {
                    sum1 = sum1 + row[j];
                }
            }
            row[firstNegative] = Math.abs(row[firstNegative]);
            row[secondNegative] = Math.abs(row[secondNegative]);
            sum1 = sum1 + row[firstNegative] + row[secondNegative];
            // for columns:
            firstNegative = 0;
            secondNegative = 0;
            for (int j = 0; j < matrix.length; j++) {
                int element = matrix[j][i];
                sum2 = sum2 + element;
                if (row[j] < row[firstNegative]) {
                    secondNegative = firstNegative;
                    firstNegative = j;
                } else if (row[j] < row[secondNegative] && row[j] != row[firstNegative]) {
                    secondNegative = j;
                }
            }
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, -1}, {-1, 1}};
        int[][] arr1 = new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        int[][] arr2 = new int[][]{{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}};
        System.out.println(maxMatrixSum1(arr1));
    }
}
