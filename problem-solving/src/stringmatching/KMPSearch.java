package stringmatching;


/**
 * KMP -> Knuth-Morris-Pratt algorithm
 * We create a Pie  table or Longest Prefix Substring (LPS)
 * Time complexity: O(m + n)
 *  where m -> length of pattern , n -> length of string
 *  Space complexity: O(m): for Pie table.
 */
public class KMPSearch {

    private static boolean kmpSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int[] lps = new int[m]; // prefix table.
        computeLPSArray(pattern, m, lps);
        int j = 0; // index of pattern
        int i = 0; // index of text
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) { // jab tak matching..chalte rho..
                i++;
                j++;
            } else {
                if (j != 0) { // mtlb ni mila pattern..bhai fir se tujhe back track karna hoga
                    // yad hai n wo bachpan me snake-ladder wala game waise hi hai kuchh ye bhi..not exactly.
                    j = lps[j -1];
                } else {
                    i++; // aur agar j already 0 pe hai means there is no previous character then move text forward
                }
            }
        }
       return j == m; // if true: mtlb ye hai bhai ki pattern ke sare character mil gye hume text me..congrats !!
    }

    /**
     * Creating prefix table, yad hai n wo bachpan me snake-ladder wala game waise hi hai kuchh ye bhi..not exactly.
     * @param pattern
     * @param m
     * @param lps
     */
    private static void computeLPSArray(String pattern, int m, int[] lps) {
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) { // subsequent elements are matching i.e. found a prefix
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len -1];
            } else {
                lps[i] = len;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String text = "abdabcabcabababd";
        String pattern = "ababd";
        System.out.println(kmpSearch(pattern, text));
    }
}
