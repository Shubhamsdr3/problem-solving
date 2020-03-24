package marchcookoff;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindYourGift {

    private static void findGift(String str) {
        int x = 0;
        int y = 0;
        str = removeDuplicates(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L' || str.charAt(i) == 'R') {
                char c = str.charAt(i);
                if (c == 'L') {
                    x--;
                } else {

                }
            } else if (str.charAt(i) == 'U' || str.charAt(i) == 'D') {

            }
        }
        System.out.print(x + " " + y);
    }

    private static String removeDuplicates(String str) {
        if (str.length() < 2) {
            return str;
        }
        StringBuilder sb =  new StringBuilder();
        char[] arr = str.toCharArray();
        sb.append(arr[0]);
        int index = 0;
        for (int i =1; i < str.length(); i++) {
            if (sb.charAt(index) != arr[i]) {
                if (arr[i] == 'L' || arr[i] == 'R') {
                    sb.append(arr[i]);
                } else if (sb.charAt(index) == 'D' || sb.charAt(index) == 'U') {
                    sb.charAt(arr[i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LLLRUUD";
        findGift(str);
    }
}
