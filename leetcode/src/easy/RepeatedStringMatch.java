package easy;

public class RepeatedStringMatch {

    //TODO:SHUBHAm
    private static int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder(A);
        for (int i=0; i < B.length(); i++) {
            if (sb.length() >= B.length() && isSubstring(sb.toString(), B)) {
                return count;
            } else {
                sb.append(A);
                count++;
            }
        }
        return -1;
    }

    private static boolean isSubstring(String str, String pattern) {
        int i= 0;
        int j = pattern.length();
        while (i < str.length() && j <= str.length()) {
            if (str.substring(i, j).equals(pattern)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        String  a = "abcabcabcabc";
        String b = "abac";
        System.out.println(repeatedStringMatch(a, b));
    }
}
