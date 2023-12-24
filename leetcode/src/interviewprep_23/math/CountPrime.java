package interviewprep_23.math;

public class CountPrime {

    private static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                System.out.println(i);
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(countPrimes(n));
    }
}
