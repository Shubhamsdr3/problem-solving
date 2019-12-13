package graph;


/**
 * Also called @Vertex
 * Represent a single node of a graph
 * A node can more than one properties
 * now I have stored the it's integer value.
 */
public class GraphNode {

    private char vertex;

    private boolean isVisited;

    GraphNode(char vertex) {
        this.vertex = vertex;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public char getVertex() {
        return vertex;
    }

    public void setVertex(char vertex) {
        this.vertex = vertex;
    }
}
