package easy;

public class WordLength {

    //TODO: fixme
    private static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length) {
            return false;
        }
        for (int i = chars.length-1; i > 0; i--) {
            if (chars[i] == chars[i -1] && !strings[i].equals(strings[i -1])) {
                return false;
            } else if (chars[i] != chars[i -1] && strings[i].equals(strings[i -1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";
        System.out.println(wordPattern(pattern, str));
    }
}
