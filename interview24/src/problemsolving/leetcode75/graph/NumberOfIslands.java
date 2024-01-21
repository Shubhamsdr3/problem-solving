package problemsolving.leetcode75.graph;

import java.util.*;

public class NumberOfIslands {

    private static int numIslands(char[][] grid) {
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0 });

        int count = 0;

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        int rows = grid.length;
        int cols = grid[0].length;

        List<String> visited = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            // look for every neighbour.
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                // look for 4 direction.(adjacent vertices)
                for (int[] direction: directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != '1') continue;
                    grid[x][y] = '0';
                    queue.offer(new int[] { x, y});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
