package problemsolving.leetcode75.graph;

public class NumberOfProvinces {

    private static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };
        System.out.println(findCircleNum(matrix));
    }
}
