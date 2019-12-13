package graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Kruskal's algorithm using greedy approach.
 *
 */
public class KruskalAlgo2 {

    private int kruskals(int numberOfVertices, List<Integer> sourceList, List<Integer> destinationList, List<Integer> weightList) {

        List<Edge> edgeList = new ArrayList<>(numberOfVertices);
        for (int i=0; i < sourceList.size(); ++i) {
            edgeList.add(new Edge(sourceList.get(i), destinationList.get(i), weightList.get(i)));
        }

        Collections.sort(edgeList);
        int[] parents = new int[numberOfVertices];
        for (int i = 1; i <= numberOfVertices; i++) {
            parents[i -1] = i;
        }
        int minimumSum = 0;
        for (Edge edge: edgeList) {
            int source = edge.source;
            int destination = edge.destination;
            if (isCyclic(source, destination, parents)) {
                // means cycle is found
                continue;
            }
            union(parents, source, destination);
            minimumSum = minimumSum + edge.weight;
        }
        return minimumSum;
    }

    private void union(int[] parents, int u, int v) {
        int xSet = find(parents, u);
        int ySet = find(parents, v);
        parents[xSet -1] = ySet;
    }

    private boolean isCyclic(int u, int v, int[] parents) {
        return find(parents, u) == find(parents, v);
    }

    private int find(int[] parents, int vertex) {
        if (parents[vertex - 1] == vertex) {
            // index will start from 0.
            return vertex;
        }
        return find(parents, parents[vertex-1]);
    }

    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfVertices = sc.nextInt();
        int numberOfEdges = sc.nextInt();

        List<Integer> sourceList = new ArrayList<>();
        List<Integer> destinationList = new ArrayList<>();
        List<Integer> weightList = new ArrayList<>();

        for (int i=0; i< numberOfEdges; i++) {
            sourceList.add(sc.nextInt());
            destinationList.add(sc.nextInt());
            weightList.add(sc.nextInt());
        }

        KruskalAlgo2 kruskalAlgo2 = new KruskalAlgo2();
        System.out.println(kruskalAlgo2.kruskals(numberOfVertices, sourceList, destinationList, weightList));
    }
}
