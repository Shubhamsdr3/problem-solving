package problemsolving.leetcode75.graph;

import leetcode75.graph.AdjacencySetGraph;

import java.util.*;

public class TopologicalSort {

    private static List<Integer> sort(AdjacencySetGraph graph) {
        Map<Integer, Integer> indegreeMap = new HashMap<>(); // store the indegree of every node.
        Queue<Integer> queue = new LinkedList<>(); // bfs

        for (int vertext = 0; vertext < graph.getNumVertices(); vertext++) {
            int indegree = graph.getInDegree(vertext);
            indegreeMap.put(vertext, indegree);
            if (indegree == 0) {
                queue.add(vertext);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedList.add(vertex);
            List<Integer> adjacencyVertices = graph.getAdjacencyVertices(vertex);
            for (int adjacentVertex : adjacencyVertices) {
                int updatedDegree = indegreeMap.get(adjacentVertex) - 1; // reduce the indegree.
                indegreeMap.put(adjacentVertex, updatedDegree);

                if (updatedDegree == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }
        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The graph has cycle");
        }
        return sortedList;
    }
}
