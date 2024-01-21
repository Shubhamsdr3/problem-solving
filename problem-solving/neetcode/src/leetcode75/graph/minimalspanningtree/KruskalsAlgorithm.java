package leetcode75.graph.minimalspanningtree;

import leetcode75.graph.AdjacencySetGraph;

import java.util.*;

public class KruskalsAlgorithm {

    public static void spanningTree(AdjacencySetGraph graph) {
        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>();

        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int neighbour: graph.getAdjacencyVertices(i)) {
                queue.add(new EdgeInfo(i, neighbour, graph.getWeightedEdge(i, neighbour)));
            }
        }

        Set<Integer> visitedVertices = new HashSet<>();
        Set<EdgeInfo> spanningTree = new HashSet<>();

        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int v = 0; v < graph.getNumVertices(); v++) {
            edgeMap.put(v, new HashSet<>());
        }


    }
}
