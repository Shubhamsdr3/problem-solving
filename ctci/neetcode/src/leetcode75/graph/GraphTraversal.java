package leetcode75.graph;

import graph.GraphNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    /**
     * graphNode can be adjacency matrix : [][]
     * or adjacency list/adjacency set.
     * @param graphNode
     * @param visited
     * @param currentVertex
     */
    public static void dfs(AdjacencySetGraph graphNode, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;
        List<Integer> list = graphNode.getAdjacencyVertices(currentVertex);
        for (int vertex: list) {
            dfs(graphNode, visited, vertex);
        }
        System.out.println(currentVertex + "->");
    }

    public static void bfs(AdjacencySetGraph graph, int[] visited, int currentVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (visited[vertex] == 1) {
                continue;
            }
            System.out.println(vertex + " -> ");
            visited[vertex] = 1;
            List<Integer> list = graph.getAdjacencyVertices(vertex);
            for (int v: list) {
                if (visited[v] != 1) {
                    queue.offer(v);
                }
            }
        }
    }
}
