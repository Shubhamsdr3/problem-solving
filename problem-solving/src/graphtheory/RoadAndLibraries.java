package graphtheory;

import java.util.Arrays;

public class RoadAndLibraries {


    // Complete the roadsAndLibraries function below.
    private static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib < c_road) {
            return n * c_lib;
        }

        int[] parent = new int[cities.length];
        Arrays.fill(parent, -1);

      return 0;

    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    private void unionSets(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    private int isCycle(Graph graph) {

        // Allocate memory for creating V subsets
        int[] parent = new int[graph.vertices];

        // Initialize all subsets as single element sets
        for (int i=0; i<graph.vertices; ++i) {
            parent[i] = -1;
        }

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.edges; ++i) {

            int x = find(parent, i);
            int y = find(parent, i + 1);

            if (x == y)
                return 1;

            unionSets(parent, x, y);
        }
        return 0;
    }

    private static class Graph {

        private int vertices;

        private int edges;

        public Graph(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }

    public static void main(String[] args) {

    }
}
