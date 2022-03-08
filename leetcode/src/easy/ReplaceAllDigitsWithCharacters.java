package easy;

public class ReplaceAllDigitsWithCharacters {

    private static String replaceDigits(String s) {
        int even = 0;
        int odd = 1;
        StringBuilder sb = new StringBuilder();
        while (even < s.length() && odd < s.length()) {
            sb.append(s.charAt(even));
            int charToChange = s.charAt(even);
            int nextCharacter =  charToChange + Character.getNumericValue(s.charAt(odd));
            sb.append((char) nextCharacter);
            even = even + 2;
            odd = odd + 2;
        }
        while (even < s.length()) {
            sb.append(s.charAt(even));
            even++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a1c1y";
        System.out.println(replaceDigits(str));
    }
}
