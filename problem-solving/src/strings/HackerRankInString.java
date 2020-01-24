package strings;

public class HackerRankInString {

    /**
     * O(n2) solution
     * @param str
     * @return
     */
    private static String hackerrankInString(String str) {
        String pattern = "hackerrank";
        int count = 0;
        String stringLower = str.toLowerCase();
        int index = 0;
        for (int i=0; i < pattern.length(); i++) {
            for (int j=index; j < stringLower.length(); j++) {
                if (pattern.charAt(i) == stringLower.charAt(j)) {
                    index = j +1;
                    count++;
                    break;
                }
            }
        }
        if (count == pattern.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    /**
     * O(n) solution.
     * @param str
     * @return
     */

    private static String hackerrankInString1(String str) {
        String pattern = "hackerrank";
        String stringLower = str.toLowerCase();
        int index = 0;
        for (int i=0; i < pattern.length(); i++) {
            if (index < pattern.length() && stringLower.charAt(i) == pattern.charAt(index)) {
                index ++;
            }
        }
        if (index == pattern.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String string = "hacakaeararanaka";
        String str1 = "hhhhaaaaackkkkerrrrrrrrank";

        String str2 = "crackerhackerknar";

        String str3 = "hhhackkerbanker";

//        System.out.println(hackerrankInString(leetcode.string));
//        System.out.println(hackerrankInString(str1));
        System.out.println(hackerrankInString(str2));
//        System.out.println(hackerrankInString(str3));
    }
}
