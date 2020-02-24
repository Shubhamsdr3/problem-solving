package easy;

import java.util.Map;

public class StraightLine {

    /**
     * check if give co-ordinates lies on a straight line
     * @param coordinates
     * @return
     */
    private static boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float globalSlope = slope(point1, point2);

        for (int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[0];
            float slop = slope(p1, p2);
            if (globalSlope != slop) {
                return false;
            }
        }
        return true;
    }

    private static float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        int[][] coOrdinates = new int[][] {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {7, 7}
        };
        int[][] coOrdinates1 = new int[][] {
                {-3, -2},
                {-1, -2},
                {2, -2},
                {-2, -2},
                {0, -2},
        };
        System.out.println(checkStraightLine(coOrdinates1));
    }
}
