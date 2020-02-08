package easy;

public class IsSubSequence {

    private static boolean isSubsequence(String s, String t) {
       int i = 0;
       int j = 0;
       while (i < s.length() && j < t.length()) {
           if (s.charAt(i) == t.charAt(j)) {
               i++;
           }
           j++;
       }
       if (i == s.length()) {
           return true;
       }
       return false;
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
