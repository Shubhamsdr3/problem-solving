package greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {


    private List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    private void testMethod(List<Integer> newList) {
        this.integerList.clear();
        this.integerList.addAll(newList);
    }

    /**
     * Non- greedy approach.
     */
    private static int minimumAbsoluteDifference(int[] arr) {
        System.out.println("Started....1" + System.currentTimeMillis());
        int min = Integer.MAX_VALUE;
        for (int i=0; i< arr.length; i++) {
            for (int j=i+1; j< arr.length; j++) {
                int diff = Math.abs(arr[j] - arr[i]);
                if (diff < min) {
                    min = diff;
                }
            }
        }
        System.out.println("finished...1" + System.currentTimeMillis());
        return min;
    }

    /**
     * Greedy approach.
     */
    private static int minimumAbsoluteDifference1(int[] arr) {
        System.out.println("Started...2: " + System.currentTimeMillis());
        Arrays.sort(arr);
        int min = Math.abs(arr[0] - arr[1]);
        for (int i = 0; i < arr.length -1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if (diff < min) {
                min = diff;
            }
        }
        System.out.println("finished...2: " + System.currentTimeMillis());
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(2, 4, 5, 6, 7));
        MinimumAbsoluteDifference m = new MinimumAbsoluteDifference();
        m.testMethod(integerList);
        System.out.println(minimumAbsoluteDifference(array));
        System.out.println(minimumAbsoluteDifference1(array));
    }
}
