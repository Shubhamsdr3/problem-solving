package interviewprep_23.strings;

public class FirstUniqueCharacter {

    private static int firstUniqueChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(firstUniqueChar(str));
    }
}
