
public class AppendDelete {
    /**
     * @param s : To modify in desired leetcode.string.
     * @param t : the desired leetcode.string.
     * @param k : number of steps to achieve the desired leetcode.string.
     * @return : the desired leetcode.string.
     */
    private static String appendAndDelete(String s, String t, int k) {
        //Find the common character for
        int commonSteps = 0;
        for (int i=0; i< Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonSteps ++;
            } else {
                break;
            }
        }
        int maxIter = s.length() + t.length();
        int minIter = maxIter - 2 * commonSteps;

        if ((k >= minIter) & ((k - minIter) % 2 == 0)) {
            return "Yes";
        } else if (k >= maxIter) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        String toConvert = "ashley";
        String desiredArray = "ash";
        System.out.println(appendAndDelete(toConvert, desiredArray, 2));
    }
}
