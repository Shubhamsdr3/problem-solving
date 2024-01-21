package problemsolving.leetcode75;

public class ReverseVowelsOfAString {

    // result -> "a man, a plan, a canal: PanamA"
    private static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start < end) {
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    private static String swap(String lowerString, int start, int end) {
        StringBuilder sb = new StringBuilder(lowerString);
        char temp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "leetcode";
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "aA";
        String str4 = "A man, a plan, a canal: Panama";
        System.out.println(reverseVowels(str4));
    }
}
