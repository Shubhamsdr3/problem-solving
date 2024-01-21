package problemsolving.leetcode75.graph;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int count = 0;
            if(!visited[i]) {
                dfs(edges, visited, i);
            } else {
                count++;
            }
        }
        return 0;
    }

    private void dfs(int[][] edges, boolean[] visited, int i) {
        for (int j = 0; j < edges.length; j++) {
            if(!visited[j]) {
                visited[j] = true;
                dfs(edges, visited, i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
