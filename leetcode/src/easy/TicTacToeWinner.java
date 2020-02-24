package easy;

import java.util.Arrays;

public class TicTacToeWinner {

    //TODO:SHUBHAM
    private static String tictactoe(int[][] moves) {
        char[][] cell = new char[3][3];
        boolean isFirstPlayer = true;
        for (int i= 0; i < moves.length; i++) {
            int[] point = moves[i];
            if (isFirstPlayer) {
                cell[point[0]][point[1]] = 'X';
                isFirstPlayer = false;
            } else {
                cell[point[0]][point[1]] = 'O';
                isFirstPlayer = true;
            }
        }

        System.out.println(Arrays.deepToString(cell));

        //check for rows
        int countA = 0;
        int countB = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (cell[row][col] == 'X') {
                    countA++;
                } else if (cell[row][col] == 'O') {
                    countB++;
                }
            }
        }
        if (countA == 3) {
            return "A";
        } else if (countB == 3) {
            return "B";
        }
        return "";
    }

    public static void main(String[] args) {
        int[][] moves = new int[][] {
                {0, 0},
                {2, 0},
                {1, 1},
                {2, 1},
                {2, 2}
        };
        System.out.println(tictactoe(moves));
    }
}
