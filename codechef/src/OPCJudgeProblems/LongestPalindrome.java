package OPCJudgeProblems;

public class LongestPalindrome {

    private static String longestPalindrome(String str) {
        int i =0;
        int j = str.length()-1;
        int count = 0;
        while (i < str.length()) {
            if (j >= 0 && str.charAt(i) == str.charAt(j)) {
                count++;
                i++;
                j--;
            } else {
                count = 0;
                i++;
                j = str.length()-1;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "abcbcabbacba";
        System.out.print(longestPalindrome(str));
    }
}
