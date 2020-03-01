package easy;

public class RepeatedSubstringPattern {

    //FIXME: optimized this one.,
    private static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }
        if (s.length() == 2 && s.charAt(0)  != s.charAt(1)) {
            return false;
        }
        for (int i=1; i < s.length(); i++) {
            if (isSubstring(s, s.substring(0, i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSubstring(String str, String pattern) {
        int i =0;
        int j = pattern.length();
        while (i < str.length()) {
            if (j > str.length() || !str.substring(i, j).equals(pattern)) {
                return false;
            }
            i = j;
            j = j + pattern.length();
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabaaba";
        System.out.println(repeatedSubstringPattern(str));
    }
}
