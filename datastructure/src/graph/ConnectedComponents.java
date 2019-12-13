package graph;

import java.util.LinkedList;


class ConnectedComponents {


    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    private int V;

    private LinkedList<Integer>[] adjListArray;

    // constructor
    private ConnectedComponents(int V) {
        this.V = V;

        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Adds an edge to an undirected graph
    private void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray[dest].add(src);
    }

    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray[v]) {
            if(!visited[x]) {
                DFSUtil(x,visited);
            }
        }
    }
    private void connectedComponents() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                // if not visited
                // print all reachable vertices from v
                DFSUtil(v,visited);

                System.out.println();
            }
        }
    }


    // Driver program to test above
    public static void main(String[] args){
        // Create a graph given in the above diagram
        ConnectedComponents g = new ConnectedComponents(5); // 5 vertices numbered from 0 to 4

        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(0, 4);

        System.out.println("Following are connected components");

        g.connectedComponents();
    }
}
