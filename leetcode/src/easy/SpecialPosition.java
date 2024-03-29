package easy;

public class SpecialPosition {

    private static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res = 0;
        int[] col = new int[n];
        int[] row = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1){
                    col[j]++;
                    row[i]++;
                }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0},
        };
        System.out.println(numSpecial(mat));
    }
}
