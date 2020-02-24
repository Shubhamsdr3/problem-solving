package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormInteger {

    //My Solution: (:
    private static List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        int index = A.length -1;
        while (index >= 0) {
            int sum = A[index] + K % 10 + carry;
            if (sum > 9) {
                A[index] = sum % 10;
                carry = sum / 10;
            } else {
                A[index] = sum;
                carry = 0;
            }
            K = K / 10;
            index--;
        }
        if (K > 0){
            List<Integer> list = new ArrayList<>();
            for (int item: A) {
                list.add(item);
            }
            while (K > 0) {
                int sum = K % 10 + carry;
                if (sum > 9){
                    list.add(sum % 10);
                    carry = sum /10;
                }
                K = K /10;
            }
            if (carry > 0) {
                list.add(carry);
            }
            Collections.reverse(list);
            return list;
        }

        if (carry > 0) {
             return arrayToList(newArray(A, carry));
        }
        return arrayToList(A);
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int item : arr) {
            list.add(item);
        }
        return list;
    }

    private static int[] newArray(int[] oldArray, int carry) {
        int[] newArray = new int[oldArray.length + 1];
        newArray[0] = carry;
        for (int i =0; i < oldArray.length; i++) {
            newArray[i+1] = oldArray[i];
        }
        return newArray;
    }

    //Optmized one
    private static List<Integer> addToArrayForm1(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5};
        int k = 806;

        int[] arr1 = new int[]{7};
        int k1 = 993;
        System.out.println(addToArrayForm1(arr1, k1));
    }
}
