package easy;

public class ImplementIndexOf {

    private static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int i = 0;
        int j = needle.length();
        while (i < haystack.length() && j <= haystack.length()) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "aaaaa";
        String needle = "bba";
        String str1 = "a";
        String needle1 = "a";
        System.out.println(strStr(str1, needle1));
    }
}
