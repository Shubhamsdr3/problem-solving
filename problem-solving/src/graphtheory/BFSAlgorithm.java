package graphtheory;

import java.util.*;

public class BFSAlgorithm {

    private static int EDGE_DISTANCE;

    private boolean[] visited;

    /** Track distance to 'start' node **/
    private int[] distance;

    /** Graph where index is 0-indexed node ID and each element is the set of neighboring nodes. **/
    public List<HashSet<Integer>> graph;

    private int startNode;

    BFSAlgorithm(int n, int edgeWeight) {
        EDGE_DISTANCE = edgeWeight;
        this.visited = new boolean[n];
        this.distance = new int[n];
        Arrays.fill(distance, -1); // Initialize the distance with -1.
        this.graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            // fill with neighbours for all edges.
            this.graph.add(new HashSet<>());
        }
    }

    public void shortestDistance(int startNode) {
        this.startNode = startNode;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        distance[startNode] = 0;

        // BFS from start
        while (!queue.isEmpty()) {
            int u = queue.remove(); // get the first node
            // for each unvisited neighbor of the current node
            for (int v : graph.get(u)) {
                // Add unvisited neighboring nodes to queue to check
                // its neighbors at next level of the search, set distance
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    distance[v] = distance[u] + EDGE_DISTANCE;
                }
            }
        }

        for (int i : distance) {
            if (i != 0) {
                // If distance is non-zero means it was reachable and visited.
                System.out.print(i + " ");
            }
        }

        System.out.println();

        // Just resets all distances to -1 in the event that this method
        // is ever called multiple times for some different 's'.
        Arrays.fill(distance, -1);
        Arrays.fill(visited, false);
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for(int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            BFSAlgorithm bfs = new BFSAlgorithm(scanner.nextInt(), 6);
            int m = scanner.nextInt();

            // read and set edges
            for(int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                bfs.graph.get(u).add(v);
                bfs.graph.get(v).add(u);
            }

            // Find shortest reach from node s
            bfs.shortestDistance(scanner.nextInt() - 1);
        }
        scanner.close();
    }
}
