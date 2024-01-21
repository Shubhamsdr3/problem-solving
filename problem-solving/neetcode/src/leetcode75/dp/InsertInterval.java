package leetcode75.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval: intervals) {
//            interval[0] = Math.max(newInterval[0], interval[0]);
            interval[1] = Math.max(newInterval[1], interval[1]);
        }
        return intervals;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { {1, 3}, {6, 9} };
        int[] newArray = new int[] { 2, 5 };


        int[][] arr1 = new int[][] { {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
        int[] newArray1 = new int[] { 4, 8 };
        System.out.println(Arrays.deepToString(insert(arr1, newArray1)));
    }
}
