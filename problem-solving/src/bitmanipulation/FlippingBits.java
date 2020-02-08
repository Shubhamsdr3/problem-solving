package bitmanipulation;

import java.util.Arrays;

public class FlippingBits {

    private static long flippingBits(long n) {
        byte[] binary = toBinary(n);
        long value = 0;
        long base = 1;
        for (int i = binary.length -1; i > 0; i--) {
            if (binary[i] == 0) {
                value = value + base;
            }
            base = base * 2;
        }
        System.out.println(Arrays.toString(binary));
        return value;
    }

    private static long flippingBits1(long n) {
        long maxInt = (long) (Math.pow(2, 32) -1);
        return maxInt - n;
    }

    private static byte[] toBinary(long number) {
        byte[] binary = new byte[32];
        int index = binary.length -1;
        long copyOfInput = number;
        while (copyOfInput > 0) {
            binary[index--] = (byte) (copyOfInput % 2);
            copyOfInput = copyOfInput / 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        long n = 4;
        System.out.println(flippingBits1(n));
    }
}
