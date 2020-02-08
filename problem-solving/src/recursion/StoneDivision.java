package recursion;

import java.util.Arrays;

public class StoneDivision {

    private static long stoneDivision(long n, long[] s) {
        long count = 0;
        Arrays.sort(s);
        long size = n;
        for (int i = s.length -1; i >= 0 ; i--) {
            if (s[i] != size && (size % s[i] == 0) && size >= s[i]) {
                long q = size / s[i];
                size = size / q;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long n = 12;
        long[] arr = new long[]{2, 3, 4};
        System.out.println(stoneDivision(n, arr));
    }
}
