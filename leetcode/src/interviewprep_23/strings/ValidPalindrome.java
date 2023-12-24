package interviewprep_23.strings;

public class ValidPalindrome {

    private static boolean isPalindrome(String s) {
        String lowerCaseString = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int start = 0;
        int end = lowerCaseString.length() - 1;
        while (start < end) {
            if (lowerCaseString.charAt(start) != lowerCaseString.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str1 =  "race a car";
        System.out.println(isPalindrome(str1));
    }
}
