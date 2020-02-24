package easy;

import java.util.Arrays;

public class PlusOne {

    //TODO: My approach...wrong
    private static int[] plusOne(int[] digits) {
        int index = digits.length-1;
        int sum = digits[index] + 1;
        if (sum > 9) {
            int carry = sum / 10;
            sum(digits, carry, index);
        } else {
            digits[index] = sum;
        }
        return digits;
    }
    private static void sum(int[] arr, int carry, int index) {
        if (carry == 0 || index <= 0) {
            if (carry > 0) {
                arr = new int[arr.length + 1];
                arr[0] = 1;
            }
            return;
        }
        int sum = arr[index] + carry;
        arr[index] = sum % 10;
        carry = sum / 10;
        sum(arr, carry, index-1);
    }

    //TODO: right one
    private static int[] plusOne1(int[] digits) {
        int carry = 1;
        int index = digits.length-1;
        while (index >=0 && carry > 0) {
            digits[index] = (digits[index] + carry) % 10;
            carry = digits[index] == 0 ? 1 : 0;
            index--;
        }
        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9}; //TODO: handle this case
        System.out.println(Arrays.toString(plusOne1(arr)));
    }
}
