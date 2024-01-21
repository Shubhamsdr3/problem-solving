package problemsolving.leetcode75.graph;

public class FindTheTownJudge {

    private static int findJudge(int n, int[][] trust) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < trust.length; i++) {
            if(!visited[i]) {
                dfs(trust, visited, i);
            }
        }
        return 0;
    }

    private static void dfs(int[][] trust, boolean[] visited, int i) {
        for (int j = 0; j < trust.length; j++) {
//            if (trust[i][j] == )
        }
    }

    public static void main(String[] args) {

    }
}
