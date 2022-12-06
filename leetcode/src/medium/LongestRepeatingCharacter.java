package medium;

/**
Created at: 28/09/22
*/
public class LongestRepeatingCharacter {

    private static int characterReplacement(String s, int k) {
        int i = 0;
        int j = i +1;
        int count = 0;
        while (i < s.length() && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
            } else {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(str, k));
    }
}
