package easy;

public class CountNegativeNumbers {

    private static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row: grid) {
            for (int val: row) {
                if (val < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countNegatives1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = n-1;
        int count = 0;
        while (row < m && col > 0) {
            if (grid[row][col] < 0) {
                --col;
                count = col + m - row;
            } else  {
                ++row;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {4,3,2,-1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(countNegatives(arr));
    }
}
