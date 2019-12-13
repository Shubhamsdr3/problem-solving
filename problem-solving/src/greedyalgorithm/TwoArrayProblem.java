package greedyalgorithm;

import java.util.Arrays;

public class TwoArrayProblem {

    // Complete the twoArrays function below.
    private static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i =0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] + B[j] >= k) {
                    B[j] = -1;
                    break;
                }
            }
        }

        for (int i : B) {
            if (i != -1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[] A1 = new int[]{1, 3};
        int[] B1 = new int[]{3, 1};
        int k1 =4;

        int[] A2 = new int[]{2, 3, 1, 1, 1};
        int[] B2 = new int[]{1, 3, 4, 3, 3};
        int k2 =5;

        int[] A3 = new int[]{1, 5, 1, 4, 4, 2, 7, 1, 2, 2};
        int[] B3 = new int[]{8, 7, 1, 7, 7, 4, 4, 3, 6, 7};
        int k3 =9;

        int[] A4 = new int[]{3, 6, 8, 5, 9, 9, 4, 8, 4, 7};
        int[] B4 = new int[]{5, 1, 0, 1, 6, 4, 1, 7, 4, 3};
        int k4 = 9;

        int[] A5 = new int[]{4, 4, 3, 2, 1, 4, 4, 3, 2, 4};
        int[] B5 = new int[]{2, 3, 0, 1, 1, 3, 1, 0, 0, 2};
        int k5 = 4;

        System.out.println(twoArrays(k1, A1, B1));
        System.out.println(twoArrays(k2, A2, B2));
        System.out.println(twoArrays(k3, A3, B3));
        System.out.println(twoArrays(k4, A4, B4));
        System.out.println(twoArrays(k5, A5, B5));

    }

}
