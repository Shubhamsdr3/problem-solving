package leetcode75.graph;

import leetcode75.graph.shortestpath.VertexInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ReverseThePath {


    private  static int[] shortestPath(int source, int[][] graph) {
        Set<VertexInfo> vertices = new HashSet<>();
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        vertices.add(new VertexInfo(source, 0));
        dist[source] = 0;

        while (!vertices.isEmpty()) {
            Iterator<VertexInfo> iterator = vertices.iterator();
            VertexInfo info = iterator.next();
            iterator.remove();

            int u = info.getVertexId();

//            for (VertexInfo vertex: graph[u]) {
//
//            }

        }
        return dist;
    }
}
