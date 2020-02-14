package easy;

import java.util.*;

public class UncommonWords {

    private static String[] uncommonFromSentences(String A, String B) {
        String string = A + " " + B;
        String[] strings = string.split(" ");
        Map<String, Integer> count = new HashMap<>();

        for (int i=0; i < strings.length; i++) {
            count.put(strings[i], count.getOrDefault(strings[i], 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (String str: count.keySet()) {
            if (count.get(str) ==1) {
                list.add(str);
            }
        }

        return  list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String string1 = "this apple is sweet";
        String string2 = "this apple is sour";

        String string3 = "apple apple";
        String string4 = "banana";

        String string5 = "abcd def abcd xyz";
        String string6 = "ijk def ijk";

        System.out.println(Arrays.toString(uncommonFromSentences(string1, string2)));
        System.out.println(Arrays.toString(uncommonFromSentences(string5, string6)));
    }
}
