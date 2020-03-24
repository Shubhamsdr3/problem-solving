package biweekly21;

import java.util.Arrays;

public class IncreasingDecreasingString {

    private static String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        char smallest = arr[0];
        char largest = arr[arr.length-1];
        sb.append(smallest);
        for (int i =1; i < arr.length; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static char findSmallerCharacter(char c, char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= c) {
                return arr[i];
            }
        }
        return c;
    }


    public static void main(String[] args) {

    }
}
