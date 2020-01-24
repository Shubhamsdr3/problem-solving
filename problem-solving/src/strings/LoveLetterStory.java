package strings;

public class LoveLetterStory {

    private static int theLoveLetterMystery(String s) {
        int i=0;
        int j = s.length() -1;
        int sum = 0;
        while (i < s.length() && j > 0 && i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                sum = sum + Math.abs(s.charAt(i) - s.charAt(j));
            }
            i++;
            j--;
        }
        return sum;
    }

    public static void main(String[] args) {
        String string = "abcd";
        String string1 = "cba";
        String string2 = "abcba";
        String string3 = "abc";
        System.out.println(theLoveLetterMystery(string3));
    }
}
