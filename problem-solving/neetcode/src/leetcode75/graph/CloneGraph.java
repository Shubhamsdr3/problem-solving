package leetcode75.graph;

import leetcode75.graph.data.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    private static GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        if (node.neighbors.size() == 0) {
            GraphNode n = new GraphNode(node.val);
            return n;
        }
        return dfs(node, new HashMap<GraphNode, GraphNode>());
    }

    private static GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
        GraphNode newNode = new GraphNode(node.val);
        List<GraphNode> neighbours = new ArrayList<>();
        map.put(node,  newNode); // mapping the old node to new node.

        for (GraphNode current: node.neighbors) {
            if (map.containsKey(current)) {
                neighbours.add(map.get(current));
            } else {
                neighbours.add(dfs(current, map));
            }
        }
        newNode.neighbors = neighbours;
        return newNode;
    }

    public static void main(String[] args) {

    }
}
