package easy;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    private static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> finalList = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;
        int iteration = 0;

        //FIXME:SHUBHAM fix iteration....
        while (iteration < k) {
            int start = grid[row-1 + iteration][col-1 + iteration];
            int index = 1;
            finalList.add(0, shiftItems(grid[0], start));
            for (int r = 1; r < row; r++) {
                start = grid[r-1][col-1];
                int[] ro = grid[r];
                finalList.add(index, shiftItems(ro, start));
                index++;
            }
            iteration++;
        }
        return finalList;
    }

    private static List<Integer> shiftItems(int[] arr, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        for (int i=1; i <  arr.length; i++) {
            list.add(i, arr[i-1]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(shiftGrid(grid, 2));
    }
}
