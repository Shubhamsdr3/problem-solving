package searchalgorithm;

import java.util.Arrays;

public class HackerLandRadioTransmitters {

    // Complete the hackerLandRadioTransmitters function below.
    private static int hackerLandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int count = 0;
        int sum = x[0];
        if (sum == x[x.length - 1]) {
            return 1;
        }
        for (int i = 0; i < x.length; i++) {
            if (sum < x[x.length - 1]) {
                sum = sum + 2 * k;
                count ++;
            }
        }
        return count;
    }

    /**
     * Using Two pointer technique.
     * @param x
     * @param k
     * @return :
     */
    private static int hackerLandRadioTransmitters1(int[] x, int k) {
        Arrays.sort(x);
        int start = x[0];

        return 0;
    }


    public static void main(String[] args) {
        int range = 2;
        int[] locations = new int[]{7, 2, 4, 6, 5, 9, 12, 11};

        int range1 = 3;
        int[] locations1 = new int[]{10, 10, 10};

        System.out.println(hackerLandRadioTransmitters(locations1, range1));
    }
}
