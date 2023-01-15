package easy;

import java.util.Arrays;

public class MinimumSumOfFourDigit {

    private static int minimumSum(int num) {
        int[] digits = new int[4];
        int curr = 0;
        while (num > 0) {
            digits[curr++] = num % 10;
            num = num / 10;
        }
        Arrays.sort(digits); //
        int num1 = digits[0] * 10 + digits[2]; // 1st and 3rd digit
        int num2 = digits[1] * 10 + digits[3]; // 2nd and 4th digit
        return num1 + num2;
    }

    public static void main(String[] args) {
        int num = 4009;
        System.out.println(minimumSum(num));
    }
}
