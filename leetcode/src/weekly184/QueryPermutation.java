package weekly184;

import java.util.Arrays;

public class QueryPermutation {

    private static int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        int[] permutation = new int[m];
        for (int i=1; i <= m;  i++) {
            permutation[i-1] = i;
        }
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < permutation.length; j++) {
                if (queries[i] == permutation[j]) {
                    result[index] = j;
                    shiftRight(permutation, j);
                    index++;
                }
            }
        }
        return result;
    }

    private static void shiftRight(int[] arr, int index) {
        int temp = arr[index];
        for (int i = index; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static void main(String[] args) {
        int[] queries = new int[]{7,5,5,8,3};
        int m = 8;
        System.out.println(Arrays.toString(processQueries(queries, m)));
    }
}
