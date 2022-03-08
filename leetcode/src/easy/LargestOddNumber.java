package easy;

public class LargestOddNumber {

    private static String largestOddNumber(String num) {
        int end = num.length() -1;
        while (end >= 0) {
            int val = Character.getNumericValue(num.charAt(end));
            if (val % 2 != 0) {
                return num.substring(0, end + 1);
            }
            end--;
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "9999998";
        System.out.println(largestOddNumber(str));
    }
}
