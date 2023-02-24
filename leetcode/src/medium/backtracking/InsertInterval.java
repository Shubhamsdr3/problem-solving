package medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    private static List<List<Integer>> insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(2);
        for (int i = 0; i < intervals.length; i++) {
            int[] row = intervals[i];
            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                if (num < left || num > right) {
                    list.add(num);
                } else {
                    list.add(Math.min(row[0], left));
                    list.add(Math.max(row[1], right));
                }
            }
            if (list.size() == 2) {
                result.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
        int[] newIntervals = new int[]{ 4, 8 };

        int[][] arr1 = new int[][] { {1, 3}, {3, 9}};
        int[] newIntervals1 = new int[]{ 2, 5 };

        System.out.println(insert(arr1, newIntervals1));
    }
}
