package easy;

import java.util.Arrays;

public class HeightChecker {

    private static int heightChecker(int[] heights) {
        int[] copied = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copied);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copied[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 4, 2, 1, 3};
        int[] arr1 = new int[]{5, 1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(heightChecker(arr2));
    }
}
