package medium;

/**
 * Created at: 03/12/22
 */
public class NumberOfWaysToSplitArray {

    private static int waysToSplitArray(int[] nums) {
        int MOD = (int) (1e9 + 7);
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            arr[i] = arr[i -1] + nums[i];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i -1] > (arr[n -1] - arr[i -1])/ 2) break;
            int left = helper(arr, arr[i -1], i , true);
            int right = helper(arr, arr[i -1], i , false);
            if (left == -1 || right == -1) continue;
            res = (res + (right - left + 1) % MOD) % MOD;
        }
        return res;
    }

    private static int helper(int[] arr, int leftSum, int index, boolean searchLeft) {
        int n = arr.length;
        int left = index;
        int right = n -2;
        int res = -1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            int midSum = arr[m] - arr[index - 1];
            int rightSum = arr[n -1] - arr[m];
            if (leftSum <= midSum && midSum <= rightSum) {
                res = m;
                if (searchLeft) right = m -1;
                else left = m + 1;
            } else if (leftSum > midSum) {
                left = m + 1;
            } else {
                right = m -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 5, 0};
        System.out.println(waysToSplitArray(arr));
    }
}
