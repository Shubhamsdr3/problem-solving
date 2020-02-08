package easy;

public class DecodeString {

    //TODO:FIXME:ShUBHAM
    private static StringBuilder res = new StringBuilder();
    private static String decodeString(String s) {
        return getStringInsideBracket(s, 0);
    }

    private static String getStringInsideBracket(String string, int index) {
        if (index == string.length()) {
            return res.toString();
        }
        int numberOfCharacter = Character.getNumericValue(string.charAt(index));
        if (string.charAt(index+1) == '[') {
            String stringInsideBracket = getString(string, index+1);
            while (numberOfCharacter > 0) {
                res.append(stringInsideBracket);
                numberOfCharacter--;
            }
            index = index + (stringInsideBracket.length()+2) +1;
        }
        return getStringInsideBracket(string, index);
    }

    private static String getString(String string, int startIndex) {
        StringBuilder res = new StringBuilder();
        int i = startIndex +1;
        while (string.charAt(i) != ']') {
            res.append(string.charAt(i));
            i++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        System.out.println(decodeString(input));
    }
}
