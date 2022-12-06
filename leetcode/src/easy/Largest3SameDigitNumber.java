package easy;

/**
Created at: 28/09/22
*/
public class Largest3SameDigitNumber {

    private static String largestGoodInteger(String num) {
        int ans = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if ((num.charAt(i) == num.charAt(i +1)) && (num.charAt(i) == num.charAt(i + 2))) {
                ans = Math.max(ans, num.charAt(i) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (48 + ans));
        }
        return ans != -1 ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String str = "1221000";
        System.out.println(largestGoodInteger(str));
    }
}
