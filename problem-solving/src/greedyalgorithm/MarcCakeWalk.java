package greedyalgorithm;

import java.util.Arrays;

public class MarcCakeWalk {

    private static long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        long min = 0;
        int i=0;
        for (int j = calorie.length -1; j >= 0; j--) {
            min = (long) (min +  (Math.pow(2,i) * calorie[j]));
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{7, 4, 9, 6};
        System.out.println(marcsCakewalk(inputArray));
    }
}
