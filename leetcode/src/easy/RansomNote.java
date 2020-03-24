package easy;

import java.util.HashMap;

public class RansomNote {

    private static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) +1);
        }
        for (char ch: ransomNote.toCharArray()) {
            if (count.containsKey(ch)) {
                count.put(ch, count.getOrDefault(ch, 0) -1);
            }
        }
        for (char c : ransomNote.toCharArray()) {

        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "aab";
        System.out.print(canConstruct(str1, str2));
    }
}
