public class HourGlassSum {

    /**
     * Think of all the corner cases like what will be the maximum value if we sum of all the hourglass.
     *
     */
    private static final int OFFSET = 2;
    private static final int MAX_SIZE  = 6;
    private static int MAX_VALUE = -63; // Initialize lowest possible sum.

    private static int hourglassSum(int[][] arr) {
        int sum = -1;
        for (int row = 0; row < MAX_SIZE - OFFSET; row ++) {
            for (int col = 0; col < MAX_SIZE - OFFSET; col++) {
                sum = findSum(arr, row, col);
            }
        }
        return sum;
    }

    private static int findSum(int[][] arr, int i, int j) {
        int sum = 0; // 7
        // sum top 3 and bottom 3 elements.
        for(int k = j; k <= j + OFFSET; k++){
            sum = sum +  arr[i][k];
            sum = sum + arr[i + OFFSET][k];
        }

        // sum middle element
        sum = sum +  arr[i + 1][j + 1];

        if(MAX_VALUE < sum){
            MAX_VALUE = sum;
        }
        return MAX_VALUE;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 3, },
                {1, 1, 1},
                {1, 1, 1},
        };

        System.out.println(hourglassSum(arr));
    }
}
