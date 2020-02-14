package implementation;

import java.util.Arrays;

public class CircularArrayRotation {

    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        while (k > 0) {
            int temp = a[n-1];
            for (int i = n-1; i > 0; i--) {
                a[i] = a[i-1];
            }
            a[0] = temp;
            k--;
        }
        int[] result = new int[queries.length];
        for (int i=0; i < queries.length; i++) {
            result[i] = a[queries[i]];
        }
        return result;
    }



    public static void main(String[] args) {
        int rotationCount = 2;
        int[] arr = new int[]{1, 2, 3};
        int[] queries = new int[]{0, 1, 2};

        int rotationCount1 = 2;
        int[] arr1 = new int[]{3, 4, 5};
        int[] queries1 = new int[]{1, 2};
        System.out.println(Arrays.toString(circularArrayRotation(arr1, rotationCount1, queries1)));
    }
}
