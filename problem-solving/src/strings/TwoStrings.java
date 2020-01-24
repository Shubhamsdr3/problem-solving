package strings;

public class TwoStrings {

    // Complete the twoStrings function below.
    private static String twoStrings(String s1, String s2) {
        int[] chars = new int[26];
        for (int i=0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
        }

        for (int j=0; j < s2.length(); j++) {
            if (chars[s2.charAt(j) - 'a'] > 0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String string1 = "hi";
        String string2 = "world";
        String string3 = "hell";
        String string4 = "world";
        System.out.println(twoStrings(string3, string4));
    }
}
