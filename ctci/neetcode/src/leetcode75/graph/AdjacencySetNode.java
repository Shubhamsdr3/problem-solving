package leetcode75.graph;

import java.util.*;

public class AdjacencySetNode {

    private int vertexNumber;
    private Set<Integer> adjacencySet = new HashSet<>();

    public AdjacencySetNode(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void addEdge(int vertexNumber) {
        adjacencySet.add(vertexNumber);
    }

    public List<Integer> getAdjacencyList() {
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
