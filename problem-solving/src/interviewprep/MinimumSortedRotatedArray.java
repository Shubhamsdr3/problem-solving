package interviewprep;

public class MinimumSortedRotatedArray {

    private static int findMinimumInRotatedArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;

        // The right point from where the array is rotated
        if (mid < right && arr[mid + 1] < arr[mid]) {
            return arr[mid +1];
        }

        // The left point from where the array is rotated
        if (mid > left && arr[mid] < arr[mid -1]) {
            return arr[mid];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                5, 6, 2, 3, 4
        };
        System.out.println(findMinimumInRotatedArray(arr));
    }
}
