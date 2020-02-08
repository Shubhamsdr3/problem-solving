package bitmanipulation;

import java.util.HashMap;

public class CounterGame {

    //FIXME:SHUBHAM
    private static final String LOUISE = "Louise";
    private static final String RECHARD = "Richard";

    private static String counterGame(long n) {
        HashMap<String, Long> map = new HashMap<>();
        long input = n;
        while (input > 1) {
            input = input - greatestPower(input);
            map.put(LOUISE, input);
            input = input - greatestPower(input);
            map.put(RECHARD, input);
        }

        for (HashMap.Entry<String, Long> val: map.entrySet()) {
            if (val.getValue() == 0) {
                return val.getKey();
            }
        }
        return "";
    }

    private static long greatestPower(long num) {
       long result = 0;
       int i = 1;
       if (num == 2) {
           return 2;
       }
       while (result < num -2) {
           result = (long) Math.pow(2, i);
           i++;
       }
       return result;
    }

    private static boolean isPowerOfTwo(long n) {
        if (n == 0)
            return false;
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        long n = 6;
        System.out.println(counterGame(n));
    }
}
