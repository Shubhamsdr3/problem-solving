package easy;

/**
 * Created at: 26/11/22
 */
public class ReplaceAll {

    private static String modifyString(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                for (int j = 0; j < 26; j++) {
                    // test left
                    boolean valid = i <= 0 || j + 'a' != sb.charAt(i - 1);

                    // test right
                    if (i < sb.length() - 1 && sb.charAt(i + 1) != '?' && j + 'a' == sb.charAt(i + 1)) {
                        valid = false;
                    }
                    if (valid) {
                        char ch = (char) (j + 'a');
                        sb.setCharAt(i, ch);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "ubv?w";
        String str1 = "?zs";
        System.out.println(modifyString(str1));
    }
}

