package graph.shortestpath;

public class Edge {

    private double weight;
    private Node startVertex;
    private Node targetVertex;

    public Edge(double weight, Node startVertex, Node targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Node startVertex) {
        this.startVertex = startVertex;
    }

    public Node getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Node targetVertex) {
        this.targetVertex = targetVertex;
    }
}
