package easy;

import java.util.Arrays;

public class DailyTemperature {

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int index = 0;
        for (int i = 0; i < temperatures.length; i++) {
            int num = temperatures[i];
            for (int j = i +1; j < temperatures.length; j++) {
                if (temperatures[j] > num) {
                    result[index] = j - i;
                    index++;
                    break;
                }
                if (j == temperatures.length -1) {
                    result[index] = 0;
                    index++;
                }
            }
        }
        return result;
    }

    /**
     * Effiecient one
     * using stack
     * @param
     */
//    private static int[] dailyTemp(int[] temps) {
//
//    }

    public static void main(String[] args) {
        int[] input = new int[]{55,38,53,81,61,93,97,32,43,78};
        System.out.println(Arrays.toString(dailyTemperatures(input)));
    }
}
