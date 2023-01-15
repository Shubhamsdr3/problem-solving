package medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    private static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add(0, "");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size(); // number of nodes already in the queue.
            for (int k = 1; k <= size; k++) {
                String str = ans.remove(0); // get the previously added item and append current character.
                for (char ch: mapping[x].toCharArray()) {
                    ans.add(str + ch);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }
}
