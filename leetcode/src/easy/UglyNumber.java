package easy;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    /**
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * @param num:
     * @return :
     */
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
        int num = 8;
        System.out.println(isUgly(-2147483648));
        System.out.println(isUgly(14));
        System.out.println(isUgly(6));
    }
}
