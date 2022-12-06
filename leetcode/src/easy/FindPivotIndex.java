package easy;

public class FindPivotIndex {

    private static int pivotIndex(int[] nums) {
        int pivotIndex = 0;
        // get the left sum
        while (pivotIndex < nums.length) {
            int leftMost = 0;
            for (int i = 0; i < pivotIndex; i++) {
                leftMost = leftMost + nums[i];
            }
            // get right sum
            int rightMost = 0;
            for (int i = pivotIndex + 1; i < nums.length; i++) {
                rightMost = rightMost + nums[i];
            }
            if (leftMost == rightMost) {
                return pivotIndex;
            }
            pivotIndex++;
        }
        return -1;
    }

    /**
     * (total - pivot) == left sum  + right sum
     *  if(sum(numbers to left of pivot) == sum(numbers to right of pivot))
     *  then -> 2 * sum of right
     *  thus 2 * sum of right == total - pivot.
     * @param nums
     * @return
     */
    private static int pivotIndex1(int[] nums) {
        int total = 0;
        for (int num: nums) {
            total = total + num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum * 2 == total + nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{2, 1, -1};
        System.out.println(pivotIndex1(arr));
    }
}
