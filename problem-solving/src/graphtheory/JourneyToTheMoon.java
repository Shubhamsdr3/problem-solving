package graphtheory;

import java.util.*;

/**
 * Ways = N choose 2 - (∑(Mi Choose 2) for i = 1 to M)
 */
public class JourneyToTheMoon {

    private static int vertices;

    // Complete the journeyToMoon function below.
    private static int journeyToMoon(int n, int[][] astronaut) {

        LinkedList<Integer>[] adjListArray = new LinkedList[n];

        int[] eachC =  new int[n];

        for(int i = 0; i < n; i++) {
            adjListArray[i] = new LinkedList<>();
        }

        for (int i =0; i < astronaut.length; i++) {
            for (int j=0; j < astronaut[i].length -1; j++) {
                addEdge(adjListArray, astronaut[i][j], astronaut[i][j+1]);
            }
        }

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[n];

        int numberOfComponents = 0;

        for(int v = 0; v < n; ++v) {
            if(!visited[v]) {
                vertices = 0;
                dfsTraversal(v, visited, adjListArray);
                eachC[numberOfComponents] = vertices;
                numberOfComponents++;
//                System.out.println();
            }
        }
        int totalWays = n * (n-1) / 2;
        int sameWays = 0;

        for (int i=0; i< numberOfComponents; i++) {
            sameWays = sameWays + (eachC[i] * (eachC[i]-1) / 2);
        }

        return totalWays - sameWays;
    }

    // Adds an edge to an undirected graph
    private static void addEdge(List<Integer>[] adjListArray, int src, int dest) {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    private static void dfsTraversal(int v, boolean[] visited, List<Integer>[] adjListArray) {
        visited[v] = true;
        vertices ++;
        for (int x : adjListArray[v]) {
            if(!visited[x]) {
                dfsTraversal(x,visited, adjListArray);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] input =  new int[][] {
                {0, 2},
                {1, 8},
                {1, 4},
                {2, 8},
                {2, 6},
                {3, 5},
                {6, 9}
        };
        System.out.println(journeyToMoon(n , input));
    }
}
