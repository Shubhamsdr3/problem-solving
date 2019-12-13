//package graph.mst;
//
//import java.util.*;
//
///**
// * In spanning tree we should have all vertices.
// * N -1 edges. where N -> Number of edges.
// */
//public class KruskalAlgorithm {
//
//    private int numberOfEdges;
//
//    private int numberOfVertices;
//
//    private List<Edge> edgeList;
//
//    private List<Integer> visitedSet;
//
//    public KruskalAlgorithm(int numberOfEdges, int numberOfVertices) {
//        this.numberOfEdges = numberOfEdges;
//        this.numberOfVertices = numberOfVertices;
//        edgeList = new ArrayList<>(numberOfEdges);
//
//        visitedSet = new ArrayList<>(numberOfEdges);
//    }
//
//    private int find(int i) {
//        // parent will be the element with -1
//        if (visitedSet.get(i) == i)
//            return i;
//        return find(visitedSet.get(i));
//    }
//
//    // A utility function to do union of two subsets
//    private void union(int[] parent, int x, int y) {
//        int xSet = find(parent, x);
//        int ySet = find(parent, y);
//        visitedSet.add(xSet, ySet);
////        parent[xSet] = ySet;
//    }
//
//    /**
//     * Detecting a cycle using union-find algorithm..
//     *
//     * for each un-visited edge(u, v) in edge set E {
//     *     if (FIND(u) == FIND(v)) {
//     *          // cycle detected.
//     *         return true;
//     *     } else {
//     *         UNION(x, y);
//     *     }
//     * }
//     * @return : true: if cycle is detected or false.
//     */
//    private boolean isCycle(int u, int v, int[] parents) {
//
//        int[] parent = new int[numberOfVertices];
//
//        // -1 means each node is representative of it's own.
//        Arrays.fill(parent, -1);
//
//
//
//        int edgeCounter = 0;
//
//        for (int i = 0; i < numberOfEdges; ++i) {
//            Edge edge = edgeList.get(edgeCounter);
//            edgeCounter ++;
//
//            // find out the representative of source and destination
//            // and see if they belong to same set or different set.
//            int x = find(parent, edge.source);
//            int y = find(parent, edge.destination);
//
//            if (x == y) {
//                // they belong to same set or they have same representative.
//                // Cycle detected
//                return true;
//            } else {
//                union(parent, x, y);
//            }
//        }
//        return false;
//    }
//
//    public int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
//        Collections.sort(gWeight);
//
//        int minPath = 0;
//
//        for (int i = 0; i < gFrom.size(); ++i) {
//            edgeList.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
//        }
//
//        for (int i = 0; i < gNodes; i++) {
//            if (!isCycle()) {
//                minPath = minPath + gWeight.get(i);
//            }
//        }
//        return minPath;
//    }
//
//    static class Edge implements Comparable<Edge> {
//        int source;
//        int destination;
//        int weight;
//
//        Edge(int source, int destination, int weight) {
//            this.source = source;
//            this.destination = destination;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.weight - o.weight;
//        }
//    }
//
//    public static void main(String[] args) {
//        int gNodes = 4;
//        int gEdges = 6;
//
//        KruskalAlgorithm algorithm = new KruskalAlgorithm(gEdges, gNodes);
//
//        List<Integer> sourceNodeList = new ArrayList<>(Arrays.asList(1, 1, 4, 2, 3, 3));
//        List<Integer> destinationNodeList = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 2, 4));
//        List<Integer> wightList = new ArrayList<>(Arrays.asList(5, 3, 6, 7, 4, 5));
//
//        System.out.println(algorithm.kruskals(gNodes, sourceNodeList, destinationNodeList, wightList));
//    }
//}
