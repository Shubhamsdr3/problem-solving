package easy;

public class RangeAreCovered {

    private static boolean isCovered(int[][] ranges, int left, int right) {
        boolean isInRange = false;
        for (int i = 0; i < ranges[0].length; i++) {
            int[] arr = ranges[i];
            if (left >= arr[0] && left <= arr[1]) {
                isInRange = true;
            }
            if (right <= arr[1] && right >= arr[1]) {
                isInRange = true;
            }
        }
        return isInRange;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 10}, {10, 20}};
        int left = 21;
        int right = 21;
        System.out.println(isCovered(arr, left, right));
    }
}
