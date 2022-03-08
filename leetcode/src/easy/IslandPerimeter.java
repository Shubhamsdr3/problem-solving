package easy;

public class IslandPerimeter {

    private static int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;
        for (int  i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i < grid.length -1 && grid[i +1][j] == 1) neighbours++;
                    if (j < grid[i].length && grid[i][j+1] == 1) neighbours++;
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(input));
    }
}
