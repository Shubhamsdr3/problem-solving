package leetcode75.backtracking;

import java.util.List;

public class WordSearch {

    /**
     * Space complexity => O(L)
     * Time => O(M * N * 4^L)
     * @param board
     * @param word
     * @return
     */
    private static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (backtrack(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, int row, int col, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[row].length) {
            return false;
        }
        if (board[row][col] != word.charAt(idx)) return false;

        board[row][col] = '#';
        boolean result = backtrack(board, row, col + 1, word, idx + 1) ||
        backtrack(board, row, col - 1, word, idx + 1) ||
        backtrack(board, row + 1, col, word, idx + 1) ||
        backtrack(board, row - 1, col, word, idx + 1);

        board[row][col] = word.charAt(idx);
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{ 'A', 'B', 'C' , 'E'}, {'S', 'F', 'C', 'S'}, { 'A', 'D', 'E', 'E' }};
        String word = "ABCCED";

        char[][] board1 = new char[][] { {'a', 'b'}, {'c', 'd'} };
        String word1 = "acdb";
        System.out.println(exist(board1, word1));
    }
}
