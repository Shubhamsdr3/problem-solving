package recursion;

public class RecursiveDigit {

    private static int superDigit(String n, int k) {
        StringBuilder stringBuilder = new StringBuilder(n);
        while (k > 1) {
            stringBuilder.append(n);
            k--;
        }
        return getSuperDigit(stringBuilder.toString());
    }

    private static int getSuperDigit(String string) {
        int n = string.length();
        if (n == 1) {
            return Integer.parseInt(string);
        }
        long superDigit = 0;
        int len = n;
        while (len > 0) {
            superDigit = superDigit + Integer.parseInt(string.substring(len - 1, len));
            len--;
        }
        return getSuperDigit(String.valueOf(superDigit));
    }

    public static void main(String[] args) {
        String n = "999999";
        int k = 100000;
        System.out.println(superDigit(n, k));
    }
}
