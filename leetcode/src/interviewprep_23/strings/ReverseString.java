package interviewprep_23.strings;

public class ReverseString {

    private static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = new char[] { 'h', 'e', 'l', 'l', 'o' };
        reverseString(arr);
        System.out.println(arr);
    }
}
