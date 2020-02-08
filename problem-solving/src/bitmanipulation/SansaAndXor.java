package bitmanipulation;

import java.util.Arrays;

public class SansaAndXor {

    private static int sansaXor(int[] arr) {
        int k = 0;
        int[] result = new int[2 * arr.length];
        for (int i=0; i < result.length; i++) {
            for (int j=i+1; j < result.length; j++) {

            }
        }

        int val = result[0];
        for (int j=1; j < result.length; j++) {
            val = val ^ result[j];
        }
        return val;
    }

    private static int[] printSubsets(int[] set) {
        int n = set.length;
        int k =0;
        int[] result = new int[(int) Math.pow(2, n)];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                    result[k] = set[j];
                    k++;
                }
            }
            System.out.println();
        }
        return result;
    }

    private int xoring(int[] subArray) {
        int val = subArray[0];
        for (int j=1; j < subArray.length; j++) {
            val = val ^ subArray[j];
        }
        return val;
    }

    public static int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] arr1 = new int[]{4, 5, 7, 5};
        System.out.println(Arrays.toString(printSubsets(arr)));
//        System.out.println(sansaXor(arr1));
    }
}
