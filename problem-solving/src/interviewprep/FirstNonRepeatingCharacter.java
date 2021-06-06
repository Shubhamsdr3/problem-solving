package interviewprep;

public class FirstNonRepeatingCharacter {

    private static String firstNonRepeatingCharacter(String str) {
        for (int i =0; i < str.length(); i++) {
            String c = str.substring(i, i+1);
            String subString = str.substring(i+1);
            if (!subString.contains(c)) {
                return c;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("geeksforgeeks"));
    }
}
