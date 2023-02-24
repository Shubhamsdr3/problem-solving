package medium.backtracking;

public class WordSearch {

    /**
     * Using DFS and backtracking..
     * @param bord
     * @param word
     * @return
     */
    private static boolean existUsingDFS(char[][] bord, String word) {
        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int row = 0; row < bord.length; row++) {
            for (int col = 0; col < bord[row].length; col++) {
                return dfs(bord, dirs, row, col, word.toCharArray(), 0);
            }
        }
        return false;
    }

    private static boolean dfs(char[][] bord, int[][] dirs, int row, int col, char[] word, int idx) {
        if (idx == word.length) return true; // found every characters
        if (row < 0 || col < 0 || row == bord.length || col == bord[row].length) return false;
        if (bord[row][col] == '#' || bord[row][col] != word[idx]) return false;
        boolean isExist = false;
        char ch = bord[row][col];
        bord[row][col] = '#'; // this node is visited.
        for(int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            isExist = dfs(bord, dirs, newRow, newCol, word, idx + 1);
            if (isExist) return true;
        }
        bord[row][col] = ch; // backtracking
        return false;
    }

    /**
     * Using recursion.
     * T>C -> O(M * N * 3^L)
     * @param bord
     * @param word
     * @return
     */
    private static boolean exist(char[][] bord, String word) {
        for(int row = 0; row < bord.length; row++) {
            for (int col = 0; col < bord[row].length; col++) {
                return isWordExist(bord, word, 0, row, col);
            }
        }
        return false;
    }

    private static boolean isWordExist(char[][] bord, String word, int idx, int row, int col) {
        if (idx == word.length()) return true;
        if (row < 0 || col < 0 || row == bord.length || col == bord[row].length) return false; // to avoid negative row and column.
        if (bord[row][col] != word.charAt(idx)) return false; // if current character is present at current box.

        // check in all direction left/right/top/bottom
        return isWordExist(bord, word, idx + 1, row, col + 1) || // increase column.
                isWordExist(bord, word, idx + 1, row, col - 1) || //  decrease column.
                isWordExist(bord, word, idx + 1, row+1, col) || //
                isWordExist(bord, word, idx + 1, row -1, col);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { {'A', 'B', 'C', 'E'}, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";

        System.out.println(exist(board, word));

        char[][] board1 = new char[][] { {'A', 'B', 'C', 'E'}, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word1 = "SEE";

        System.out.println(existUsingDFS(board1, word1));
    }
}
