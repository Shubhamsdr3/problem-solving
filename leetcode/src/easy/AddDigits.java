package easy;

public class AddDigits {

    private static int addDigits(int num) {
        String str = String.valueOf(num);
        int result = 0;
        int sum = 0;
        while (str.length() > 1) {
            for (int i =0; i < str.length(); i++) {
                result = result + Character.getNumericValue(str.charAt(i));
            }
            str = String.valueOf(result);
            sum = result;
            result = 0;
        }
        return sum;
    }

    /**
     * In O(1)
     * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
     * @return
     */
    int addDigits1(int num) {
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
