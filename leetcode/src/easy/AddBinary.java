package easy;

import java.util.Map;

public class AddBinary {

    // My approach (:
    private static String addBinary(String a, String b) {
        String minString;
        String maxString;
        if (a.length() > b.length()) {
            maxString = a;
            minString = b;
        } else {
            maxString = b;
            minString = a;
        }
        int min = minString.length()-1;
        int max = maxString.length()-1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (max >= 0 && min >= 0) {
            int sum = Character.getNumericValue(maxString.charAt(max)) + Character.getNumericValue(minString.charAt(min)) + carry;
            if (sum == 0) {
                sb.append(0);
            } else if (sum == 1) {
                sb.append(1);
                if (carry == 1) {
                    carry = 0;
                }
            } else if (sum == 2) {
                sb.append(0);
                carry = 1;
            } else if (sum == 3) {
                sb.append(1);
                carry = 1;
            }
            max--;
            min--;
        }
        while (min < max) {
            int sum = Character.getNumericValue(maxString.charAt(max)) + carry;
            if (sum == 1) {
                sb.append(1);
                if (carry == 1) {
                    carry = 0;
                }
            } else {
                sb.append(0);
            }
            max--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    //Copied
    private static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            // if there is a carry from the last addition, add it to carry
            int sum = carry;

            // we subtract '0' to get the int value of the char from the ascii
            if (j >= 0) {
                sum = sum + b.charAt(j--) - '0';
            }
            if (i >= 0){
                sum = sum + a.charAt(i--) - '0';
            }

            //if sum == 2 or sum == 0 append 0 bcz 1 + 1 = 0  in this case as this is base 2 (just like 1 + 9 is 0 if adding ints in columns)
            sb.append(sum % 2);

            //if sum == 2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithmetic
            carry = sum / 2;
        }
        if (carry != 0) {
            //leftover carry, add it
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1111";
        String b = "111";
        System.out.println(addBinary1(a, b));
    }
}
