package searchalgorithm;

/**
 * Solve this ????
 */
public class ConnectedCells {

    private static int rows;
    private static int cols;

    // Complete the connectedCell function below.
    private static int connectedCell(int[][] matrix) {
        int maxRegion = 0;

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int size = findLargestRegion(matrix, i , j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int findLargestRegion(int[][] grid, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        } else if (grid[row][col] == 0) {
            return 0;
        }
        return 0;
    }
}
