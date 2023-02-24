package interviewprep.array;

public class FindMaxIncreasingDecreasing {

    /**
     * T.C => O(log(N))
     * first increasing then decreasing....
     * @param arr
     * @return
     */
    private static int findMaximum(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid -1] < arr[mid]) { // go right..increasing.
                start = mid + 1;
            } else if (arr[mid -1] > arr[mid]) { // go left..decreasing..
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
        System.out.println(findMaximum(arr));
    }
}
