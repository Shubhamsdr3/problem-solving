package implementation;

public class RepeatedString {

    private static long repeatedString(String s, long n) {
        if (s.length() == 1) {
            return n;
        }
        long sum = 0;
        long noOfA;
        long i = 1;
        while (i <= n) {
            long index = i;
            if (i < n) {
                noOfA = numberOfA(s);
            } else {
                String str = s.substring(0, (int) (i % n));
                noOfA = numberOfA(str);
            }
            sum = sum + noOfA;
            i = index + (s.length() % i);
        }
        return sum;
    }

    private static int numberOfA(String str) {
        int count = 0;
        for (char c: str.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "aba";
        long n = 10;

        String string1 = "ceebbcb";
        long n1 = 817723;

        String string2 = "gfcaaaecbg";
        long n2 = 547602;
        System.out.println(repeatedString(string, n));
    }
}
