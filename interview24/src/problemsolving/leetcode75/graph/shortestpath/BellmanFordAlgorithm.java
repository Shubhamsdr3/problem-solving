package problemsolving.leetcode75.graph.shortestpath;

import leetcode75.graph.AdjacencySetGraph;

import java.util.*;

public class BellmanFordAlgorithm {

    /**
     * Bellman ford algorithm , building distance table.
     */
    public static Map<Integer, DistanceInfo> buildDistanceTable(AdjacencySetGraph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo(1000000, -1));
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        // traversing v-1 times
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.getNumVertices() - 1; i++) {
            for (int v = 0; v < graph.getNumVertices(); v++) {
                queue.add(v);
            }
        }

        Set<String> visitedEdges = new HashSet<>();
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbour: graph.getAdjacencyVertices(currentVertex)) {
                String edge = currentVertex + String.valueOf(neighbour);
                if (visitedEdges.contains(edge)) {
                    continue;
                }
                visitedEdges.add(edge);

                int distance = distanceTable.get(currentVertex).getDistance()
                         + graph.getWeightedEdge(currentVertex, neighbour);

                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);
                }
            }
        }
        return distanceTable;
    }

    private static boolean checkForNegativeCycle(AdjacencySetGraph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < graph.getNumVertices(); v++) {
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor: graph.getAdjacencyVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbor);
                if (distanceTable.get(neighbor).getDistance() > distance) {
                    return  true;
                }
            }
        }
        return false;
    }
}
