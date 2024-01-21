package problemsolving.leetcode75.graph;

import java.util.*;

public class FindIfPathExists {

    private static boolean isFound = false;
    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // construct graph, add bi-direction vertex.
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // start dfs from start point
        dfs(graph, visited, source, destination);

        return isFound;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int destination) {
        if (visited[source] || isFound) return;
        visited[source] = true;
        // when we found and neighbour which is equal to end point inside the recursion, volley, break and return true.
        for (int nei : graph.get(source)) {
            if (nei == destination) {
                isFound = true;
                break;
            }
            if (!visited[nei]) {
                dfs(graph, visited, nei, destination);
            }
        }
    }

    public static void main(String[] args) {

    }
}
