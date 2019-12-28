package searchalgorithm;

import java.util.Arrays;

/**
 * Improve this using binary search.
 */
public class IceCreamParlor {

    // Complete the iceCreamParlor function below.
    private static int[] iceCreamParlor(int m, int[] arr) {
        int[] result = new int[2];

        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m) {
                    result[k] = i + 1;
                    k++;
                    result[k] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int money = 3;
        int[] cost = new int[]{1, 2};

        System.out.println(Arrays.toString(iceCreamParlor(money, cost)));
    }
}
