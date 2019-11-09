package greedyalgorithm;

import java.util.Arrays;

public class MaximumPerimeterTriangle {

    /**
     * To make a triangle below three equalities should be true.
     * a + b > c
     * a + c > b
     * b + c > a
     */
    private static int[] maximumPerimeterTriangle(int[] sticks) {
        int[] result = new int[3];
        Arrays.sort(sticks);
        Arrays.fill(result, -1);
        for (int i = 0; i < sticks.length -2; i++) {
            if (sticks[i] + sticks[i + 1] > sticks[i + 2]) {
                result[0] = sticks[i];
                result[1] = sticks[i + 1];
                result[2] = sticks[i + 2];
            }
        }
        for (int val: result) {
            if (val == -1) {
                return new int[]{-1};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 9, 2, 15, 3};
        System.out.println(Arrays.toString(maximumPerimeterTriangle(input)));
    }

}
