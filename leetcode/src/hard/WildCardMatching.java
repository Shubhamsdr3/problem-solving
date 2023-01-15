package hard;

public class WildCardMatching {

    //TODO
    private static boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int match = 0;
        int startIdx = -1;

        while (sIndex < s.length()) {
            // advancing both pointer.
            if (pIndex < p.length() && (p.charAt(pIndex) == '?') || s.charAt(sIndex) == p.charAt(pIndex)) {
                sIndex++;
                pIndex++;
            }
            // * found , only advancing pattern pointer
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                startIdx = pIndex;
                match = sIndex;
                pIndex++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (startIdx != -1) {
                pIndex = startIdx + 1;
                match++;
                sIndex = match;
            }
            // current pattern pointer is not star, last pattern pointer was not *
            // characters don't match
            else return false;
        }
        // check for remaining characters in pattern
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }

    public static void main(String[] args) {
        String str = "aa";
        String p = "a";
        System.out.println(isMatch(str, p));
    }
}
