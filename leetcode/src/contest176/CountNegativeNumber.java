package contest176;

public class CountNegativeNumber {

    private static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = grid[i].length-1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(ints));
    }
}
