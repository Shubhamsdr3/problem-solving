package easy;

import java.util.Arrays;

public class CountingBits {

    private static int[] countBits(int n) {
        int[] res = new int[n +1];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            String binary = decToBinary(i);
            int count = 0;
            for (char c: binary.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            res[index] = count;
            index++;
        }
        return res;
    }

    private static String decToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append("0");
            return sb.toString();
        }
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
