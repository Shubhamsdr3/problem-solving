package leetcode75.graph;

import java.util.*;

public class SurroundedRegions {

    /**
     * Start from the boundary '0's.
     * and convert all connected zero to X.
     * TC:
     *  Running boundary -> O(n)
     *  DFS = O(n * m)
     *
     * S.C => O(n * m)
     * @param board
     */
    private static void solve(char[][] board) {
        // bounds
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        // mark the rows boundary Os to X
        for (int j = 0; j < row; j++) {
            // fist row
            if (!visited[0][j]  && board[0][j] == 'O') {
                dfs(board, 0, j, visited);
            }
            // last row.
            if(!visited[row - 1][j] && board[row - 1][j] == 'O') {
                dfs(board, row - 1, j, visited);
            }
        }

        // mark the col boundary Os to X.
        for (int i = 0; i < col; i++) {
            if(!visited[0][i] && board[0][i] == 'O') {
                dfs(board, i, 0, visited);
            }

            if(!visited[col - 1][i] && board[col - 1][i] == 'O') {
                dfs(board, i, col - 1, visited);
            }
        }

        // mark the remaining Os to Xs.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r > board.length -1 || c > board[0].length -1) return;
        if (board[r][c] == 'X') return;
        visited[r][c] =  true;
        //check for all direction.
        dfs(board, r + 1, c, visited);
        dfs(board, r - 1, c, visited);
        dfs(board, r, c + 1, visited);
        dfs(board, r, c - 1, visited);
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'x', 'x', 'x', 'x'},
                {'x', 'O', 'O', 'x'},
                {'x', 'x', 'O', 'x'},
                {'x', 'O', 'x', 'x'},
        };
        solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
