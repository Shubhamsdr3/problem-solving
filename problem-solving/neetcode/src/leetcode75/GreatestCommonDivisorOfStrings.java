package leetcode75;

public class GreatestCommonDivisorOfStrings {

    /**
     * Two strings will be gcd if and only if str1 + str2 == str2 + str1
     * @param str1
     * @param str2
     * @return
     */
    private static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcd = gcd3(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    /**
     * Iterative method.
     * @param n1
     * @param n2
     * @return
     */
    private static int gcd(int n1, int n2) {
        int i;
        if (n1 < n2) {
            i = n1;
        } else {
            i = n2;
        }
        for (; i > 1; --i) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i; // if n1 and n2 both are divisible by some value of i then i is gcd.
            }
        }
        return i;
    }

    /**
     * Using Euclidean method.
     * 1. repeated subtraction.
     * @param a
     * @param b
     * @return
     */
    private static int gcd2(int a, int b) {
        if (b == 0) return a;
        return gcd(b, Math.abs(a - b));
    }

    /**
     * Using Euclidean method.
     * 1. repeated division.
     * T.C -> O(log(min(a,b)
     * @param a
     * @param b
     * @return
     */
    private static int gcd3(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));


        int n1 = 20;
        int n2 = 30;
        System.out.println(gcd3(n1, n2));
    }
}
