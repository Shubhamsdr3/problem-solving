package strings;

public class HighestValuePalindrome {

    private static String highestValuePalindrome(String s, int n, int k) {
        int j = n-1;
        int i = 0;
        String string = s;
        String result = "-1";
        int l=0;
        while (i < n && j > 0) {
            if (string.charAt(i) != string.charAt(j) && l < k) {
                if (string.charAt(i) < '9') {
                    string = s.replace(string.charAt(i), '9');
                } else if (string.charAt(j) < '9'){
                    string = s.replace(s.charAt(j), '9');
                }
                l++;
            } else {
                i++;
                j--;
            }
        }
        return string;
    }

    public static void main(String[] args) {
        int numberOfModification = 1;
        int length = 4;
        String number = "3943";

        int numberOfModification1 = 3;
        int length1 = 6;
        String number1 = "092282";

        System.out.println(highestValuePalindrome(number1, length1, numberOfModification1));
    }
}
