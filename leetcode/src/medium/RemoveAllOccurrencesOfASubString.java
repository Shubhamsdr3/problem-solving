package medium;

public class RemoveAllOccurrencesOfASubString {

    private static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf(part) >= 0) {
            int start = sb.indexOf(part);
            sb.replace(start, start + part.length(), "");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "axxxxyyyyb";
        String s = "xy";
        System.out.println(removeOccurrences(str, s));
    }
}
