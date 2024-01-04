package leetcode75.graph;

import java.util.*;

public class NearestExistFromEntrance {

    private static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length; // to check if boundary has reached.

        // bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance); // entrance is already visited.
        int entranceRow = entrance[0];
        int entranceCol = entrance[1];
        maze[entranceRow][entranceCol] = '+'; // entrance can't be visited again.

        // to keep track of directions
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction: directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    // check if direction are out of bound.
                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (maze[x][y] == '+') continue; // don't visit the wall.

                    // we reached at exit.
                    if (x == 0 || x == rows -1 || y == 0 || y == cols - 1) return steps;

                    maze[x][y] = '+'; // mark as visited
                    queue.offer(new int[]{x, y });// add the neighbours to the queue for next visit.
                }
            }
        }

        // no possible path to exit from maze.
        return -1;
    }

    public static void main(String[] args) {

    }
}
