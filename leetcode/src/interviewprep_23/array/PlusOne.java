package interviewprep_23.array;

import java.util.Arrays;

public class PlusOne {

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n -1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 3, 2, 9 }; //ans -> [4, 3, 3, 0]
        int[] arr1 = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(Arrays.toString(plusOne(arr1)));
    }
}
