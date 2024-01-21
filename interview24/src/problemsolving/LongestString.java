package problemsolving;

public class LongestString {

    private static String longestString(String str) {
        String[] strArray = str.split(" ");
        String maxLen = "";
        for (String s: strArray) {
            if (s.length() > maxLen.length()) {
                maxLen = s;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "fun&!! time";
        System.out.println(longestString(str));
    }
}
