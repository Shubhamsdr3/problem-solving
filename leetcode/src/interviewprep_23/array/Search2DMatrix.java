package interviewprep_23.array;

public class Search2DMatrix {

    /**
     * O(log (m * n))
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchMatrixImproved(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }

    /**
     * O(m * n)
     * TLE
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            if (binarySearch(arr, target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target){
                end = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 3}
        };
        int target = 3;
        System.out.println(searchMatrixImproved(input, target));
    }
}
