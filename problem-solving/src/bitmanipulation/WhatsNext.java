package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class WhatsNext {

    private static void whatsNext(int[] arr) {
        StringBuilder strings = new StringBuilder();
        for (int i=0; i < arr.length; i++) {
            strings.append(getString(arr, i));
        }
        String result = "";
        for (int j = strings.length() -1; j > 0; j--) {
            if (strings.charAt(j) == '0') {
                result = swap(strings.toString().toCharArray(), j, j+1);
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int n = 0;
        while (n < result.length()) {
            int count = getCount(result, result.charAt(n), n);
            n = n + count;
            ans.add(count);
        }

        System.out.println(ans.size());
        for (int val: ans) {
            System.out.print(val + " ");
        }
    }

    private static int getCount(String string, char c, int index) {
        int count = 0;
        for (int i=index; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static String swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: arr) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static String getString(int[] arr, int index) {
        StringBuilder string = new StringBuilder();
        if (index % 2 == 0) {
            int number = arr[index];
            while (number > 0) {
                string.append("1");
                number--;
            }
        } else {
            int number = arr[index];
            while (number > 0) {
                string.append("0");
                number--;
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{2, 1};
        whatsNext(arr);
    }
}
