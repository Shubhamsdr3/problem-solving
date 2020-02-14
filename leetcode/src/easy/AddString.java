package easy;

public class AddString {

    //TODO:FIXME
    private static String addStrings(String num1, String num2) {
        if (num1.length() < 2 && num2.length() < 2) {
            return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() -1;
        int j = num2.length() -1;
        while (i >= 0) {
            int sum = Character.getNumericValue(num1.charAt(j)) + Character.getNumericValue(num2.charAt(i)) + carry;
            if (sum > 9) {
                result.append((sum % 10));
                carry = sum / 10;
            } else {
                result.append(sum);
                carry = 0;
            }
            i--;
            j--;
            if (num1.length() != num2.length() && j < (num1.length() - num2.length())) {
                int num = Character.getNumericValue(num1.charAt(j)) + carry;
                result.append(num);
            }
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {
        String str1 = "43435";
        String str2 = "76465";
        System.out.println(addStrings(str1, str2));
    }
}
