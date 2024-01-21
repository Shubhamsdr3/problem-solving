package problemsolving.leetcode75.hashmapset;

public class EqualRowAndColumnPairs {

    private static int equalPairs(int[][] grid) {
        int res = 0;
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = 0;
                while (k < n && grid[i][k] == grid[k][j]) {
                    ++k;
                }
                if (k == n) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { {3, 2, 1}, {1, 7, 6}, {2, 7, 7} };

        int[][] matrix1 = new int[][] { {3, 1, 2, 2}, {1, 4,4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2} };
        System.out.println(equalPairs(matrix1));
    }
}
