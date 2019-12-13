package graph;

/**
 *  Detecting a cycle in graph using disjoint sets.
 */
public class GraphExample {

    /**
     * Number of vertices
     */
    private int vertices;

    /**
     * Number of edges
     */
    private int  edge;

    /**
     * Collection of all edges.
     */
    private Edge[] edges;

    private GraphExample(int vertices, int edge) {
        this.vertices = vertices;
        this.edge = edge;
        edges = new Edge[edge];

        // Creates a graph with V vertices and E edges
        for (int i=0; i<edge; ++i) {
            edges[i] = new Edge();
        }
    }

    // A utility function to find the subset of an element i
    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    private void Union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }


    private int isCycle( GraphExample graph) {

        // Allocate memory for creating V subsets
        int[] parent = new int[graph.vertices];

        // Initialize all subsets as single element sets
        for (int i = 0; i < graph.vertices; ++i) {
            parent[i] = -1;
        }

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.edge; ++i) {
            int x = graph.find(parent, graph.edges[i].getSource());
            int y = graph.find(parent, graph.edges[i].getDestination());

            if (x == y)
                return 1;

            graph.Union(parent, x, y);
        }
        return 0;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;

        GraphExample graph = new GraphExample(V, E);

        // add edge 0-1
        graph.edges[0].setSource(0);
        graph.edges[0].setDestination(1);

        // add edge 1-2
        graph.edges[1].setSource(1);
        graph.edges[1].setDestination(2);

        // add edge 0-2
        graph.edges[2].setSource(0);
        graph.edges[2].setDestination(2);

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
