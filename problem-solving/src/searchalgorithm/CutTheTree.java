package searchalgorithm;

import java.util.*;

public class CutTheTree {

    /**
     * Solve ???
     */
    private static int minDiff = Integer.MAX_VALUE;

    private static List<List<Integer>> graph = new ArrayList<>();

    // Write your code here
    private static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        // creating graph
        for (int i =0; i <= edges.size() + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        boolean[] visited = new boolean[edges.size() +1];
        Arrays.fill(visited, false);
        return dfs(1, visited, data);
    }

    private static int dfs(int source, boolean[] visited,  List<Integer> data) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // add start node
        visited[source] = true;

        while (!queue.isEmpty()) {
            source = queue.peek();
            queue.remove();
            for (int i = 0 ; i < graph.get(source).size(); i++) {
                int b = graph.get(source).get(i);
                if (!visited[b]) {
                    int diff = findWeightSum(data, b -1) - data.get(b - 1);
                    if (diff < minDiff) {
                        minDiff = diff;
                    }
                    queue.add(b);
                    visited[b] = true;
                }
            }

        }
        return minDiff;
    }

    private static int findWeightSum(List<Integer> list, int index) {
        int sum = 0;
        for (int i =index; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(Arrays.asList(100, 200, 100, 500, 100, 6000));

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(4, 5)));
        edges.add(new ArrayList<>(Arrays.asList(5, 6)));

        List<Integer> data1 = new ArrayList<>(Arrays.asList(205 ,573 ,985 ,242 ,830 ,514, 592, 263, 142, 915));

        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<>(Arrays.asList(2, 8)));
        edges1.add(new ArrayList<>(Arrays.asList(10, 5)));
        edges1.add(new ArrayList<>(Arrays.asList(1, 7)));
        edges1.add(new ArrayList<>(Arrays.asList(6, 9)));
        edges1.add(new ArrayList<>(Arrays.asList(4, 3)));
        edges1.add(new ArrayList<>(Arrays.asList(8, 10)));
        edges1.add(new ArrayList<>(Arrays.asList(5, 1)));
        edges1.add(new ArrayList<>(Arrays.asList(7, 6)));
        edges1.add(new ArrayList<>(Arrays.asList(9, 4)));

        System.out.println(cutTheTree(data1, edges1));
    }
}
