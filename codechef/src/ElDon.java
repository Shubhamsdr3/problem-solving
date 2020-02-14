import java.util.Scanner;

public class ElDon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int testCases = sc.nextInt();
            while (testCases > 0) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                if (y < x) {
                    long farmerArea = x * x;
                    long childArea = y * y;

                    if (!isPrime(farmerArea - childArea)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                } else {
                    System.out.println("NO");
                }
                testCases--;
            }
        }
    }
    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
