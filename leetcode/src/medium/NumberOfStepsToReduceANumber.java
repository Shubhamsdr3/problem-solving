package medium;
/**
Created at: 10/02/22
*/
//TODO: fixme
public class NumberOfStepsToReduceANumber {

    /**
     * My soln: wrong one :(
     * @param s
     * @return
     */
    private static int numSteps(String s) {
        int decimal = binaryToDecimal(s);
        System.out.println(decimal);
        int steps = 0;
        while (decimal > 1) {
            if (decimal % 2 == 0) {
                decimal = decimal /2;
            } else {
                decimal =  decimal +1;
            }
            steps++;
        }
        return steps;
    }

    private static int numStepsCorrect(String s) {
        int n = s.length();
        int carry = 0;
        int ans = 0;
        for (int i = n -1; i >= 1; i--) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                ans = ans + 2;
            } else  {
                ans = ans + 1;
            }
        }
        return ans + carry;
    }

    private static int binaryToDecimal(String value) {
        int base = 1;
        int decimal = 0;
        char[] arr = value.toCharArray();
        for (int i = arr.length -1; i >= 0; i--) {
            char c = arr[i];
            int digit = Character.getNumericValue(c);
            decimal = decimal + digit * base;
            base = base * 2;
        }
        return decimal;
    }

    public static void main(String[] args) {
        String str = "1111011110000011100000110001011011110010111001010111110001";
        System.out.println(numStepsCorrect(str));
        System.out.println('0' - '0');
    }
}
