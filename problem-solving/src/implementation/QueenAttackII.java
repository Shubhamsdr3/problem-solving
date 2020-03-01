package implementation;

public class QueenAttackII {

    /**
     * @param n : an integer, the number of rows and columns in the board
     * @param k : an integer, the number of obstacles on the board
     * @param r_q: integer, the row number of the queen's position
     * @param c_q:  integer, the column number of the queen's position
     * @param obstacles:  a two dimensional array of integers where each element is an array of  integers, the row and column of an obstacle.
     * @return
     */
    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        int side = 4;
        int nObstacle = 0;
        int rowQueen = 4;
        int colQueen = 4;
        int[][] obstacles = new int[][] {
//                {5, 5},
//                {4, 2},
//                {2, 3}
        };
        System.out.println(queensAttack(side, nObstacle, rowQueen, colQueen, obstacles));
    }

}
