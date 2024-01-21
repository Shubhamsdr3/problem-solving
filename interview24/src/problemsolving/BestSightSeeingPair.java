package problemsolving;

public class BestSightSeeingPair {

    private static int maxScoreSightseeingPair2(int[] values) {
        int result = 0;
        int current = 0;
       for (int val: values) {
           result = Math.max(result, current + val);
           current = Math.max(current, val) - 1;
       }
       return result;
    }

    /**
     * TLE
     * @param values
     * @return
     */
    private static int maxScoreSightseeingPair(int[] values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int value = values[i] + values[j] + i - j;
                maxValue = Math.max(value, maxValue);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = new int[] { 8, 1, 5,2, 6 };
        int[] values1 = new int[] {1, 2};
        System.out.println(maxScoreSightseeingPair2(values));
    }
}
