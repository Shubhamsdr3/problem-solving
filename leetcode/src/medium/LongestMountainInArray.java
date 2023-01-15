package medium;

public class LongestMountainInArray {

    private static int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = n -2; i >= 0; --i) {
            down[i] = down[i + 1] + 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] > arr[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
            if (up[i] > 0 && down[i] > 0) {
                res = Math.max(res, up[i] + down[i] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {2,1,4,7,3,2,5};
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        System.out.println(longestMountain(arr));
    }
}
