package medium.dp;

public class HouseRobber2 {

    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob0(nums), rob1(nums));
    }

    // if we chose the first , we won't chose the last one.
    private static int rob0(int[] arr) {
        int preMax = 0;
        int currMax = 0;
        for (int i = 0; i < arr.length -1; i++) {
            int t = currMax;
            currMax = Math.max(preMax + arr[i], currMax);
            preMax = t;
        }
        return currMax;
    }

    // If we chose the second one we can chose the last one.
    private static int rob1(int[] arr) {
        int preMax = 0;
        int currMax = 0;
        for (int i = 1; i < arr.length; i++) {
            int t = currMax;
            currMax = Math.max(preMax + arr[i], currMax);
            preMax = t;
        }
        return currMax;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 1 };
        int[] arr1 = new int[] { 2, 3, 2 };
        System.out.println(rob(arr1));
        System.out.println(rob(arr));
    }
}
