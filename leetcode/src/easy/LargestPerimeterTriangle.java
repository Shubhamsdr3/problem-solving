package easy;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    /**
     * A triangle can be formed if the
     * sum of two smaller sides is greater than largest side.
     *
     * @param nums
     * @return
     */
    private static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 2};
        int[] arr1 = new int[]{1, 2, 1};
        int[] arr2 = new int[]{2, 1, 2, 6, 4, 7, 5};
        int[] arr3 = new int[]{3, 2, 3, 4};
        System.out.println(largestPerimeter(arr));
        System.out.println(largestPerimeter(arr1));
        System.out.println(largestPerimeter(arr2));
        System.out.println(largestPerimeter(arr3));
    }
}
