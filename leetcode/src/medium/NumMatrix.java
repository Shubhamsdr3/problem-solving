package medium;

class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        matrix = new int[row + 1][col +1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i -1][j] + matrix[i][j -1] + matrix[i -1][j-1] - matrix[i -1][j -1];
            }
        }
    }

    private int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    /**
     *
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    private int sumRegionUsingDP(int row1, int col1, int row2, int col2) {
       row1++;
       col1++;
       row2++;
       col2++;
       return matrix[row2][col2] - matrix[row1 -1][col2] - matrix[row2][col1 -1] + matrix[row1 -1][col1 -1];
    }


    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix matrix = new NumMatrix(arr);
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
    }
}