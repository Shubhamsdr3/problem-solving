package searchalgorithm;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;

public class GridLandMetro {

    // Complete the gridLandMetro function below.
    private static int gridLandMetro(int n, int m, int k, int[][] track) {
        int sum = 0;

        if (k == 0) {
            return  n * m;
        }
        for (int i = 0; i < k -1; i++) {
            int size;
            if (i > 0) {
                if (track[i -1][0] == track[i][0]) {
                    size = mergeIntervals(track);
                    if (size != m) {
                        sum = sum + size;
                    }
                } else {
                    sum = sum + (track[i][2] - track[i][1] + 1);
                }
            }

        }
        return sum;
    }

    private static int mergeIntervals(int[][] intervals) {
        Set<Integer> elements = new LinkedHashSet<>();

        for (int i=0;  i < intervals.length; i++) {
            for (int j=intervals[i][1];  j <= intervals[i][2]; j ++) {
                elements.add(j);
            }
        }
        return elements.size();
    }

    public static void main(String[] args) {
        int numberOfRows = 3;
        int numberOfColumns = 7;
        int numberOfTracks = 4;

        int[][] tracks = new int[][]{
                {1, 1, 3},
                {2, 2, 2},
                {3, 1, 6},
                {3, 6, 6}
        };

        int numberOfRows1 = 4;
        int numberOfColumns1 = 4;
        int numberOfTracks1 = 3;

        int[][] tracks1 = new int[][]{
                {2, 2, 3},
                {3, 1, 4},
                {4, 4, 4},
        };

        int numberOfRows2 = 1;
        int numberOfColumns2 = 5;
        int numberOfTracks2 = 3;

        int[][] tracks2 = new int[][]{
                {1, 1, 2},
                {1, 2, 4},
                {1, 3, 5},
        };

        System.out.println(gridLandMetro(numberOfRows2, numberOfColumns2, numberOfTracks2, tracks2));
    }
}
