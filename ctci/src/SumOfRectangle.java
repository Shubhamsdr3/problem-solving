import java.util.Scanner;

public class SumOfRectangle {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        int n = 3;
        int m = 3;

//        int[][] matrix = new int[n][m];

        int[][] matrix = new int[][] {
                {1, 2, 3},
                {-3, -2, -1},
                {1, 2, 3}
        };

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                int sum = matrix[i][j] + matrix[i][j+1];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
