package medium;

public class ValidParenthesisString {

    /**
     * T.C = O(n)
     * Space: O(1)
     * @param s
     * @return
     */
    private static boolean checkValidString(String s) {
        int cMin = 0;
        int cMax = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                cMin++;
                cMax++;
            } else if (c == ')') {
                cMin--;
                cMax--;
            } else if (c == '*') {
                cMin--; // if * becomes (
                cMax++; // if * becomes )
            }
            if (cMax < 0) return false; // open parentheses is less than closed parentheses.
            cMin = Math.max(cMin, 0); //
        }
        return cMin == 0;
    }

    public static void main(String[] args) {
        String str = "(*)))";
        System.out.println(checkValidString(str));
    }
}
