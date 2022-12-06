package medium;

public class PermutationInString {

    private static boolean checkInclusion(String s1, String s2) {
        if (s2.length() > s1.length()) return false;
        int[] freqS1 = new int[26];
        // get the frequency for the s1.
        for (char c : s1.toCharArray()) {
            freqS1[c - 'a']++;
        }
        int[] freqS2 = new int[26];
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            freqS2[s2.charAt(j) - 'a']++; // frequency for the second one.
            if (j - i + 1 == s1.length()) {
                return isSame(freqS1, freqS2);
            }
            if (j - i + 1 < s1.length()) j++;
            else {
                freqS2[s2.charAt(i) - 'a']--;
                i++;
                j++;
            }
        }
        return false;
    }

    private static boolean isSame(int[] freqS1, int[] freqS2) {
        for (int i = 0; i < 26; i++) {
            if (freqS1[i] != freqS2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }
}
