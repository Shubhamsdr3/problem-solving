import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

//    private static long arrayManipulation(int n, int[][] queries) {
//        int[] result = new int[n];
//        Arrays.fill(result, 0);
//
//        long max = Integer.MIN_VALUE;
//        for (int j=0; j< queries.length; j++) {
//            for (int i= queries[j][0] -1; i < queries[j][1]; i++) {
//                result[i] = result[i] +  queries[j][2];
//                 if (result[i] > max) {
//                     max = result[i];
//                 }
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{
//                {1, 5, 3},
//                {4, 8, 7},
//                {6, 9, 1}
//        };
//        int n = 10;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        int[][] input = new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };

        int[] result = new int[n];
        Arrays.fill(result, 0);

        long max = Integer.MIN_VALUE;
        for (int j=0; j< input.length; j++) {
            for (int i= input[j][0] -1; i < input[j][1]; i++) {
                result[i] = result[i] +  input[j][2];
                if (result[i] > max) {
                    max = result[i];
                }
            }
        }
        System.out.println(max);

//        System.out.println(arrayManipulation(n, input));
    }
}
