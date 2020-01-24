package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

    // Return the minimum number of characters to make the password strong
    private static int minimumNumber(int n, String password) {
        int count = 0;

        Pattern patternDigit = Pattern.compile("(\\d)");
        Pattern patternUpper = Pattern.compile("([A-Z])");
        Pattern patternLower = Pattern.compile("([a-z])");
        Pattern patternSpecial = Pattern.compile("(\\W)");

        Matcher matcherDigit = patternDigit.matcher(password);
        Matcher matcherUpper = patternUpper.matcher(password);
        Matcher matcherLower = patternLower.matcher(password);
        Matcher matcherSpecial = patternSpecial.matcher(password);

        if (!matcherDigit.find()) {
            count++;
        }

        if (!matcherLower.find()) {
            count++;
        }

        if (!matcherSpecial.find()) {
            count++;
        }

        if (!matcherUpper.find()) {
            count++;
        }
        if ((count+password.length())<6) {
            count = count + 6-(count+password.length());
        }

        return count;
    }

    public static void main(String[] args) {
        int numberOfCharacter = 11;
        String str = "#HackerRank";

        int numberOfCharacter1 = 3;
        String str1 = "Ab1";


        int numberOfCharacter2 = 100;
        String str2 = "G0N1+93Gy0C!J4ECIc53+30O9az$K-TgDO^051y2+Qfvt94qI!k)lS(-8g65^A9mt%eRL5WP#f8R)i4O33j#&LNk6H%-pr-@d^*Z";

        System.out.println(minimumNumber(numberOfCharacter2, str2));
    }

}
