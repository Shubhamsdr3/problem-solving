package medium;

public class RemovedCoveredIntervals {

    private static int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        for (int i =0; i < intervals.length-1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if (intervals[i] != null) {
                    if ((intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1])) {
                        count++;
                    } else  {
                        intervals[i] = null;
                    }
                }
            }
        }

        for (int i =intervals.length-1; i >= 0 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if (intervals[i] != null && intervals[j] != null) {
                    if(intervals[i][0] >= intervals[i][0] && intervals[i][1] <= intervals[j][1]) {
                        count++;
                    } else {
                        intervals[i] = null;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 4},
                {2, 3}
        };
        System.out.println(removeCoveredIntervals(input));
    }
}
