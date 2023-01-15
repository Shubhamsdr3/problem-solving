package easy;

import java.util.*;

public class PositionsOfLargeGroups {

    private static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int end = 1;
        while (start < s.length()) {
            while (end < s.length() && s.charAt(start) == s.charAt(end)) {
                end++;
            }
            if (end - start >= 3) {
                list.add(Arrays.asList(start, end -1));
            }
            start = end;
        }
        return list;
    }

    private static boolean areEquals(String str) {
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcdddeeeeaabbbcd";
        String str1 = "abbxxxxzzy";
        System.out.println(largeGroupPositions(str));
    }
}
