package leetcode75;

public class IsSubsequence {

    private static boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) j++;
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        String str = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(str, t));
    }
}
