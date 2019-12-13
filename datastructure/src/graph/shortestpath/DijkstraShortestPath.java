package graph.shortestpath;

import java.util.*;

/**
 * Used to find the shortest path in a graph.
 * It can't have negative weight edge
 */
public class DijkstraShortestPath {

    /**
     * Compute the shortest path using Dijkstra's algorithm.
     * @param source: Starting node.
     */
    private void computeShortestPath(Node source) {
        // source node distance == 0
        source.setDistance(0);

        // source node is visited.
        Queue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(source);
        source.setVisited(true);

        while (!priorityQueue.isEmpty()) {

            // Getting the minimum distance vertex from priority queue
            Node actualVertex = priorityQueue.poll();

            for (Edge edge: actualVertex.getAdjacenciesList()) {
                Node v = edge.getTargetVertex();
                if (!v.isVisited()) {

                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    // Relaxation
                    if( newDistance < v.getDistance() ){
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    private List<Node> getShortestPathTo(Node targetVertex){
        List<Node> path = new ArrayList<>();

        for(Node vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Node vertexA = new Node("A");
        Node vertexB = new Node("B");
        Node vertexC = new Node("C");
        Node vertexD = new Node("D");
        Node vertexE = new Node("E");

        vertexA.addNeighbour(new Edge(10,vertexA,vertexC));
        vertexA.addNeighbour(new Edge(17,vertexA,vertexB));
        vertexC.addNeighbour(new Edge(5,vertexC,vertexB));
        vertexC.addNeighbour(new Edge(9,vertexC,vertexD));
        vertexC.addNeighbour(new Edge(11,vertexC,vertexE));
        vertexB.addNeighbour(new Edge(1,vertexB,vertexD));
        vertexD.addNeighbour(new Edge(6,vertexD,vertexE));

        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        shortestPath.computeShortestPath(vertexA);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance");
        System.out.println("======================================");

        System.out.println("Minimum distance from A to B: "+vertexB.getDistance());
        System.out.println("Minimum distance from A to C: "+vertexC.getDistance());
        System.out.println("Minimum distance from A to D: "+vertexD.getDistance());
        System.out.println("Minimum distance from A to E: "+vertexE.getDistance());

        System.out.println("=====================	=================");
        System.out.println("Calculating Paths");
        System.out.println("======================================");

        System.out.println("Shortest Path from A to B: "+shortestPath.getShortestPathTo(vertexB));
        System.out.println("Shortest Path from A to C: "+shortestPath.getShortestPathTo(vertexC));
        System.out.println("Shortest Path from A to D: "+shortestPath.getShortestPathTo(vertexD));
        System.out.println("Shortest Path from A to E: "+shortestPath.getShortestPathTo(vertexE));
    }
}
