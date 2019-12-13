package dynamicprogramming;

import java.util.Arrays;

public class ConstructArray {

    /**
     * @param n: Number of elements in the array.
     * @param k: The array element should be between [1, k]
     * @param x: The last element of the array.
     * @return : the number of ways to fill in the array.
     */
    private static long countArray(int n, int k, int x) {
        long numberOfWays = 0;

        // k = 1, 2, 3
        // result = [1, 2, 1, 2]
        // result = [1, 2, 3, 2]
        // result = [1, 3, 1, 2]
        int[] result = new int[n];
        result[0] = 1;
        result[n -1] = x;

        for (int i=1; i <= k; i++) {
            for (int j=1; j < n -1; j++) {
                if (result[j] != i && result[j -1] != i && i != result[n-1]) {
                    result[j] = i;
                    numberOfWays++;
                    System.out.println(Arrays.toString(result));
                } else {
                    result[j] = i+1;
                }
            }
        }
        return numberOfWays;
    }

    public static void main(String[] args) {
        int n= 4;
        int k =3;
        int x = 2;
//        int n= 5;
//        int k =2;
//        int x = 2;

        System.out.println(countArray(n , k, x));
    }

}
