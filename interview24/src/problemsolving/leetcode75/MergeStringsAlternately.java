package problemsolving.leetcode75;

public class MergeStringsAlternately {

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = word1.length() + word2.length();
        while(i < n) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "pq";

        String str3 = "abc";
        String str4 = "pqr";
        System.out.println(mergeAlternately(str3, str4));
    }
}
