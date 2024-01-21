package problemsolving.leetcode75.graph.minimalspanningtree;

import leetcode75.graph.AdjacencySetGraph;
import leetcode75.graph.shortestpath.DistanceInfo;
import leetcode75.graph.shortestpath.VertexInfo;

import java.util.*;

public class PrimsAlgorithm {

    /**
     * Uses greedy algorithm.
     * @param graph
     * @param source
     */
    public  static void minimumSpanningTree(AdjacencySetGraph graph, int source) {
        // distance table
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

        // PQ to get the lowest edge.
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(Comparator.comparingInt(VertexInfo::getDistance));

        for (int j = 0;  j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo(Integer.MAX_VALUE, 0));
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        VertexInfo vertexInfo = new VertexInfo(source, 0);
        queue.add(vertexInfo);
        vertexInfoMap.put(source, vertexInfo);

        // bfs
        Set<String> spanningTree = new HashSet<>(); // store the path
        Set<Integer> visitedVertices = new HashSet<>();

        while (!queue.isEmpty()) {
            VertexInfo node = queue.poll();
            int currentVertex = node.getVertexId();

            if (visitedVertices.contains(currentVertex)) continue;

            visitedVertices.add(currentVertex);

            if (currentVertex != source) {
                String edge = currentVertex + String.valueOf(distanceTable.get(currentVertex).getLastVertex());
                if (!spanningTree.contains(edge)) {
                    spanningTree.add(edge);
                }
            }

            for (Integer neighbour: graph.getAdjacencyVertices(currentVertex)) {
                int distance = graph.getWeightedEdge(currentVertex, neighbour);

                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    VertexInfo neighbourVertex = vertexInfoMap.get(neighbour);
                    if (neighbourVertex != null) {
                        queue.remove(neighbourVertex);
                    }

                    neighbourVertex = new VertexInfo(neighbour, distance);
                    vertexInfoMap.put(neighbour, neighbourVertex);
                    queue.add(neighbourVertex);
                }
            }
        }

        // print path
        for (String node: spanningTree) {
            System.out.println(node + "-> " );
        }
    }
}
