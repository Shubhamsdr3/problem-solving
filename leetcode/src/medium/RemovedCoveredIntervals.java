package medium;

import java.util.Arrays;
import java.util.Comparator;

public class RemovedCoveredIntervals {

    /**
     *
     * @param intervals
     * @return
     */
    private static int removeCoveredIntervalsImproved(int[][] intervals) {
        int res = 0;
        int left = -1;
        int right = -1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] v: intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                res++;
            }
            right = Math.max(right, v[1]);
            System.out.println("Left: " + left + " right: " + right);
        }
        return res;
    }


    /**
     * (a, b) (c, d)
     * c <= a
     * b <= d
     * TC -> O(n^2)
     * @param intervals
     * @return
     */
    private static int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (i != j) {
                    int[] ab = intervals[i];
                    int[] cd = intervals[j];
                    if ((cd[0] > -1 && ab[0] > -1 && cd[0] <= ab[0]) && (ab[1] > -1 && cd[1] > -1 && ab[1] <= cd[1])) {
                        count++;
                        intervals[i] = new int[]{-1, -1};
                    }
                }
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{
//                {34335, 39239}, {15875, 91969}, {29673, 66453}, {53548, 69161}, {40618, 93111}
//        };
//        System.out.println(removeCoveredIntervals(input)); // ans 2
//        int[][] input1 = new int[][]{
//                {1, 4},
//                {2, 3}
//        };
//        System.out.println(removeCoveredIntervals(input1)); // ans 1
        int[][] input2 = new int[][]{
                {1, 4},
                {3, 6},
                {2, 8}
        };
        System.out.println(removeCoveredIntervalsImproved(input2)); // ans 2
    }
}
