
import java.util.Scanner;

public class PrimeNumberGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] primes = new int[4000];
        int numprimes = 0;

        primes[numprimes++] = 2;

        for (int i = 3; i <= 32000; i+=2) {
            boolean isPrime = true;
            double cap = Math.sqrt(i) + 1.0;

            for (int j = 0; j < numprimes; j++) {
                if (j >= cap) break;
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes[numprimes++] = i;
        }


        int T,N,M;

        T = in.nextInt();

        for (int t = 0; t < T; t++) {
            if (t > 0) System.out.println("");

            M = in.nextInt();
            N = in.nextInt();

            if (M < 2) M = 2;

            boolean[] isPrime = new boolean[100001];
            for (int j = 0; j < 100001; j++) {
                isPrime[j] = true;
            }
            
            for (int i = 0; i < numprimes; i++) {
                int p = primes[i];
                int start;

                if (p >= M) start = p*2;
                else start = M + ((p - M % p)%p);

                for (int j = start; j <= N; j += p) {
                    isPrime[j - M] = false;
                }
            }

            for (int i = M; i <= N; i++) {
                if (isPrime[i-M]) System.out.println(i);
            }
        }
    }
}
