package easy;

public class GoodString {

    private static int countGoodSubstrings(String str) {
        int i = 0;
        int j = i + 3;
        int count = 0;
        while (i < str.length() && j <= str.length()) {
            String subString = str.substring(i, j);
            if (!containsDuplicate(subString)) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }

    private static boolean containsDuplicate(String subString) {
        int[] count = new int[26];
        for (int i = 0; i < subString.length(); i++) {
            count[subString.charAt(i) - 'a']++;
        }
        for (int value : count) {
            if (value > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "aababcabcdbc";
        System.out.println(countGoodSubstrings(str));
    }
}
