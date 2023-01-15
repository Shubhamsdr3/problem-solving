package hard;

import java.util.HashMap;
import java.util.Map;

/**
Created at: 12/01/23
*/
public class MinimumNumberOfDaysEatNOranges {

    private static Map<Integer, Integer> dp = new HashMap<>();

    /**
     * If n % 2 == 0 -> eat n/2
     * if n % 3 == 0 -> eat 2 * (n / 3)
     * other eat 1
     * @param n
     * @return
     */
    private static int minDays(int n) {
        dp.put(0, 0);
        return findMinimum(n);
    }

    private static int findMinimum(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n); // there is already a solution.
        }
        int ans = Integer.MAX_VALUE;
        if (n % 3 == 0 && n % 2== 0) { // divisible by both.
            // 1 + bcz you will increase the day count as you eat one apple.
            // so find whichever yields minimum
            // among n / 2 and n / 3.
            ans = Math.min(ans, 1 + Math.min(minDays(n / 3), minDays(n /2)));
        } else if (n % 3 == 0) {
            // only divisible by 3 but not 2 i.e it's a odd number try n / 3
            // or it may happen that going to the nearest
            // even number i.e (n -1) might yield better answer
            // (which can take n/2 route) so try that.
            ans = Math.min(ans, 1 + Math.min(findMinimum(n / 3), findMinimum(n -1)));
        } else if (n % 2 == 0) {
            // only divisible by 2 but not 2 try n/2
            // similar to the previous case, now find nearest number divisible by 3.
            if ((n -1) % 3 == 0) {
                ans = Math.min(ans, 1 + findMinimum(n -1));
            } else {
                ans = Math.min(ans, 2 + findMinimum(n -1));
            }
        } else  {
            // Not divisible by 3 and 2..which means an odd number.
            ans = Math.min(ans, 1 + findMinimum(n -1)); // (n -1) must be even, which will try n / 2 route.
            if ((n -2) % 3 == 0) {
                ans = Math.min(ans, 2 + findMinimum(n -2)); // if (n-2) is divisible by 3, then solve  that which will
                                                                // be taken n/3 route.
            }
        }
        dp.put(n, ans);
        return dp.get(n);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(minDays(n));
    }
}
