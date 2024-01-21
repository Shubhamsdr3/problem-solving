package problemsolving.leetcode75.graph;

import java.util.*;

public class ShortestPathVisitingNodes {

    public int shortestPathLength(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = graph.length;
        // adjacency list of graph.
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }

            int m = graph[i].length;

            for (int j = 0; j <m; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        int row = (int) Math.pow(2, n);
        int col = n;

        int[][] dis = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dis[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int lead = i;
            int mask = setBit(0, i);
            queue.add(new int[]{lead, mask });
            dis[mask][lead] = 0;
        }

        // applying simultneous BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] path = queue.poll();
                int lead = path[0];
                int mask = path[1];

                if (mask == row - 1) {
                    return dis[mask][lead]; // return
                }
                if (map.containsKey(lead)) {
                    for (int child: map.get(lead)) {
                        int newLead = child;
                        int newMask = setBit(mask, newLead);

                        // avoid cycle: intelligent bfs : checking if this set is already visited
                        // set : lead, mask(visited nodes)
                        if (dis[newMask][newLead] != -1) {
                            continue;
                        }

                        dis[newMask][newLead] = dis[mask][lead] + 1;
                        queue.add(new int[] {newLead, newMask });
                    }
                }
            }
        }
        return -1;
    }



    private int setBit(int mask, int i) {
        return mask | 1 << i;
    }

    public static void main(String[] args) {

    }
}
