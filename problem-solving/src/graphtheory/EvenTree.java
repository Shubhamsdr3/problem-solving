package graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenTree {

    private static List<List<Integer>> graph = new ArrayList<>();

    private static int numberOfRemovedEdge;

    // Complete the evenForest function below.
    private static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {

        for (int i=0; i < t_nodes + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i= 0; i < t_nodes -1; i++) {
            addEdge(t_from.get(i), t_to.get(i));
        }

        boolean[] visit = new boolean[t_nodes + 1];

        Arrays.fill(visit, false);
        numberOfRemovedEdge = 0; // Passed as reference

        // calling the dfs from node-0
        dfs(1, visit);

        return numberOfRemovedEdge;
    }

    private static int dfs(int u, boolean[] visited) {
        visited[u] = true;

        int currComponentNode = 0;

        // Iterate over all neighbours
        for (int i = 0; i < graph.get(u).size(); i++) {

            int v = graph.get(u).get(i);

            if (!visited[v]) {

                // Count the number of nodes in a subtree
                int subtreeNodeCount = dfs(v, visited);

                // if returned node count is even, disconnect
                // the subtree and increase result by one.
                if (subtreeNodeCount % 2 == 0)  {
                    numberOfRemovedEdge++;
                }
                // else add subtree nodes in current component
                else {
                    currComponentNode += subtreeNodeCount;
                }
            }
        }
        return (currComponentNode + 1);
    }

    private static void addEdge( int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {

        int numberOfNodes = 10;

        int numberOfEdges = 9;

        List<Integer> sourceNodes = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));

        List<Integer> destinationList = new ArrayList<>(Arrays.asList(1, 1, 3, 2, 1, 2, 6, 8, 8));

        System.out.println(evenForest(numberOfNodes, numberOfEdges, sourceNodes, destinationList));

    }
}
