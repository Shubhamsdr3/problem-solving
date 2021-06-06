package easy;

public class AddStrings {

    private static String addStrings(String num1, String num2) {
        int m = num1.length() -1;
        int n = num2.length() -1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 && n >= 0) {
            int sum = Character.getNumericValue(num1.charAt(m)) + Character.getNumericValue(num2.charAt(n)) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            m--;
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1, num2));
    }
}
