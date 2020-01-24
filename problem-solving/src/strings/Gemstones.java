package strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Gemstones {

    //TODO:SHUBHAM
    private static int gemstones(String[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        String toSearch = removeDuplicates(arr[0]);
        int count = 0;

        int sum = 0;
        int k = 0;
        for (int i=0; i < toSearch.length(); i++) {
            while (k < arr.length -1) {
                for (int j=i; j < arr[k+1].length(); j++) {
                    if (toSearch.charAt(i) == arr[k+1].charAt(j)) {
                        count++;
                        break;
                    }
                }
                k++;
            }
            if (count == arr.length -1) {
                sum++;
            }
        }
        return sum;
    }

    private static String removeDuplicates(String string) {
        char[] arr = string.toCharArray();
        Set<Character> characters = new LinkedHashSet<>();
        for (char c: arr) {
            characters.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c: characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "abc", "bc"};

        String[] strings1 = new String[]{"vtrjvgbj", "mkmjyaeav", "sibzdmsk"};

        String[] strings2 = new String[]{"abcdde", "baccd", "eeabg"};

//        System.out.println(gemstones(strings));
//        System.out.println(gemstones(strings1));
        System.out.println(gemstones(strings2));

    }
}
