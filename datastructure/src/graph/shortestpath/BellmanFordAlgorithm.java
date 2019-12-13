package graph.shortestpath;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BellmanFord algorithm :
 * 1. Uses Dynamic programming strategy
 * 2. Relax edges V - 1 times.
 * 3. Allows negative weight unlike Dijkstra algorithm
 * 4. Fails when there is negative cycle in the graph
 *  as it keeps relaxing the edge even of after |V| -1 time.
 * 5. It helps to detect the negative cycle in graph
 */
public class BellmanFordAlgorithm {

    private double[] bellmanFordAlgorithm(int numberOfVertices, List<Edge> edgeList, int startNode) {
        double[] distance = new double[numberOfVertices];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);

        distance[startNode] = 0;

        for (int i=0; i < numberOfVertices-1; ++i) {
            for (Edge edge: edgeList) {
                // relax edge
                if (distance[edge.source] + edge.edgeCost < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.edgeCost;
                }
            }
        }

        // run the algorithm a second time
        // to detect which nodes are part of a negative cycle.
        for (int v=0; v < numberOfVertices - 1; ++v) {
            for (Edge edge: edgeList) {
                if (distance[edge.source] + edge.edgeCost < distance[edge.destination]) {
                    distance[edge.destination] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        return distance;
    }

    static class Edge {
        int source;
        int destination;
        int edgeCost;

        Edge(int source, int destination, int edgeCost) {
            this.source = source;
            this.destination = destination;
            this.edgeCost = edgeCost;
        }
    }

    public static void main(String[] args) {
        int numberOfVertices = 9;
        List<Edge>  edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 1, 1));
        edgeList.add(new Edge(1, 2, 1));
        edgeList.add(new Edge(2, 4, 1));
        edgeList.add(new Edge(4, 3, -3));
        edgeList.add(new Edge(3, 2, 1));
        edgeList.add(new Edge(1, 5, 4));
        edgeList.add(new Edge(1, 6, 4));
        edgeList.add(new Edge(5, 6, 5));
        edgeList.add(new Edge(6, 7, 4));
        edgeList.add(new Edge(5, 7, 3));
        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm();
        System.out.println(Arrays.toString(algorithm.bellmanFordAlgorithm(numberOfVertices, edgeList, 0)));
    }
}
