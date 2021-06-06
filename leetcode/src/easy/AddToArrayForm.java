package easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    private static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int end = num.length - 1;
        int carry = 0;
        while (end >= 0 || k > 0) {
            if (k > 0 || carry > 0) {
                int sum = num[end] + k % 10 + carry;
                list.add(0, sum %10);
                carry = sum / 10;
                k = k / 10;
            } else {
                list.add(0, num[end]);
            }
            end--;
        }
        if (carry > 0) {
            list.add(0, carry);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
               0
        };
        int k = 23;
        System.out.println(addToArrayForm(arr, k));
    }
}
