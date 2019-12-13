package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphDFS {

    /**
     * Number of vertices(nodes)
     */
    private int vertices;

    private int[][] adjMatrix;

    private List<GraphNode> vertexList;

    private int numberOfVertices = 0;

    private Stack<Integer> stack;

    // Initialize the graph
    private GraphDFS(int vertices) {
        adjMatrix = new int[vertices][vertices];
        vertexList =  new ArrayList<>(vertices);
        stack = new Stack<>();
    }

    // Adds an edge to an undirected graph
    private void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        // for undirected graph
        adjMatrix[end][start] = 1;
    }

    // or addVertex
    private void addNode(char vertex) {
        vertexList.add(numberOfVertices++, new GraphNode(vertex));
    }

    private void dfsTraversal() {
        vertexList.get(0).setVisited(true);
        System.out.println(vertexList.get(0).getVertex());
        stack.push(0);

        while (! stack.isEmpty()) {
            int nextVertex = getAdjacencyUnvisitedNode(stack.peek());

            if (nextVertex == -1) { // all elements are visited.
                stack.pop();
            } else {
                vertexList.get(nextVertex).setVisited(true);
                System.out.println(vertexList.get(nextVertex).getVertex());
                stack.push(nextVertex);
            }
        }
    }

    /**
     * Provide un-visited neighbour
     * @param vertex: current node.
     * @return : next node index
     */
    private int getAdjacencyUnvisitedNode(int vertex) {
        for (int j=0; j < vertexList.size(); j++) {
            if (adjMatrix[vertex][j] == 1 && !vertexList.get(j).isVisited()) {
                return j;
            }
         }
        return -1;
    }

    // Driver program to test above
    public static void main(String[] args){
        GraphDFS graphDFS = new GraphDFS(20);
        graphDFS.addNode('A');
        graphDFS.addNode('B');
        graphDFS.addNode('D');
        graphDFS.addNode('C');
        graphDFS.addNode('E');
        graphDFS.addNode('F');

        graphDFS.addEdge(0, 1);
        graphDFS.addEdge(1, 2);
        graphDFS.addEdge(0, 3);
        graphDFS.addEdge(3, 4);
        graphDFS.addEdge(4, 5);
        graphDFS.addEdge(1, 5);

        graphDFS.dfsTraversal();
    }
}
