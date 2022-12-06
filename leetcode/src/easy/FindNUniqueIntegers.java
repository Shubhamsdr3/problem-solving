package easy;

import java.util.Arrays;

public class FindNUniqueIntegers {

    private static int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n -1; i = i + 2) {
            res[i] = i + 1;
            res[i + 1] = - (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(1)));
    }
}
