package easy;

import java.util.Arrays;

public class DefuseTheBomb {

    private static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) return res;
        // defind the intial window
        int start = 1;
        int end = k;
        int sum = 0;
        if (k < 0) {
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) {
            sum = sum + code[i];
        }
        // scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum = sum - code[(start++) % code.length];
            sum = sum + code[(++end) % code.length];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] code = new int[] { 5, 7, 1, 4};
        int k = 3;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }
}
