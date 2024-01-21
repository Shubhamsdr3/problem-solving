package problemsolving.leetcode75.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements IGraph {

    private List<AdjacencySetNode> vertexList = new ArrayList<>();
    private GraphType graphType;

    private int numVertices = 0;

    public int getNumVertices() {
        return numVertices;
    }

    public int getWeightedEdge(int source, int destination) {
        return 0;
    }

    public int getInDegree(int v) {
        if (v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        int indegree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (getAdjacencyVertices(i).contains(v)) {
                indegree++;
            }
        }
        return indegree;
    }

    public AdjacencySetGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new AdjacencySetNode(i));
        }
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        return vertexList.get(v).getAdjacencyList();
    }
}
