package leetcode75.graph;

import java.util.*;

public class MinimumReorder {

    private static int minReorder(int n, int[][] connections) {
        // start at city 0
        // recursively checks it's neighbour
        // count outgoing edges

        // creating graph.

        Set<String> path = new HashSet<>();

        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int[] edge: connections) {
            path.add(edge[0] + "," + edge[1]);
            edges.put(edge[0], new HashSet<>());
            edges.put(edge[1], new HashSet<>());
            edges.get(connections[0]).add(edge[1]);
            edges.get(connections[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // source
        int changes = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int next: edges.getOrDefault(c, new HashSet<>())) {
                if (visited[next]) continue;
                visited[next] = true;
                if (!path.contains(next + "," + c)) {
                    changes++;
                }
                queue.offer(next);
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = new int[][] { {0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5} };
        int n = 6;
        System.out.println(minReorder(n, adjacencyMatrix));
    }
}
