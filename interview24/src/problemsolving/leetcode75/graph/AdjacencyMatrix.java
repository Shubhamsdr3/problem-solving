package problemsolving.leetcode75.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix implements IGraph {

    private int[][] adjacencyMatrix;

    private IGraph.GraphType graphType;

    private int numOfVertices = 0;

    public int getIndegree(int v) {
        if (v < 0 || v >= numOfVertices) {
            throw new IllegalArgumentException("Vertext number is not valid");
        }
        int indegree = 0;
        for (int i = 0; i < numOfVertices; i++) {
            if(adjacencyMatrix[i][v] != 0) { // path exists between i <-> v.
                indegree++;
            }
        }
        return indegree;
    }

    public AdjacencyMatrix(int numOfVertices, IGraph.GraphType graphType) {
        this.numOfVertices = numOfVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numOfVertices][numOfVertices];

        Arrays.fill(adjacencyMatrix, 0);
    }



    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numOfVertices || v1 < 0 || v2 >= numOfVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        adjacencyMatrix[v1][v2] = 1;
        if(graphType == GraphType.UNDIRECTED) { // in case of undirected then there will be two way.
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        if(v >= numOfVertices || v < 0) {
            throw new IllegalArgumentException("Vertex is not valid");
        }

        List<Integer> adjcentVerticesList = new ArrayList<>();
        for (int i = 0; i < numOfVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjcentVerticesList.add(i);
            }
        }
        Collections.sort(adjcentVerticesList); //optional.
        return adjcentVerticesList;
    }

}
