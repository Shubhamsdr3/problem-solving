package easy;

public class MaximumScoreAfterSplittingString {

    private static int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            int sum = numberOf(left, 0) + numberOf(right, 1);
            max = Math.max(sum, max);
        }
        return max;
    }

    private static int numberOf(String str, int value) {
        int count = 0;
        for (char c: str.toCharArray()) {
            if (Character.getNumericValue(c) == value) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "01";
        System.out.println(maxScore(str));
    }
}
