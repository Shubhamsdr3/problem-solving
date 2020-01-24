package strings;

public class AlternatingCharacters {

    private static int alternatingCharacters(String s) {
        int count = 0;
        StringBuilder string = new StringBuilder(s);
        int i=0;
        while (i < string.length() -1) {
            if (string.charAt(i) == string.charAt(i+1)) {
                string.deleteCharAt(i+1);
                count++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "AAABBB";
        String string1 = "AAAA";
        String string3 = "ABABABAB";
        System.out.println(alternatingCharacters(string3));
    }
}
