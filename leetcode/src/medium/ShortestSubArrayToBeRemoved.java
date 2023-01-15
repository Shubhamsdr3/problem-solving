package medium;

public class ShortestSubArrayToBeRemoved {

    private static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            ++left;
        }
        if (left == arr.length - 1) {
            return 0;
        }
        while (right > left && arr[right - 1] <= arr[right]) {
            --right;
        }
        int ans = Math.min(n - left - 1, right);
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[j] >= arr[i]) {
                ans = Math.min(ans, j - i - 1);
                ++i;
            } else {
                ++j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }
}
