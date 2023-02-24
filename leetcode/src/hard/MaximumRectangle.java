package hard;

public class MaximumRectangle {

    /**
     * Using Largest rectangle in histogram.
     * T.C -> O(n * (m + n))
     * S.C -> O(n)
     */
    private static int maximalRectangle(char[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = LargestRectangleInHistogram.largestRectangleAreaUsingStack(heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
