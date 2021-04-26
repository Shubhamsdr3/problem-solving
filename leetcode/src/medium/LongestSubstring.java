package medium;

public class LongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && j < s.length()) {
            if (!sb.toString().contains(s.substring(j, j+1))) {
                sb.append(s.charAt(j));
                j++;
            } else  {
                i++;
                j = i;
                sb.setLength(0);
                sb = new StringBuilder();
            }
            maxLength = Math.max(sb.length(), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
