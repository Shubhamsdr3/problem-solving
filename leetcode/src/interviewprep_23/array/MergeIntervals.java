package interviewprep_23.array;

import java.util.*;

public class MergeIntervals {

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] newIntervals = intervals[0];
        result.add(newIntervals);
        for (int[] interval: intervals) {
            if (interval[0] <= newIntervals[1]) { // Overlapping intervals, move the end if needed
                newIntervals[1] = Math.max(newIntervals[1], interval[1]);
            } else {
                newIntervals = interval;
                result.add(newIntervals);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        System.out.println(Arrays.deepToString(merge(arr)));
    }
}
