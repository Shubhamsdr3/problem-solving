package problemsolving.leetcode75.prefixSum;

import java.util.Arrays;

public class FindTheHighestAltitude {

    private static int largestAltitude2(int[] gain) {
        int maxGain = 0;
        int currentGain = 0;

        for (int i = 0; i < gain.length; i++) {
            currentGain = currentGain + gain[i];
            maxGain = Math.max(maxGain, currentGain);
        }
        return maxGain;
    }

    private static int largestAltitude(int[] gain) {
        int[] arr = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            arr[i+ 1] = arr[i] + gain[i];
            System.out.println(Arrays.toString(arr));
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(arr[i], maxValue);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -5,1,5,0,-7 };
        int[] arr1 = new int[] {-4,-3,-2,-1,4,3,2 };
        System.out.println(largestAltitude2(arr1));
    }
}
