package medium;

public class MaximumSwap {

    // wrong algorithm
    private static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int first = Character.getNumericValue(chars[i]);
            int max = Integer.MIN_VALUE;
            int maxIndex = i;
            if (i < chars.length -1) {
                for (int j = i + 1; j < chars.length; j++) {
                    int second = Character.getNumericValue(chars[j]);
                    if (second > max) {
                        max = second;
                        maxIndex = j;
                    }
                }
                if (max > first && maxIndex <= chars.length -1) {
                    int temp = chars[i];
                    chars[i] = chars[maxIndex];
                    chars[maxIndex] = (char) temp;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(c);
        }
        return Integer.parseInt(sb.toString());
    }

    private static int maximumSwapCorrect(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] maxIdx = new int[n];
        int maxPos = n -1;
        maxIdx[n -1] = maxPos;
        // right to left
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIdx[i + 1]]) {
                maxPos = i;
            }
            maxIdx[i] = maxPos;
        }

        // left to right
        for (int i = 0; i < n; i++) {
            if (digits[i] != digits[maxIdx[i]]) {
                char temp = digits[maxIdx[i]];
                digits[maxIdx[i]] = digits[i];
                digits[i] = temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(digits));
    }

    public static void main(String[] args) {
        int num = 98368;
        int num1 = 2736;
        int num2 = 1993;
        System.out.println(maximumSwapCorrect(num2));
    }
}
