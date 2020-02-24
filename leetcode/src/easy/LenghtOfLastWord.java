package easy;

public class LenghtOfLastWord {

    private static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length()-1;
        int count = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
               return count;
            }
            count++;
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "a ";
        String string1 = "Hello World";
        System.out.println(lengthOfLastWord(string));
        System.out.println(lengthOfLastWord(string1));
    }
}
