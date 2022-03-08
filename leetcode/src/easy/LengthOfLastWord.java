package easy;

public class LengthOfLastWord {

    private static int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String[] strings = s.split(" ");
        int length = strings[0].length();
        for (String str: strings) {
            if (str.length() > length) {
                length = str.length();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "Today is a nice day";
        System.out.println(lengthOfLastWord(str));
    }
}
