package medium;

public class MultiplyString {

    private static String multiply1(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] prod = new int[m + n];
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                int d1 = Character.getNumericValue(num1.charAt(i));
                int d2 = Character.getNumericValue(num2.charAt(j));
                prod[i + j + 1] = prod[i + j + 1] + d1 * d2;
            }
        }

        int carry = 0;
        for (int i = prod.length -1; i >= 0; i--) {
            int temp = (prod[i] + carry) % 10;
            carry = (prod[i] + carry) / 10;
            prod[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num: prod) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";
        System.out.println(multiply1(str1, str2));
    }
}
