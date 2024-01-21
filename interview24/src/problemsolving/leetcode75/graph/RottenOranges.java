package problemsolving.leetcode75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    private static int orangesRotting(int[][] grid) {
        // bfs
        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        int freshCount = 0;

        // count the rotten fresh oranges.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) { // rotten
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) { // fresh
                    freshCount++;
                }
            }
        }

        // to keep track of directions
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        int minutes = 0;
        while (!queue.isEmpty()) {
            minutes++;

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction: directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    // check any if this node's neighbour is rotten.

                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0 || grid[x][y] == 2) { // out of bound.
                        continue;
                    }

                    // mark the orange at (x, y) rotten
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y });
                    freshCount--;
                }
            }
        }

        // all the oranges have been rotten.
        return freshCount == 0 ? minutes -1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { {2, 1, 1}, {1, 1, 0}, {0, 1, 1} };
        System.out.println(orangesRotting(grid));
    }
}
