package medium;

public class UglyNumber2 {

    private static long nthUglyNumber(int n) {
        int index = 0;
        int num = 1;
        while (index <= n) {
            if (isUgly(num)) {
                index++;
            }
            if (index == n) {
                return num;
            }
            num++;
        }
        return 0;
    }

    private static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 103;
        System.out.println(nthUglyNumber(n));
    }
}
