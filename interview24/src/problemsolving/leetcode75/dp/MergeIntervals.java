package problemsolving.leetcode75.dp;

import java.util.*;

public class MergeIntervals {

    private static int[][] merge3(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval: intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[] {start, end});
        return result.toArray(new int[0][]);
    }

    private static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) { //Overlapping, move the end of needed.
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else { // Disjoint intervals, add the new interval to the list.
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * My approach.
     * @param intervals
     * @return
     */
    private static int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        if (intervals.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(intervals[0][0]);
            list.add(intervals[0][1]);
            result.add(list);
            return convertListToArray(result);
        }
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] prev = intervals[i];
            int[] next = intervals[i + 1];
            List<Integer> list = new ArrayList<>();
            if (next[0] <= prev[1]) {
                // merge.
                list.add(prev[0]);
                list.add(next[1]);
            } else {
                list.add(next[0]);
                list.add(next[1]);
            }
            result.add(list);
        }
        return convertListToArray(result);
    }

    private static int[][] convertListToArray(List<List<Integer>> result) {
        int[][] arr = new int[result.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = result.get(i).get(0);
            arr[i][1] = result.get(i).get(1);
        }
        return  arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { {1, 3,}, {2, 6}, {8, 10}, {15, 18} };
        System.out.println(Arrays.deepToString(merge3(arr)));
        int[][] arr1 = new int[][] { {1, 4}, {4, 5} };
        System.out.println(Arrays.deepToString(merge3(arr1)));
        int[][] arr2 = new int[][] { {1, 4}, {5, 6} };
        System.out.println(Arrays.deepToString(merge3(arr2)));
    }
}
