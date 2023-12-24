package easy;

public class ArrangingCoins {

    private static int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i = i + 1;
            n = n - i;
        }
        return n == 0 ? i : i-1;
    }

    public static void main(String[] args) {
        int numberOfCoins = 5;
        System.out.println(arrangeCoins(numberOfCoins));
    }
}
