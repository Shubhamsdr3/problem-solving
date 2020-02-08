package easy;

public class CountPrime {

    /**
     * Sieve of Eratosthenes algorithm
     * @param n
     * @return
     */
    private  static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n +1];

        for (int i=0; i < n; i++) {
            isPrime[i] = true;
        }

        for(int p = 2; p*p <= n; p++) {
            if(isPrime[p]) {
                for (int i = p*p; i <= n; i += p){
                    isPrime[i] = false;
                }
            }
        }
        int count = 0;
        for (int j =2; j <= n; j++) {
            if (isPrime[j]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countPrimes(10));
    }
}
