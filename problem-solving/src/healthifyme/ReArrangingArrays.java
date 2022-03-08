package healthifyme;

import java.util.Arrays;

public class ReArrangingArrays {

    private static int[] solve(int N, int[] A, int X) {
        int[] result = new int[N];
        int xCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                xCount++;
                A[i] = -1;
            }
        }
        int index = xCount;
        for (int i = 0; i < N; i++) {
            if (A[i] != -1) {
                result[index] = A[i];
                index++;
            }
        }
        for (int i = 0; i < xCount; i++) {
            result[i] = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 7;
        int[] input = new int[] {
                3, 5, 3, 5, 5, 11, 5
        };
        int X = 5;
        System.out.println(Arrays.toString(solve(N, input, X)));
    }
}
