package problemsolving.leetcode75.graph.shortestpath;

import leetcode75.graph.AdjacencySetGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPath {

    public static void shortestPath(AdjacencySetGraph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceInfo(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int prevVertex = distanceTable.get(destination).getLastVertex();

        while (prevVertex != -1 && prevVertex != source) {
            stack.push(prevVertex);
            prevVertex = distanceTable.get(prevVertex).getLastVertex();
        }

        if (prevVertex == -1) {
            System.out.println("There is no path exists: " + source + "to " + destination);
        } else {
            System.out.print("Smallest path is: " + source);
            while (!stack.isEmpty()) {
                System.out.println(" -> " + stack.pop());
            }
        }
    }

    private static Map<Integer, DistanceInfo> buildDistanceInfo(AdjacencySetGraph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int i = 0; i < graph.getNumVertices(); i++) {
            distanceTable.put(i, new DistanceInfo(-1, -1));
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        // bfs
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int i : graph.getAdjacencyVertices(currentVertex)) {
                int currentDistance = distanceTable.get(i).getDistance();
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);
                    if (!graph.getAdjacencyVertices(i).isEmpty()) {
                        queue.add(i);
                    }
                }
            }
        }
        return distanceTable;
    }

}
