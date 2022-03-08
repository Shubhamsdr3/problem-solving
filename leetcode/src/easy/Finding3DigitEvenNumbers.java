package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finding3DigitEvenNumbers {

    private static int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (digits[j] == i && i % 2 == 0) {
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }
        return res;
    }

    private static void containsDigit() {

    }

    public static void main(String[] args) {
        int[] res = new int[]{2, 1, 3, 0};
        System.out.println(Arrays.toString(findEvenNumbers(res)));
    }
}
