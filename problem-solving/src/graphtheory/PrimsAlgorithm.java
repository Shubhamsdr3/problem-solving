package graphtheory;

import java.util.*;

public class PrimsAlgorithm {

    private static LinkedList<Edge>[] adj;

    // Complete the prims function below.
    private static int prims(int n, int[][] edges, int start) {

        Boolean[] mstSet = new Boolean[n];
        Arrays.fill(mstSet, false);


        List<Edge> edgeList = new ArrayList<>();

//        for (int i=0; i < edges.length; i++) {
//            edgeList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
//        }

        int[] parent = new int[n];
        Node[] e = new Node[n];
        for (int i = 0; i < n; i++) {
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
            parent[i] = -1;
        }

        mstSet[0] = true;

        e[0].key = 0;

        TreeSet<Node> queue = new TreeSet<Node>();
        for (int j = 0; j < n; j++){
            queue.add(e[j]);
        }

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();

            mstSet[node.vertex] = true;

            for (Edge iterator : adj[node.vertex]) {

                // If V is in queue
                if (!mstSet[iterator.destination]) {
                    if (e[iterator.destination].key > iterator.weight) {
                        queue.remove(e[iterator.destination]);
                        e[iterator.destination].key = iterator.weight;
                        queue.add(e[iterator.destination]);
                        parent[iterator.destination] = node.vertex;
                    }
                }
            }
        }
        // Prints the vertex pair of mst
        for (int o = 1; o < n; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);

        return 0;
    }

    void addEdge(int src, int dest, int weight) {
        Edge node0 = new Edge(dest, weight);
        Edge node = new Edge(src, weight);
        adj[src].addLast(node0);
        adj[dest].addLast(node);
    }

    static class Edge {

        int destination;

        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        @Override
        public int compareTo(Node o) {
            return this.key - o.key;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int start = 1;

        int[][] matrix = new int[][] {
                {1, 2, 3},
                {1, 3, 4},
                {4, 2, 6},
                {5, 2, 2},
                {2, 3, 5},
                {3, 5, 7}
        };

        System.out.println(prims(n, matrix, start));
    }
}
