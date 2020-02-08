package recursion;

public class ThePowerSum {

    private static int powerSum(int X, int N) {
       return getSum(1, X, N);
    }

    private static int getSum(int n, int number, int power) {
        if (((int)Math.pow(n, power)) < number) {
            int num1 = getSum(n+1, number, power);
            int num2 = getSum(n+1, (number - (int) Math.pow(n, power)), power);
            return  num1 + num2;
        } else if ((int) Math.pow(n, power) == number) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        int number = 100;
        int power = 2;
        System.out.println(powerSum(number, power));
    }
}
