package strings;

public class GameOfThrone {

    private static String gameOfThrones(String s) {
        int[] chars = new int[26];

        for (char c: s.toCharArray()) {
            chars[c - 97]++;
        }

        boolean isEven = true;

        int count = 0;
        for (int i=0; i < chars.length; i++) {
            if (chars[i] % 2 == 1) {
                count++;
            }
        }

        if (count > 1) {
            isEven = false;
        }
        if (isEven) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        String string = "cdcdcdcdeeeef";
        String string1 = "cdefghmnopqrstuvw";
        String string2 = "aaabbbb";
//        System.out.println(gameOfThrones(leetcode.string));
//        System.out.println(gameOfThrones(string2));
        System.out.println(gameOfThrones(string1));
    }
}
