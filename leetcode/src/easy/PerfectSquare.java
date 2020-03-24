package easy;

public class PerfectSquare {

    private static boolean isPerfectSquare(int num) {
        if (num ==1) {
            return true;
        }
        for (int i=2; i <= Math.sqrt(num); i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPerfectSquare(n));
    }
}
