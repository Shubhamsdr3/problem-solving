package problemsolving.leetcode75.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfVowels {

    /**
     *
     * @param s
     * @param k
     * @return
     */
    private static int maxVowels2(String s, int k) {
        int ans = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0, winCount = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCount; // when you shift the window to the right. add to right.
            }
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                --winCount; // remove from left.
            }
            ans = Math.max(winCount, ans);
        }
        return ans;
    }

    /**
     * TC -> O(nk)
     * @param s
     * @param k
     * @return
     */
    private static int maxVowels(String s, int k) {
        int i = 0;
        int j = i + k;

        String vowels = "aeiou";

        int maxCount = Integer.MIN_VALUE;
        while (j <= s.length()) {
            String subString = s.substring(i, j);
            int count = 0;

            for (char ch: subString.toCharArray()) {
                if (vowels.contains(ch + "")) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
            i++;
            j++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String str = "abciiidef";
        int k = 3;

        String str1 = "aeiou";
        int k1 = 2;

        String str2 = "leetcode";
        int k2 = 3;

        String str3 = "weallloveyou";
        int k3 = 7; // expected = 4;

        System.out.println(maxVowels2(str3, k3));

//        System.out.println(maxVowels(str, k));
//        System.out.println(maxVowels(str1, k1));
//        System.out.println(maxVowels(str2, k2));
    }
}
