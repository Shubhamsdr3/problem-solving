package sortingproblems;

import java.util.Arrays;

public class FindMedian {

    private static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int medianIndex = arr.length /2;
        return arr[medianIndex];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 4, 6, 5, 3};
        System.out.println(findMedian(arr));
    }
}
