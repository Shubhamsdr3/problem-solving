package problemsolving.leetcode75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {

    /**
     * Every row has a queen.
     * Every column has a queen.
     * The queens shouldn't attack each-other.
     * @param n
     * @return
     */
    private static int totalNQueens(int n) {
        List<List<String>> ans =  new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, board, ans, n);
        return ans.size();
    }

    private static void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars: board) {
                StringBuilder sb = new StringBuilder();
                for (char ch: chars) {
                    sb.append(ch);
                }
                list.add(sb.toString());
            }
            ans.add(list);
        }
        for (int row = 0; row < n && col < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;

        // check diagonal
        while (row < n && col < n && row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // check the columns
        while (col >= 0 && row < n && col < n) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // check the rows
        while (col >= 0 && col < n && row >=0 && row < n) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
