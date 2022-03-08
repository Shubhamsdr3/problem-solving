package easy;

/**
Created at: 09/02/22
*/
public class CountKDifference {

    /**
     * O(n^2)
      * @param nums
     * @param k
     * @return
     */
    private static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * O(n)
     * @param nums
     * @param k
     * @return
     */
    private static int countKDifference1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        int k =3;
        System.out.println(countKDifference(arr, k));
    }
}
