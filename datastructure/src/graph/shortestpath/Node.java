package graph.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    /**
     * Initially all the vertices will be un-reachable
     */
    private double distance = Double.MAX_VALUE;

    /**
     * The neighbours edges
     * Edge contains: weight, start Node and end node.
     */
    private List<Edge> adjacenciesList;

    /**
     * Represent whether a node is visited or not
     */
    private boolean visited;


    private String name;

    /**
     * The predecessor node
     */
    private Node predecessor;

    public Node(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.distance, o.getDistance());
    }
}
