package strings;

import java.util.Arrays;
import java.util.HashMap;

public class WeightedUniformString {

    private static String[] weightedUniformStrings(String s, int[] queries) {
        HashMap<Integer, Character> alphabets = new HashMap<>(26);
        int itr = 1;
        for (int i=0; i < s.length(); i++) {
            alphabets.put((((int)s.charAt(i)) - 96) * itr, s.charAt(i));
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                itr++;
            } else {
                itr = 1;
            }
        }
        String[] result = new String[queries.length];
        int k=0;
        for (int val: queries) {
            if (alphabets.containsKey(val)) {
                result[k] = "Yes";
            } else {
                result[k] = "No";
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] queries = new int[]{1, 3, 12, 5, 9, 10};
        String string = "abccddde";

        int[] queries1 = new int[]{9, 7, 8, 12, 5};
        String string1 = "aaabbbbcccddd";

        System.out.println(Arrays.toString(weightedUniformStrings(string1, queries1)));
    }
}
