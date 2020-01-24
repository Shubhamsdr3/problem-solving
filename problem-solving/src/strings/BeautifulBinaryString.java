package strings;

public class BeautifulBinaryString {

    private static int beautifulBinaryString(String b) {
        String toMatch = "010";
        int count=0;
        int i=0;
        int j = toMatch.length();
        while (i < b.length() && j <= b.length()) {
            if (b.substring(i, j).equals(toMatch)) {
                count++;
                i = j;
                j = j + toMatch.length();
            } else {
                i++;
                j++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        String string = "0101010";
        String string1= "01100";
        String string2 = "0100101010";
        String string3 = "0101000010011100111110011000001000100101100010000011010111111101110110001110111110110101001011";
        System.out.println(beautifulBinaryString(string2));
    }
}
