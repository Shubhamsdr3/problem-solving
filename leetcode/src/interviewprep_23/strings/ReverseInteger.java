package interviewprep_23.strings;

public class ReverseInteger {

    private static int reverseWithInt(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10;
            res = res + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    /**
     * Using StringBuilder.
     */
    private static int reverse(int x) {
        if (x == 0) return 0;
        StringBuilder sb = new StringBuilder();
        int val = Math.abs(x);
        while (val > 0) {
            sb.append(val % 10);
            val = val / 10;
        }
        try {
            if (x < 0) {
                return -Integer.parseInt(sb.toString());
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = 0;
        int x1 = 0;
        System.out.println(reverseWithInt(x));
    }
}
