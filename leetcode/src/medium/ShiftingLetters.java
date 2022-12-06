package medium;

public class ShiftingLetters {


    /**
     * TLE
     * @param s
     * @param shifts
     * @return
     */
    private static String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = 0; i < sb.length() && j < shifts.length; i++, j++) {
            String subString = sb.substring(0, i+1);
            int shift = shifts[j];
            for (int k = 0; k < subString.length(); k++) {
                char ch = (char) (subString.charAt(k) - 'a');
                ch = (char) ((ch + shift) % 26 + 'a');
                sb.setCharAt(k, ch);
            }
        }
        return sb.toString();
    }

    /***
     * Improved
     * @param s
     * @param shifts
     * @return
     */
    private static String shiftingLettersImproved(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder(s);
        long shift = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = (char) (s.charAt(i) - 'a');
            ch = (char) ((ch + shift + shifts[i]) % 26 + 'a');
            sb.setCharAt(i, ch);
            shift = shift + shifts[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bad";
        int[] shifts = new int[]{10, 20, 30};
        System.out.println(shiftingLettersImproved(str, shifts));
    }
}
