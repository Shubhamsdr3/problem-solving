package easy;

public class SubSumAndProduct {

    private static int subtractProductAndSum(int n) {
        String string = String.valueOf(n);
        long product = 1;
        long sum = 0;
        for (int i=0; i < string.length(); i++) {
            product = product * Character.getNumericValue(string.charAt(i));
            sum = sum + Character.getNumericValue(string.charAt(i));
        }
        return (int) (product - sum);
    }

    public static void main(String[] args) {
        int n  = 234;
        System.out.println(subtractProductAndSum(n));
    }
}
