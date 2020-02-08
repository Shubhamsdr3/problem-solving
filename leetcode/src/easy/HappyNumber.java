package easy;

public class HappyNumber {

    private static boolean isHappy(int n) {
        String val = String.valueOf(n);
        return isHappyNumber(val);
    }

    private static boolean isHappyNumber(String val) {
        long sum = 0;
        for (int i = 0; i < val.length(); i++) {
            sum = sum + (long)Math.pow(Character.getNumericValue(val.charAt(i)), 2);
        }
        if (String.valueOf(sum).length() == 1) {
            return sum == 1;
        }
        return isHappyNumber(String.valueOf(sum));
    }

    public static void main(String[] args) {
        int n = 1111111;
        System.out.println(isHappy(n));
    }
}
