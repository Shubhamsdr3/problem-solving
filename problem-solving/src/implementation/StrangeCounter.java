package implementation;

import java.util.ArrayList;
import java.util.List;

public class StrangeCounter {

    private static long strangeCounter(long t) {
        List<Long> list = new ArrayList<>();
        long i ;
        long n = t;
        long val = 3;
        while (n > 0) {
            for (i = val; i > 0; i--) {
                list.add(i);
                System.out.println(i);
                n--;
            }
            val = val * 2;
        }
        return list.get((int) t -1);
    }

    private static long strangeCounter1(long t) {
        long rate = 3;
        while (t > rate) {
            t = t - rate;
            rate = rate * 2;
        }
        return rate - t + 1;
    }

    public static void main(String[] args) {
        long time = 17;
//        long startTime1 = System.currentTimeMillis();
//        System.out.println(strangeCounter(time));
//        System.out.println(System.currentTimeMillis() - startTime1);

        long startTime2 = System.currentTimeMillis();
        System.out.println(strangeCounter1(time));
        System.out.println(System.currentTimeMillis() - startTime2);
    }
}
