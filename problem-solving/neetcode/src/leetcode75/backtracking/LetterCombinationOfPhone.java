package leetcode75.backtracking;

import java.util.*;

public class LetterCombinationOfPhone {

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    /**
     * Recursive method.
     * @param digits
     * @return
     */
    private static List<String> letterCombinationsRec(String digits) {
        List<String> result = new LinkedList<>();
        combination("", digits, 0, result);
        return result;
    }

    private static void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) { // traversed all the digits in current branch DFS
            result.add(prefix);
            return;
        }

        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, result);
        }
    }

    /**
     * Iterative solution.
     * @param digits
     * @return
     */
    private static List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        result.add(0, "");
        for (char ch: digits.toCharArray()) {
            int num = Character.getNumericValue(ch);
            int size = result.size();
            for (int k = 1; k <= size; k++) {
                String str = result.remove(0);
                for (char ch1: map.get(num).toCharArray()) {
                    result.add(str + ch1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
