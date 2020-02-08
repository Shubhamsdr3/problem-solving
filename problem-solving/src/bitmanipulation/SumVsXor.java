package bitmanipulation;

public class SumVsXor {

    private static long sumXor(long n) {
        long count = 0;
        for (int i = 0; i <=n; i++) {
            if ((n + i) == (n ^ i)) {
                count++;
            }
        }
        return count;
    }

    private static long sumXor1(long n) {
        long count = 0;
        while(n > 0) {
            count += n % 2 == 0 ? 0:1;
            n/=2;
        }
        count = (long) Math.pow(2,count);
        return count;
    }

    private static int numZeroes(long n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                count++;
            }
            n >>= 1; // divides by 2
        }
        return count;
    }

    public static void main(String[] args) {
        long n = 10;
        System.out.println(sumXor1(n));
    }
}
