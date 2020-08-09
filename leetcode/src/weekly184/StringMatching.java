package weekly184;

import java.util.*;

public class StringMatching {

    private static List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i=0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String[] input = new String[]{"leetcoder","leetcode","od","hamlet","am"};
        System.out.println(stringMatching(input));
    }
}
