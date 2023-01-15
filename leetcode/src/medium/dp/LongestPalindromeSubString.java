package medium.dp;

public class LongestPalindromeSubString {

    /**
     * We are starting at the middle(i) and
     * expanding outward to check if string is palindrome.
     * @param str
     * @return
     */
    private static String longestPalindromeImproved(String str) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = extend(str, i, i); // for odd length
            int len2 = extend(str, i, i + 1); // for even length
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1/2): (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return str.substring(idx, idx + max);
    }

    private static int extend(String str, int i, int j) {
        for (; i >= 0 && j < str.length(); i--, j++) {
            if (str.charAt(i) != str.charAt(j)) break; // the string is not palindrome.
        }
        return j - i - 2 + 1; // 2 means current two unmatched char.
    }

    /**
     *
     * @param str
     * @return
     */
    private static String longestPalindrome(String str) {
        if (str.length() < 2) return str;
        if (str.length() == 2 && str.charAt(0) != str.charAt(1)) {
            return str.substring(0, 1);
        }
        String prev = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subString = str.substring(i, j + 1);
                if (isPalindrome(subString)) {
                    if (subString.length() > prev.length()) {
                        prev = subString;
                    }
                }
            }
        }
        return prev;
    }

    private static boolean isPalindrome(String subString) {
        int start = 0;
        int end = subString.length() - 1;
        while (start < end) {
            if (subString.charAt(start) != subString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        String str1 = "cbbd";
        System.out.println(longestPalindrome(str1));
        String str2 = "bb";
        System.out.println(longestPalindrome(str2));

        String str3 = "ac";
        System.out.println(longestPalindrome(str3));
    }
}
