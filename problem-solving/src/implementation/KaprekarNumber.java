package implementation;

public class KaprekarNumber {

    private static void kaprekarNumbers(int p, int q) {
        boolean isPossible = false;
        if (p == 1) {
            System.out.print("1 ");
        }
        for (int i = p+1; i <=q; i++) {
            long res = (long) Math.pow(i, 2);
            String string = String.valueOf(res);
            if (string.length() > 1) {
                if ((isKaprekarNumber(string, i))) {
                    isPossible = true;
                    System.out.print(i + " ");
                }
            }
        }
        if (!isPossible) {
            System.out.print("INVALID RANGE");
        }
    }

    private static boolean isKaprekarNumber(String string, int i) {
        int left = string.length() / 2;
        String leftString = string.substring(0, left);
        String rightString = string.substring(left);
        int leftInt = Integer.parseInt(leftString);
        int rightInt = Integer.parseInt(rightString);
        if ((leftInt + rightInt == i)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int p = 1;
        int q = 99999;
        kaprekarNumbers(p, q);
    }

}
