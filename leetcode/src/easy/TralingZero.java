package easy;

public class TralingZero {

    private static int trailingZeroes(int n) {
        int numberOf5 = 0;
        int power = 1;
        int temp1 = n;
        while (temp1 > 0) {
            numberOf5 = temp1 /(int)Math.pow(5, power);
            temp1 = temp1 /(int)Math.pow(5, power);
            power++;
        }

        int numberOf2 = 0;
        int power1 = 1;
        int temp2 = n;
        while (temp2 > 0) {
            numberOf5 = temp2 /(int)Math.pow(5, power1);
            temp2 = temp2 /(int)Math.pow(5, power);
            power1++;
        }
        return Math.min(numberOf5, numberOf2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));
    }
}
