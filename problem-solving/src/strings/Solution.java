package strings;

import java.util.Arrays;

public class Solution {

    private static String smalledString(String string) {
        String[] result = new String[string.length() -1];
        int k = 0;
        char[] arr = string.toCharArray();
        for (int i=0; i < arr.length -1; i++) {
            char[] newChar = replace(arr, i, i+1);
            String newString = getStringFromCharArray(newChar);
            result[k] = newString;
            k++;
        }
        Arrays.sort(result);
        return result[0];
    }

    private static char[] replace(char[] arr, int i, int j) {
        char ch = arr[i];
        char temp = arr[j];
        arr[j] = ch;
        arr[i] = temp;
        return arr;
    }

    private static String getStringFromCharArray(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "QKMU";
        String string1 = "MJJAB";
        System.out.println(smalledString(string1));
    }
}
