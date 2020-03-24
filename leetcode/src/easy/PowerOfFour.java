package easy;

public class PowerOfFour {

    private static boolean isPowerOfFour(int num) {
        String str = Integer.toBinaryString(num);
        if (num >= 4 && str.charAt(0) == '1' && str.substring(1).contains("0")) {
            return true;
        }
       return false;
    }

    public static void main(String[] args) {
        int num = 8;
        int num1 = 64;
        int num2 = 256;
        int num3 = 1024;
        System.out.println(isPowerOfFour(8));
        isPowerOfFour(num1);
        isPowerOfFour(num2);
        isPowerOfFour(num3);
    }
}
