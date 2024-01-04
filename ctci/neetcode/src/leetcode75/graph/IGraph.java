package leetcode75.graph;

import java.util.List;

public interface IGraph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    /**
     * All the adjacency connected to the node v.
     * @param v
     * @return
     */
    List<Integer> getAdjacencyVertices(int v);
}
