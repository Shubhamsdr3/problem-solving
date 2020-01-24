package strings;

public class CeaserCipher {

    private static String caesarCipher(String str, int k) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char ch: str.toCharArray()) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (Character.isUpperCase(ch)) {
                    stringBuilder.append((char) ('A' + (ch - 'A' + k) % 26));
                } else if (Character.isLowerCase(ch)) {
                    stringBuilder.append((char) ('a' + (ch - 'a' + k) % 26));
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "middle-Outz";
        int rotation = 2;

        String string1 = "Hello_World!";
        int rotation1 = 4;

        String string2 = "6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr";
        int rotation2 = 87;

        System.out.println(caesarCipher(string2, rotation2));
    }
}
