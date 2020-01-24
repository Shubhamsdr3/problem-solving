package strings;

public class StringConstruction {

    private static int stringConstruction(String s) {
        return (int) s.chars().distinct().count();
    }

    public static void main(String[] args) {
        String string = "abcd";
        String string1 = "abab";
//        System.out.println(stringConstruction(leetcode.string));
        System.out.println(stringConstruction(string1));
    }
}
